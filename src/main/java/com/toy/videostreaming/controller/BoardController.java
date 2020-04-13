package com.toy.videostreaming.controller;

import com.toy.videostreaming.domain.Board;
import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.domain.Video;
import com.toy.videostreaming.service.BoardService;
import com.toy.videostreaming.service.VideoService;
import com.toy.videostreaming.support.MemberLogics;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    VideoService videoService;

    @Autowired
    private Environment env;

    // 파일 업로드 경로 설정
    private static String SAVE_PATH;

    @PostConstruct
    public void init() {
        SAVE_PATH = env.getProperty("video.save-path");
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Board> boardList = boardService.listAll(null);
        model.addAttribute("boardList",boardList);
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String word, Model model) {
        List<Board> boardList = boardService.getListByTitle(word);
        model.addAttribute("boardList",boardList);
        return "index";
    }

    @RequestMapping("/search/naver")
    public String searchNaver(@RequestParam("query") String query, Model model)
            throws IOException {

        Document document = Jsoup.connect("https://tv.naver.com/search/clip?query="+query+"&isTag=false").get();
        Elements elements = document.select("div.thl_a");

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();

        for(Element el : elements) {
            HashMap<String, String> tmp = new HashMap<>();
            tmp.put("link","https://tv.naver.com" + el.select("a.cds_thm[href]").attr("href"));
            tmp.put("title",el.select("a.cds_thm[title]").attr("title"));
            tmp.put("img",el.select("img[src]").attr("src"));

            list.add(tmp);
        }

        model.addAttribute("naverResult",list);

        return "naver_view";
    }

    @GetMapping("/attach/{vno}")
    public String readFile(@PathVariable int vno, HttpServletResponse response) throws IOException {
        if ( vno <= 0 ) { return null; }

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

    @GetMapping("/play/{bno}")
    public StreamingResponseBody playVideo(@PathVariable int bno) throws FileNotFoundException {
        Board board = boardService.getOne(bno);
        Video video = videoService.getOne(board.getVideoNo());

        File file = new File(SAVE_PATH+"video/"+video.getFilePath()+"/"+video.getFileName());
        InputStream inputStream = new FileInputStream(file);

        return outputStream -> {
            byte[] data = new byte[2048];
            int read = 0;
            while ((read = inputStream.read(data)) > 0) {
                outputStream.write(data, 0, read);
            }
            outputStream.flush();
        };

    }

    @GetMapping("/board/write")
    public ModelAndView boardWrite(HttpSession session) {
        ModelAndView view = new ModelAndView();

        Member memInfo = MemberLogics.getMemberInfo(session);

        if(memInfo == null) {
            view.addObject("responseMessage","로그인 후 이용하시기 바랍니다.");
            view.setViewName("/login");
        }
        else {
            view.setViewName("/board_w");
        }

        return view;
    }

    @PostMapping("/board/add")
    public ModelAndView boardAdd(Board board,
                                 @RequestParam(name = "filename") MultipartFile uploadFile,
                                 HttpSession session,
                                 RedirectAttributes attributes) {

        String responseMessage = "";

        Member memInfo = MemberLogics.getMemberInfo(session);

        // 첨부파일 업로드
        Video video = getVideoInfo(uploadFile, new Video());
        int videoNo = videoService.add(video);

        if (videoNo < 1) {
            responseMessage = "첨부파일 업로드 실패입니다.";
            return new ModelAndView("board_w","responseMessage",responseMessage);
        }

        int rs = boardService.add(board, videoNo, memInfo.getMemId());

        if (rs < 1) {
            responseMessage = "게시글 등록 실패입니다.";
        } else {
            responseMessage = "게시글 등록 성공입니다.";
        }

        RedirectView view = new RedirectView("/");
        attributes.addFlashAttribute("responseMessage",responseMessage);

        return new ModelAndView(view);
    }

    // 첨부파일 처리
    public Video getVideoInfo(MultipartFile file, Video video) {
        String newFilePath = DateFormatUtils.format(new Date(), "yyyyMMdd");
        String newFileName = DateFormatUtils.format(new Date(), "HHmmss");

        String originFile = file.getOriginalFilename();
        String originFileName = originFile.split("\\.")[0];
        String extension = originFile.split("\\.")[1];

        try {
            // 동영상 저장
            if (!saveFile(file, makeDir("video",newFilePath), newFileName)) {
                return null;
            }

            // 썸네일 저장
            if (!saveThumbnail(file, makeDir("img",newFilePath), newFileName)) {
                return null;
            }
        } catch (IOException | JCodecException e) {
            throw new RuntimeException(e);
        }

        video.setOriginFileName(originFileName);
        video.setExtension(extension);
        video.setFilePath(newFilePath);
        video.setFileName(newFileName);
        return video;
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
        File srcFile = new File(saveFilePath.replace("img","video")+"/"+saveFileName);
        source.transferTo(srcFile);

        File thumbnail = new File(saveFilePath+"/"+saveFileName);

        Picture picture = FrameGrab.getNativeFrame(srcFile, 0);

        BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
        ImageIO.write(bufferedImage, "png", thumbnail);

        if(thumbnail.exists() && thumbnail.length()>1) {
            return true;
        }

        return false;
    }
}
