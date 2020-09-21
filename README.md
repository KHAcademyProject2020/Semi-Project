> # KH Semi 프로젝트

> ## 팀명: <b>GoodBall</b>
>> 팀주제: 풋살 경기장 대관 및 풋살팀 관리 시스템
<br>

> ## 팀원
  - <b>최은강</b>(조장)
  - <b>김용연</b>
  - <b>유정하</b>
  - <b>정규동</b>
  - <b>정창섭</b>
  - <b>하민재</b>

<br>

> ## [최종 코드](./04_FinalCodes)

<BR>
  
> ## 사용 기술 스택
>> ### 사용 언어
>  - FE(Front End)
>    - JSP
>    - CSS
>    - Javascript
>    - jQuery
>    
>  - BE(Back-End)
>    - Language: Java, Ajax
>    - WAS(Web-Application-Server): Apache Tomcat 9.0
>    - Database
>      - RDBMS: Oracle 11g XE
>    - Developer tool
>      - Java: Eclipse
>      - Oracle: SQL-Developer
>
>  - 사용 디자인 패턴: **MVC 패턴**
>
>
>>  ### 사용한 오픈 API
>  - Swipper
>  - BootStrap
>  - 카카오 주소 찾기 API
>  - FontAwesome
<br><br>

> ## 프로젝트 기능 구현

- ### **최은강**
  - 반응형 웹 ui적용 (Responsive Web UI)
    - 반응형 navigation bar
    - 공지사항 게시판
    
  - 메인 페이지 뷰
  - 공지사항 게시판(FE/BE)
    - 게시글 등록
    - 게시글 수정
    - 게시글 삭제
    - 게시글 조회 & 게시글 상세조회(게시글 1개보기)
    - 메인페이지에 가장 최근 공지사항 게시글 5개 보여주기(FE/BE: Ajax)
     
  - 예약페이지(FE)
    - 예약 날짜별 시간대별 동적 UI작성
    - 예약 시간 선택 UI작성
    - 지점 리뷰 별점 수정 (BE)

- ### **정창섭**
  - RDBMS 데이터베이스 모델링
    - ### [**RDBMS 모델링 최종- ERD Cloud**](https://www.erdcloud.com/d/McYBm6tMtH6EpcwHz)
  - "매치 찾기" 게시판
    - 매치 등록
    - 매치 검색
    - 매치 상세검색
    
  - "구장 예약" 게시판
    - 구장 상세페이지
      - 구장 검색
      - 구장 상세검색
      - 예약페이지(BE)
      - 구장 리뷰(FE/BE)
      
  - 팀 게시판
    - 팀 리스트 조회
    - 팀 상세 검색
    - 1개팀 상세페이지 (FE/BE)
      - 팀정보 (팀장만 조회가능)
      - 용병지원 (팀장만 조회가능)
      - 매치 신청 (팀장만 조회가능)
      - 가입된 팀원정보 조회(모두 조회가능)
      
- ### **정규동**
  - 마이페이지 (일반회원/ 풋살 매니저)
    - 공통(일반회원/ 매니저회원 모두)
      - 개인정보
        - 회원 정보 수정
        - 회원탈퇴
      
    - 일반회원
      - 팀정보
        - 소속팀 조회(최대 3개 가입 가능), 소속팀 탈퇴
      - 구장 예약 현황
      
    - 매니저회원
      - 내 지점 정보
        - 내 지점 (내가 등록한 지점을 조회)
        - 지점 등록 (등록된 지점은 "구장 예약 게시판"에 등록됨)
      
      - 예약 현황
        
  
- ### **김용연**
  - 로그인 페이지
  - 회원가입 페이지
  - 아이디 찾기
  - 비밀번호 찾기
  - 암호화 Filter & Wrapper (SHA512)
 
  
- ### **하민재**
  - 예약페이지 UI : 달력
  - [참고 블로그](https://medium.com/@wooder2050/%EB%B0%94%EB%8B%90%EB%9D%BC%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%EB%A1%9C-%EB%8B%AC%EB%A0%A5-calendar-todo-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-f635ef8cce76)

- ### **유정하**
  - 메인페이지에 가장 최근 공지사항 게시글 5개 보여주기(BE: Service, DAO에서 일부 함수 구현)


<br><br>

> ## 팀원별 구현코드

- ### 최은강
  - #### Responsive Navigation UI
    - Frontends (JSP, CSS)
      - [공통 네비게이션 - navbar.jsp](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/common/navbar.jsp)
      
      - [공통 네비게이션 - navbar_css.css ](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/css/navbar_css.css)
      
      - [공통 네이게이션 - navbar.js](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/js/navbar_js.js)
      
      
      
  - #### Footer UI
    - Frontends (JSP, CSS)
      - [공통 footer - footer.jsp](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/common/footer.jsp)
      - [공통 footer- footer.css](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/css/navbar_css.css)
      
      
      
  - #### 메인페이지
    - Frontends (JSP, CSS)
      - [메인페이지 JSP](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/index.jsp)
      - [메인페이지 CSS](./master/04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/css/index_main.css)
      - [메인페이지 jQuery Code](https://github.com/KHAcademyProject2020/Semi-Project/blob/master/04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/js/index_main.js)
      
    
  - #### 공지사항 게시판
    - Backends (Java)
      - model
        - [Board.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/model/vo/Board.java)
        - [BoardAttachment.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/model/vo/BoardAttachment.java )
        - [PageInfo.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/model/vo/PageInfo.java)
        - [BoardService.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/model/service/BoardService.java )
        - [BoardDAO.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/model/dao/BoardDAO.java)
    
      - controller(servlet)
        - [BoardListServlet.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/controller/BoardListServlet.java)
        - [DeleteBoardServlet.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/controller/DeleteBoardServlet.java)
        - [DetailBoardServlet.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/controller/DetailBoardServlet.java)
        - [InsertBoardFormSerlvet.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/controller/InsertBoardFormServlet.java)
        - [InsertBoardServlet.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/controller/InsertBoardServlet.java )
        - [ShowBoardList.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/controller/ShowBoardList.java)
        - [UpdateBoardFormServlet.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/controller/UpdateBoardFormServlet.java)
        - [UpdateBoardServlet.java](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/controller/UpdateBoardServlet.java)
        
    - Frontends (View : JSP/ CSS/ Vanilla JS)
      - [boardDetail.jsp](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/board/boardDetail.jsp)
      - [boardList.jsp](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/board/boardList.jsp)
      - [boardUpdateForm](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/board/boardUpdateForm.jsp)
      - [boardWriter](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/board/boardWriter.jsp)
      
      - [boardDetail.css](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/css/boardDetail.css)
      - [boardList.css](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/css/boardList.css)
      - [boardWriter.css](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/css/boardWriter.css)
      
      
  - 예약 UI (Frontend - review UI 를 제외한 나머지)
    - Frontends (View: JSP/ CSS/ Vanilla JS)
      - [예약페이지 (리뷰제외) -UI](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/reservation/GB_frame_reservation.jsp)
      - [리뷰별점 수정]()
      
      - [stadium_reservation.css](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/css/stadium_reservation.css)
      - [time_slider.css](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/css/time_slider.css)
  
  
<br>

- ### 정창섭
  - #### 팀 찾기 게시판
    - [team-Front-ends](./Semi-Project/tree/master/04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/team/)
    - [team-Back-ends](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/team/)
    
  - #### 구장 예약 게시판
    - [Front-ends](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/stadium/)
    - [Back-ends](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/reservation/)
    
    - #### 구장 상세페이지
      - [review- FE](https://github.com/KHAcademyProject2020/Semi-Project/blob/master/04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/reservation/GB_frame_reservation.jsp#L714-L764)
      
      - [review- AJAX](https://github.com/KHAcademyProject2020/Semi-Project/blob/master/04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/reservation/GB_frame_reservation.jsp#L1273-L1452)
      - []()
      - []()
    
  - #### 매치찾기
    - [Front-ends](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/match/)
    - [Back-ends]()

<br>

- ### 정규동
  - #### 마이페이지(일반회원)
    - [front-end](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/member/general/)
    - [back-end]()
      
  - #### 마이페이지(매니저회원)
    - [front-end](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/member/manager/)
    - [back-end]()
   
<br>

- ### 김용연
  - #### 로그인
    - [로그인 FE]()
  - #### 회원가입
    - [회원가입 FE](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/member/memberShipForm.jsp)
    
  - #### 암호화
    - [암호화 필터 BE](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/filter/)
    - [암호화 wrapper BE](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/wrapper/)
    
  - #### 에러 메시지
    - [에러메시지]()
    
  - #### 아이디 찾기
    - [아이디찾기 FE](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/member/find_email.jsp)
    - [아이디 찾기 성공 결과화면](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/member/searchEmail.jsp)
    - [아이디찾기 BE]()
    
  - #### 비밀번호 찾기
    - [비밀번호 찾기 FE](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/member/find_password.jsp)
    - [비밀번호 찾기 성공 결과화면](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/WEB-INF/views/member/searchPassword.jsp)
    - [비밀번호 찾기 BE]()

<br>

- ### 하민재
  - #### Calendar UI
    - [calendar.css](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/css/calendar.css)
    - [calendar.js](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/WebContent/resources/js/calendar.js)


<br>

- ### 유정하
  - #### 공지사항 게시판 - (BE: 일부기능 구현) 최근 5개 공지사항게시판 불러오기
    - BE
      - java코드
        - [BoardService.java 의 selectList()함수 구현](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/model/service/BoardService.java#L62)
        - [BoardDAO.java 의 selectList()함수 구현](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/board/model/dao/BoardDAO.java#L231)
      - SQL
        - [showMainTop5 쿼리문 작성](./04_FinalCodes/PROJECT_Codes/SEMI_GoodBall_CEK_ver02/src/sql/board/board-query.properties#L10)




> # 결과물

> ## 메인화면

![](./imgs/mainpage_login.png)

<br>

> ## 마이페이지
>> ## 공통

- 회원정보 수정

![](./imgs/mypage_member_edit_info.png)

<br>

- 회원탈퇴

![](./imgs/mypage_member_withdraw.png)

<br>



>> ## 일반회원 

- 소속팀 (최대 3개)

![](./imgs/mypage_general_myteam.png)

<br>

- 구장 예약(입금) 현황

![](./imgs/mypage_general_reservation.png)

<br><br>

>> ## 매니저 회원

- 이해를 위한 팁
  - 지점이 구장보다 더 큰 단위입니다.
  - 지점 하나 당 여러개 구장을 가질 수 있습니다..

<BR>

- 등록된 지점/구장 조회

![](./imgs/mypage_manager_enrolled_branches.png)

<BR>

- 지점 등록하기

![](./imgs/mypage_manager_enroll_branch.png)


> ## 공지사항 게시판


![](./imgs/noti.png)


> ## 공지사항 상세 페이지(이미지 포함)


![](./imgs/noti_detail_img.png)

<br>

- 이해를 위한 팁
  - 회원유형은 총 3 종류입니다.
    - 일반회원(G)
    - 매니저회원(M)
    - 관리자회원(R)
  - 공지사항 게시글의 작성/수정/삭제은 관리자회원만 가능합니다.

- ### 공지사항 게시판(관리자회원)

![](./imgs/noti_admin.png)

<BR>  
  
- 공지사항 등록

![](./imgs/noti_insert.png)

<BR>

![](./imgs/noti_insert_fullscreen.png)

<br>

- 공지사항 상세페이지

![](./imgs/noti_detail_admin.png)


<br><br>

> ## 구장 예약 게시판


![](./imgs/stadium.png)

<br>

>> ## 구장 상세 검색

![](./imgs/stadium_search.PNG)

<br>

>> ## 예약 상세 페이지

<br>

![](./imgs/stadium_detail.png)

<br>

>> ## 예약 상세페이지 - smoothe scrolling navigation bar(top fixed navigation bar)

- 맨위로 올라가면 top fixed navigation bar가 사라짐
- 마우스의 스크롤링의 위치에따라 따라서 부드럽게 나타나고 부드럽게 사라진다.

![](./imgs/stadium_detail_scrolling.JPG)

<br>

>> ## 예약 시간 선택

![](./imgs/goodball_reservation.gif)


<br><br>

> ## 매치 찾기 게시판


![](./imgs/match.png)

<br>

> ## 매치 상세 검색(modal)

![](./imgs/match_modal.JPG)


<br><br>

> ## 팀찾기 게시판

![](./imgs/team.png)

<br>

>> ## 팀 상세 게시판

- 팀은 회원 한명당 총 세개의 팀만 가입이 가능하다.
- 팀은 중복해서 지원할 수 없다.

![](./imgs/team_detail.png)

<br>

- 팀장이 아니거나 비회원일 때 
  - 팀장이 아닌 회원은 팀 정보, 용병 지원, 매치 신청 내역을 볼 수 없다.
  
<BR>   
  
![](./imgs/team_detail_not_manager.png)

<br>

![](./imgs/team_detail_not_manager_show_match.PNG)

<BR>

- 용병지원

![](./imgs/team_enroll_member.PNG)

<br>

- 동알한 계정으로 두번이상 중복해서 용병지원을 할 수 없다.

![](./imgs/enroll_team_blocked_twice.png)



- 팀장회원일 때




<br><br>

> ## RDBMS SQL

- Contributors: **정창섭(@werty12123)**, **최은강(@loveAlakazam)**, **정규동(@JungKyuDong)**, **김용연(@kimyongyoen)**

- [SQL 전체쿼리문](./04_FinalCodes/DB_SQL_FILE/GoodBall_Total_sql.sql)


<br>


<BR><BR>

> ## 프로젝트 진행 계획


> ## 진행과정

|과정|시작기간|종료기간|
|:--:|:--:|:--:|
|기획회의|2020/07/24|2020/07/29|
|UI화면회의|2020/07/30|2020/08/05|
|DB설계회의|2020/08/06|2020/08/09|
|SEMI프로젝트 구현기간|2020/08/25|2020/09/08|
|SEMI프로젝트 베타발표|2020/09/09|2020/09/09|
|SEMI프로젝트 최종발표|2020/09/10|2020/09/10|

<BR>



> ### 0. 기획 / UI / DB설계 회의 공통

- 제출 필수 공통 요소
  - **프로젝트 제목**
  - **구성원 소개**
  - **목차**
  - **간트차트**


> ### 1. 기획회의
> 진행기간: 2020.07.24 ~ 2020.07.29

- 기획회의 제출 필수 요소
  - **개발배경 (목적/ 사유)**
  - **구현 목표 (벤치마킹 사이트 대비 차별화 내용)**
    - 기존사이트(벤치마킹 사이트) 구현내용
    - 기존사이트와 개발사이트(프로젝트)와의 차이점 => 개발사이트의 차별성
      - 예: UI 화면, 기능추가 등..


  - **요구사항 정의서**
  
    ![요구사항 정의서 예1](./imgs/기획/요구사항정의서1.jpg)

    <br>

  - **단위업무 정의서**
    
    <br>
    
    ![단위업무 정의서 예1](./imgs/기획/단위업무정의서1.jpg)
    
    <br>
    
    ![단위업무 정의서 예2](./imgs/기획/단위업무정의서2.jpg)

    - 참고자료
      - [요구사항 정의서 예1 출처 - 시간속의 창업자](https://brunch.co.kr/@firstevan/6)
      - [단위업무정의서 예1 출처 - 세컨드스페이스](https://brunch.co.kr/@second-space/24)
      - [단위업무정의서 예2 출처 - 갓대희의 작은공간](https://goddaehee.tistory.com/122)
      - [요구사항 기술서 및 요구사항 정의서 작성방법 - 모그니](https://m.blog.naver.com/PostView.nhn?blogId=mogni&logNo=220670564871&proxyReferer=https:%2F%2Fwww.google.com%2F)
      - [요구사항 정의서 문서화방법 - wishket](http://blog.wishket.com/%EC%99%B8%EC%A3%BC%EB%A5%BC-%EB%A7%A1%EA%B8%B0%EB%A0%A4%EB%A9%B4-%EB%AD%90%EB%B6%80%ED%84%B0-%ED%95%B4%EC%95%BC%ED%95%98%EC%A3%A0-3-%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%EC%A0%95%EC%9D%98%EC%84%9C/)

<br>

<HR>

> ### 2. UI 화면 회의
> 진행기간: 2020.07.30 ~ 2020.08.05

  - 주의사항
  - 회의 후 결정하면, 바로 화면 구현 들어갈 것. (동시작업 진행)
  - 화면결과 꾸준히 확인할 것.
  - use case/ sequence diagram은 servlet 수업 중에 알려줄 예정.

- UI회의 제출 필수 요소
  - **Use case 다이어그램 ( 사용자 / 관리자)**
  - **Sequence 다이어그램**
  - **스토리보드** (사용툴: 카카오오븐/ FIGMA)

<BR>

<HR>

> ### 3. DB 회의
> 진행기간: 2020.08.06 ~ 2020.08.09

- 주의사항
  - DB담당자 따로 두면안됨. 다같이 모델링을 해야함.
  - 주제와 관련된 데이터(컬럼)을 사용해야함.
  - 꼼꼼히! 상세하게 완성해야함.
  - 기간내에 완수 못할 경우가 있음!

- DB회의 제출 필수 요소
  - **ERD (논리/ 물리)**
  - **테이블 정의서**

<HR>

<BR>

> ### 4. semi 프로젝트 구현
> 진행기간: 2020.08.25 ~ 2020.09.08

- 기획/ UI / DB설계 회의 결과물 중 구현 못한 부분이나 부족한 부분 보충하여 제출.
