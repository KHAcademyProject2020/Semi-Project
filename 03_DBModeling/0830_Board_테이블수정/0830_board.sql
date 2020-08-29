--Board(공지사항 게시판) 테이블 수정 DDL쿼리문

--1) 컬럼추가: BOARD_DELETE_STATUS
-- BOARD_DELETE_STATUS: 공지사항 게시판 삭제 여부( 기본값: 'N')
-- 삭제됨: 'Y', 삭제안됨: 'N'
ALTER TABLE BOARD ADD(BOARD_DELETE_STATUS VARCHAR2(1) DEFAULT 'N');


--2) 컬럼 수정: 컬럼 기본값 추가
-- 공지게시글 등록 날짜 -> 기본값을 SYSDATE로 설정
ALTER TABLE BOARD MODIFY BOARD_DATE DEFAULT SYSDATE;

--3) 컬럼추가: 작성자 이름 추가
ALTER TABLE BOARD ADD(BOARD_WRITER VARCHAR2(10) NOT NULL);

COMMIT;
