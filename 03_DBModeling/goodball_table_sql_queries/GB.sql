CREATE TABLE MEMBER(
    email VARCHAR2(40) PRIMARY KEY,
    pwd VARCHAR2(20) NOT NULL,
    name VARCHAR2(10) NOT NULL,
    birthday DATE NOT NULL,
    gender VARCHAR2(2) NOT NULL CONSTRAINT CK_GENDER CHECK(gender IN ('남', '여')),
    phone VARCHAR2(20) NOT NULL,
    address VARCHAR2(100),
    member_kakao VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_MEMBER_KAKAO CHECK(member_kakao IN ('Y', 'N')),
    member_type VARCHAR2(10) DEFAULT '일반' NOT NULL CONSTRAINT CK_MEMBER_TYPE CHECK(member_type IN ('일반', '매니저', '관리자')),
    member_delete_status VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_MEMBER_DELETE_STATUS CHECK(member_delete_status IN ('Y', 'N'))
);

CREATE TABLE BRANCH(
    branch_num VARCHAR2(10) PRIMARY KEY,
    branch_manager_email VARCHAR2(40) NOT NULL,
    branch_address VARCHAR2(100) NOT NULL,
    branch_phone VARCHAR2(20) NOT NULL,
    branch_img VARCHAR2(50),
    branch_website VARCHAR2(100),
    branch_point NUMBER DEFAULT 0 NOT NULL CONSTRAINT CK_BRANCH_POINT CHECK(branch_point BETWEEN 0 AND 5),
    branch_option_shower VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_BRANCH_OPTION_SHOWER CHECK(branch_option_shower IN ('Y', 'N')),
    branch_option_park VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_BRANCH_OPTION_PARK CHECK(branch_option_park IN ('Y', 'N')),
    branch_option_uniform VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_BRANCH_OPTION_UNIFORM CHECK(branch_option_uniform IN ('Y', 'N')),
    branch_option_shoes VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_BRANCH_OPTION_SHOES CHECK(branch_option_shoes IN ('Y', 'N')),
    branch_option_ball VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_BRANCH_OPTION_BALL CHECK(branch_option_ball IN ('Y', 'N')),
    branch_option_inout VARCHAR2(10) DEFAULT '실내' NOT NULL CONSTRAINT CK_BRANCH_OPTION_INOUT CHECK(branch_option_inout IN ('실내', '실외')),
    CONSTRAINT FK_BRANCH_MANAGER_EMAIL FOREIGN KEY(branch_manager_email) REFERENCES MEMBER(email) ON DELETE SET NULL
);

CREATE TABLE REVIEW(
    review_num NUMBER PRIMARY KEY,
    review_email VARCHAR2(40) NOT NULL,
    branch_num VARCHAR2(10) NOT NULL,
    review_content VARCHAR2(200) NOT NULL,
    review_point NUMBER DEFAULT 0 NOT NULL CONSTRAINT CK_REVIEW_POINT CHECK(review_point BETWEEN 0 AND 5),
    CONSTRAINT FK_REVIEW_EMAIL FOREIGN KEY(review_email) REFERENCES MEMBER(email) ON DELETE SET NULL,
    CONSTRAINT FK_REVIEW_BRANCH_NUM FOREIGN KEY(branch_num) REFERENCES BRANCH(branch_num) ON DELETE SET NULL
);


CREATE TABLE STADIUM(
    stadium_num VARCHAR2(10) PRIMARY KEY,
    branch_num VARCHAR2(10) NOT NULL,
    stadium_name VARCHAR2(10) NOT NULL,
    stadium_match_member VARCHAR2(10),
    stadium_reservation_start_time NUMBER NOT NULL,
    stadium_reservation_last_time NUMBER NOT NULL,
    CONSTRAINT FK_STADIUM_BRANCH_NUM FOREIGN KEY(branch_num) REFERENCES BRANCH(branch_num) ON DELETE SET NULL
);


CREATE TABLE RESERVATION(
    reservation_code VARCHAR2(10) PRIMARY KEY,
    reservation_email VARCHAR2(40) NOT NULL, 
    stadium_num VARCHAR2(10) NOT NULL,
    reservation_price NUMBER NOT NULL,
    reservation_usage_start_time NUMBER NOT NULL,
    reservation_usage_time NUMBER NOT NULL,
    reservation_usage_end_time NUMBER NOT NULL,
    reservation_usage_start_date DATE NOT NULL,
    reservation_status VARCHAR2(1) DEFAULT 'Y' NOT NULL CONSTRAINT CK_RESERVATION_STATUS CHECK(reservation_status IN ('Y', 'N')),
    CONSTRAINT FK_RESERVATION_EMAIL FOREIGN KEY(reservation_email) REFERENCES BRANCH(branch_num) ON DELETE SET NULL,
    CONSTRAINT FK_RESERVATION_STADIUM_NUM FOREIGN KEY(stadium_num) REFERENCES STADIUM(stadium_num) ON DELETE SET NULL
);

CREATE TABLE BOARD(
    board_num NUMBER PRIMARY KEY,
    writer_email VARCHAR2(40) NOT NULL,
    board_title VARCHAR2(50) NOT NULL,
    board_content VARCHAR2(200) NOT NULL,
    board_img VARCHAR2(50),
    CONSTRAINT FK_BOARD_WRITER_EMAIL FOREIGN KEY(writer_email) REFERENCES MEMBER(email) ON DELETE SET NULL
);

CREATE TABLE TEAM(
    team_code VARCHAR2(10) PRIMARY KEY,
    team_leader VARCHAR2(40) NOT NULL,
    team_name VARCHAR2(10) NOT NULL,
    team_gender VARCHAR2(10) NOT NULL,
    team_age VARCHAR2(10) NOT NULL,
    team_region VARCHAR2(20) NOT NULL,
    team_point NUMBER DEFAULT 0 NOT NULL CONSTRAINT CK_TEAM_POINT CHECK(team_point BETWEEN 0 AND 5),
    team_mark_img VARCHAR2(50) NOT NULL,
    team_active_lastday DATE NOT NULL,
    team_delete_status VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_TEAM_DELETE_STATUS CHECK(team_delete_status IN ('Y', 'N')),
    CONSTRAINT FK_TEAM_LEADER FOREIGN KEY(team_leader) REFERENCES MEMBER(email) ON DELETE SET NULL
);

CREATE TABLE NOTICE(
    notice_email VARCHAR2(40) NOT NULL,
    notice_type VARCHAR2(10) NOT NULL,
    notice_content VARCHAR2(200) NOT NULL,
    notice_start_time DATE NOT NULL,
    notice_delete_status VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_NOTICE_DELETE_STATUS CHECK(notice_delete_status IN ('Y', 'N')),
    team_code VARCHAR2(10) NOT NULL,
    reservation_code VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_NOTICE_EMAIL FOREIGN KEY(notice_email) REFERENCES MEMBER(email) ON DELETE SET NULL,
    CONSTRAINT FK_NOTICE_TEAM_CODE FOREIGN KEY(team_code) REFERENCES TEAM(team_code) ON DELETE SET NULL,
    CONSTRAINT FK_NOTICE_RESERVATION_CODE FOREIGN KEY(reservation_code) REFERENCES RESERVATION(reservation_code) ON DELETE SET NULL
);

CREATE TABLE TEAMMEMBER(
    supporter_email VARCHAR2(40) NOT NULL,
    support_team VARCHAR2(10) NOT NULL,
    position VARCHAR2(10) NOT NULL,
    application_status VARCHAR2(10) DEFAULT '대기중' NOT NULL CONSTRAINT CK_APPLICATION_STATUS CHECK(application_status IN ('대기중', '수락')),
    delete_status VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_DELETE_STATUS CHECK(delete_status IN ('Y', 'N')),
    CONSTRAINT FK_SUPPORTER_EMAIL FOREIGN KEY(supporter_email) REFERENCES MEMBER(email) ON DELETE SET NULL,
    CONSTRAINT FK_SUPPORT_TEAM FOREIGN KEY(support_team) REFERENCES TEAM(team_code) ON DELETE SET NULL
);

CREATE TABLE MATCHREGIST(
    match_regist_num NUMBER PRIMARY KEY,
    regist_team VARCHAR2(10) NOT NULL,
    reservation_code VARCHAR2(10) NOT NULL,
    match_status VARCHAR2(10) DEFAULT '가능' NOT NULL CONSTRAINT CK_MATCH_STATUS CHECK(match_status IN ('가능', '불가능', '마감')),
    CONSTRAINT FK_MATCH_REGIST_TEAM FOREIGN KEY(regist_team) REFERENCES TEAM(team_code) ON DELETE SET NULL,
    CONSTRAINT FK_MATCH_RESERVATION_CODE FOREIGN KEY(reservation_code) REFERENCES RESERVATION(reservation_code) ON DELETE SET NULL
);

CREATE TABLE MATCH(
    match_regist_num NUMBER NOT NULL,
    match_team VARCHAR2(10) NOT NULL,
    match_application_status VARCHAR2(10) DEFAULT '대기중' NOT NULL CONSTRAINT CK_MATCH_APPLICATION_STATUS CHECK(match_application_status IN ('대기중', '수락', '취소')),
    match_winlose VARCHAR2(2) CONSTRAINT CK_MATCH_WINLOSE CHECK(match_winlose IN ('승', '패', '무')),
    match_usage_date DATE NOT NULL,
    manager_point_status VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_MANAGER_POINT_STATUS CHECK(manager_point_status IN ('Y', 'N')),
    branch_num VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_MATCH_REGIST_NUM FOREIGN KEY(match_regist_num) REFERENCES MATCHREGIST(match_regist_num) ON DELETE SET NULL,
    CONSTRAINT FK_MATCH_MATCH_TEAM FOREIGN KEY(match_team) REFERENCES TEAM(team_code) ON DELETE SET NULL,
    CONSTRAINT FK_MATCH_BRANCH_NUM FOREIGN KEY(branch_num) REFERENCES BRANCH(branch_num) ON DELETE SET NULL
);

CREATE SEQUENCE SEQ_REVIEW_NUM
START WITH 1
INCREMENT BY 1
MAXVALUE 1000
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_MATCH_REGIST_NUM
START WITH 1
INCREMENT BY 1
MAXVALUE 1000
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_BOARD_NUM
START WITH 1
INCREMENT BY 1
MAXVALUE 1000
NOCYCLE
NOCACHE;

commit;


DROP TABLE MEMBER;
DROP TABLE BRANCH;
DROP TABLE REVIEW;
DROP TABLE STADIUM;
DROP TABLE RESERVATION;
DROP TABLE BOARD;
DROP TABLE TEAM;
DROP TABLE NOTICE;
DROP TABLE TEAMMEMBER;
DROP TABLE MATCHREGIST;
DROP TABLE MATCH;


SELECT * FROM MEMBER;
DESC MEMBER;
INSERT INTO MEMBER VALUES('werty12@daum.net', '12', 'w', '20/06/12', '남', '010-1111-2222', '강남구', 'N', '일반', 'N');
INSERT INTO MEMBER VALUES('werty23@daum.net', '23', 'we', '97/06/12', '남', '010-1111-1212', '강남구', 'N', '일반', 'N');
INSERT INTO MEMBER VALUES('werty45@daum.net', '45', 'wew', '94/11/12', '남', '010-1111-4545', '강남구', 'N', '일반', 'N');
INSERT INTO MEMBER VALUES('werty67@daum.net', '67', 'wew', '97/12/12', '남', '010-1111-5656', '강남구', 'N', '일반', 'N');
INSERT INTO MEMBER VALUES('werty89@daum.net', '89', 'wew', '89/07/12', '남', '010-1111-7878', '강남구', 'N', '일반', 'N');
INSERT INTO MEMBER VALUES('werty1212@daum.net', '1212', 'ww', '92/08/22', '남', '010-2222-3333', '강남구', 'N', '매니저', 'N');
INSERT INTO MEMBER VALUES('werty12123@daum.net', '12123', 'www', '92/04/10', '남', '010-3333-4444', '서초구', 'N', '관리자', 'N');

SELECT * FROM TEAM;
DESC TEAM;
INSERT INTO TEAM VALUES('432045', 'werty12@daum.net', '백두산', '남녀그룹', '20대', '강남구', 5, '팀마크.png', '20/08/15', 'N');
INSERT INTO TEAM VALUES('234532', 'werty45@daum.net', '설악산', '남자그룹', '10대', '강남구', 4, '팀마크2.png', '20/08/10', 'N');


SELECT * FROM TEAMMEMBER;
DESC TEAMEMMEBER;
INSERT INTO TEAMMEMBER VALUES('werty23@daum.net', '432045', '공격수', '대기중', 'N');
INSERT INTO TEAMMEMBER VALUES('werty45@daum.net', '432045', '골키퍼', '수락', 'N');
INSERT INTO TEAMMEMBER VALUES('werty67@daum.net', '234532', '수비수', '수락', 'N');
INSERT INTO TEAMMEMBER VALUES('werty89@daum.net', '234532', '수비수', '수락', 'N');


<-- 팀페이지로 이동할때 -->
SELECT * FROM TEAM WHERE team_code = '432045'; <-- 팀정보 -->
SELECT * FROM TEAMMEMBER WHERE support_team = '432045' AND application_status = '수락'; <-- 팀원 -->









