# video-streaming

+ https://trello.com/b/GEEHwMOX/toy-project-01

## note
* 현재 네이버 tv는 공개 api를 제공하지 않아서 웹 스크래핑으로 정보를 긁어와야 함
* 검색 시 마크업 구조 
    + ex) https://tv.naver.com/search/clip?query=google&isTag=false
        ```html
	    <div class="thl ">
            <div class="thl_a">
                <a class="cds_thm" href="[상세링크]" title="[영상제목]">
                    <img src="[썸네일이미지]" data-aflag="false" alt="[영상제목]">
                    <span class="tm_b">[재생시간]</span>
                </a>
                <div class="inner">
                    <dl>
                        <dt><a href="[상세링크]" title="[영상제목]">[영상제목]</a></dt>
                        <dd>
                            <span class="ch_txt"><a href="[채널주소]" title="[채널 명]">[채널 명]</a></span>
                            <span class="cds_ifc cnp"><span class="blind">재생 수</span>[재생 수]</span>
                            <span class="cds_ifc bch"><span class="blind">좋아요 수</span>[좋아요 수]</span>
                            <time>[업로드 날짜]</time>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
        ```
    + 얻을 수 있는 정보
        - 상세링크, 영상제목, 썸네일이미지주소, 채널주소, 채널명, 재생수, 좋아요수, 업로드날짜

## 첨부파일 저장 구조
* 동영상과 썸네일은 동일한 파일명으로 저장한다.
* 동영상 파일 위치 : upload/video/날짜/
* 썸네일 파일 위치 : upload/img/날짜/
