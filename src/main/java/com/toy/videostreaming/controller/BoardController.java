package com.toy.videostreaming.controller;

import com.toy.videostreaming.domain.Board;
import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.domain.Video;
import com.toy.videostreaming.service.BoardService;
import com.toy.videostreaming.service.VideoService;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    VideoService videoService;

    // 파일 업로드 경로 설정
    private static final String SAVE_PATH = "C:\\Users\\Suhee\\Documents\\GitHub\\video-streaming\\upload\\";

    @RequestMapping("/list")
    public String index(Model model) {
        List<Board> boardList = boardService.listAll();
        model.addAttribute("boardList",boardList);
        return "list";
    }

    @RequestMapping("/attach/{vno}")
    public String readFile(@PathVariable int vno, HttpServletResponse response) throws IOException {
        if(vno==0) { return null; }

        // 썸네일 가져오기
        Video video = videoService.getOne(vno);

        response.setContentType( "image/gif" );
        ServletOutputStream bout = response.getOutputStream();
        String thumbnail = SAVE_PATH + "img/" + video.getFilePath() + "/" + video.getFileName();

        FileInputStream file = new FileInputStream(thumbnail);
        int length;
        byte[] buffer = new byte[10];
        while ( ( length = file.read( buffer ) ) != -1 )
            bout.write( buffer, 0, length );
        return null;
    }

    @RequestMapping("/board/write")
    public String boardWrite() {
        return "board_w";
    }

    @RequestMapping("/board/add")
    public ModelAndView boardAdd(Board board,
                                 @RequestParam(name = "filename") MultipartFile uploadFile,
                                 HttpSession session) {

        ModelAndView view = new ModelAndView();

        Member memInfo = (Member) session.getAttribute("memInfo");

        // 첨부파일 업로드
        int videoNo = uploadVideo(uploadFile, memInfo.getMemId());

        if(videoNo<1) {
            view.addObject("responseMessage","첨부파일 업로드 실패입니다.");
            view.setViewName("board_w");
            return view;
        }

        int rs = boardService.add(board,videoNo,memInfo.getMemId());

        if(rs<1) {
            view.addObject("responseMessage","게시글 등록 실패입니다.");
        }
        else {
            view.addObject("responseMessage","게시글 등록 성공입니다.");
        }

        view.setViewName("main");

        return view;
    }

    // 첨부파일 처리
    public int uploadVideo(MultipartFile file, String memId) {

        SimpleDateFormat ymd = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat hms = new SimpleDateFormat("HHmmss");
        String newFilePath = (String) ymd.format(new Date());
        String newFileName = (String) hms.format(new Date()) + "_" + memId;

        String originFile = file.getOriginalFilename();
        String originFileName = originFile.split("\\.")[0];
        String extension = originFile.split("\\.")[1];

        try {
            // 동영상 저장
            if(!saveFile(file, makeDir("video",newFilePath), newFileName)) {
                return 0;
            }

            // 썸네일 저장
            if(!saveThumbnail(file, makeDir("img",newFilePath), newFileName)) {
                return 0;
            }
        }
        catch (IOException | JCodecException e) {
            throw new RuntimeException(e);
        }

        // DB 등록
        Video video = new Video();

        video.setOriginFileName(originFileName);
        video.setExtension(extension);
        video.setFilePath(newFilePath);
        video.setFileName(newFileName);
        return videoService.add(video);
    }

    // 파일 저장경로
    private String makeDir(String type, String saveFilePath) {
        File directory = new File(SAVE_PATH + type + "/" + saveFilePath);

        if(!directory.exists()) {
            directory.mkdirs();
        }

        return directory.toString();
    }

    // 동영상 저장
    private boolean saveFile(MultipartFile multipartFile, String saveFilePath, String saveFileName)
            throws IOException {

        byte[] data = multipartFile.getBytes();
        FileOutputStream fos = new FileOutputStream(saveFilePath + "/" + saveFileName);
        fos.write(data);
        fos.close();

        return true;
    }

    // 썸네일 저장
    public boolean saveThumbnail(MultipartFile source, String saveFilePath, String saveFileName)
            throws IOException, JCodecException {

        // 파일 변환
        File srcFile = new File(saveFilePath.replace("img","video")+"/"+source.getOriginalFilename());
        source.transferTo(srcFile);

        File thumbnail = new File(saveFilePath+"/"+saveFileName);

        Picture picture = FrameGrab.getNativeFrame(srcFile, 0);

        BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
        ImageIO.write(bufferedImage, "png", thumbnail);

        if(thumbnail.exists() && thumbnail.length()>1) {
            // 임시 생성 파일 삭제
            srcFile.delete();

            return true;
        }

        return false;
    }
}
