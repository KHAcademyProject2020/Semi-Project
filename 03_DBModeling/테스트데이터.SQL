--MEMBER--------------------------------------------------------------------------------------------
INSERT INTO MEMBER VALUES('werty1212@daum.net', '12', '박성현', '92/08/22', '남', '01065655435', '강남구', 'N', 'M', 'N');
INSERT INTO MEMBER VALUES('werty23@daum.net', '12', '이지호', '97/06/12', '남', '01054839644', '서초구', 'N', 'G', 'N');
INSERT INTO MEMBER VALUES('wer1@daum.net', '12', '김건우', '20/06/12', '남', '01064584372', '강남구', 'N', 'G', 'N');
INSERT INTO MEMBER VALUES('wer2@daum.net', '12', '이현준', '93/11/23', '남', '01054546675', '서초구', 'N', 'G', 'N');
INSERT INTO MEMBER VALUES('wer3@daum.net', '12', '박성민', '20/06/12', '남', '01087764345', '강남구', 'N', 'G', 'N');
INSERT INTO MEMBER VALUES('wer4@daum.net', '12', '박승우', '88/04/10', '남', '01049746545', '서초구', 'N', 'G', 'N');
INSERT INTO MEMBER VALUES('werty45@daum.net', '12', '정창섭', '93/04/10', '남', '01011112222', '관악구', 'N', 'G', 'N');
INSERT INTO MEMBER VALUES('werty89@daum.net', '12', '이제욱', '93/11/11', '남', '01011112222', '속초시', 'N', 'G', 'N');

--TEAM----------------------------------------------------------------------------------------------
INSERT INTO TEAM VALUES('432041', 'wer1@daum.net', 1, '설악산', '남녀그룹', '20대', '강남구', 5, '팀마크.png', '20/08/15', 'N');
INSERT INTO TEAM VALUES('542042', 'wer2@daum.net', SEQ_TEAM_NUM.NEXTVAL, '백두산', '남녀그룹', '20대', '강남구', 5, '팀마크2.png', '20/08/15', 'N');
DELETE FROM TEAM WHERE TEAM_CODE='542042'; >>이것도 시퀸스순서문제땜에삭제하는거에요
INSERT INTO TEAM VALUES('542042', 'wer2@daum.net', SEQ_TEAM_NUM.NEXTVAL, '백두산', '남녀그룹', '20대', '강남구', 5, '팀마크2.png', '20/08/15', 'N');
INSERT INTO TEAM VALUES('656543', 'wer3@daum.net', SEQ_TEAM_NUM.NEXTVAL, '한라산', '남녀그룹', '20대', '강남구', 4, '팀마크3.png', '20/01/15', 'N');
INSERT INTO TEAM VALUES('046768', 'wer4@daum.net', SEQ_TEAM_NUM.NEXTVAL, '지리산', '남자그룹', '10대', '서초구', 5, '팀마크4.png', '20/08/15', 'N');
INSERT INTO TEAM VALUES('745644', 'werty23@daum.net', SEQ_TEAM_NUM.NEXTVAL, '태백산', '남자그룹', '20대', '서초구', 5, '팀마크5.png', '20/08/15', 'N');

--BRANCH--------------------------------------------------------------------------------------------
-- 샘플데이터(지점= BRANCH)
INSERT INTO BRANCH VALUES('BN1', 'werty1212@daum.net', '서울특별시 마포구 성산동 515', '02-2132-2242', '지점.png', 'http://www.seoulworldcupst.or.kr', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BRANCH VALUES('BN2', 'werty1212@daum.net', '서울특별시 마포구 성산동 424', '02-2545-2142', '지점2.png', 'http://www.seoulworldcupst.or.kr', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);




--STADIUM--------------------------------------------------------------------------------------------
INSERT INTO STADIUM VALUES(1, 'BN1', 'A구장', '5vs5', 09, 22, DEFAULT);
INSERT INTO STADIUM VALUES(SEQ_STADIUM_NUM.NEXTVAL, 'BN1', 'B구장', '4vs4', 10, 20, DEFAULT); >>2번실행해주세요 한번실행할떄오류뜨고그다음되요(시퀸스순서문제)
INSERT INTO STADIUM VALUES(SEQ_STADIUM_NUM.NEXTVAL, 'BN2', 'A구장', '6vs6', 12, 22, DEFAULT);

--RESERVATION-----------------------------------------------------------------------------------------
INSERT INTO RESERVATION VALUES('023142', 'werty23@daum.net', 'BN1', 1, 1, 20000, 9, 2, 11, '20/08/29', DEFAULT);
INSERT INTO RESERVATION VALUES('675562', 'wer1@daum.net', 'BN1', 1, SEQ_RESERVATION_NUM.NEXTVAL, 20000, 13, 2, 15, '2020/08/29', DEFAULT);
DELETE FROM RESERVATION WHERE RESERVATION_CODE='675562'; >>이것도 시퀸스순서문제땜에삭제하는거에요
INSERT INTO RESERVATION VALUES('675562', 'wer1@daum.net', 'BN1', 1, SEQ_RESERVATION_NUM.NEXTVAL, 20000, 13, 2, 15, '2020/08/29', DEFAULT);
INSERT INTO RESERVATION VALUES('454356', 'wer2@daum.net', 'BN1', 2, SEQ_RESERVATION_NUM.NEXTVAL, 20000, 14, 2, 16, '2020/08/30', DEFAULT);
INSERT INTO RESERVATION VALUES('959695', 'wer3@daum.net', 'BN1', 3, SEQ_RESERVATION_NUM.NEXTVAL, 20000, 16, 2, 18, '2020/08/29', DEFAULT);
INSERT INTO RESERVATION VALUES('049857', 'wer4@daum.net', 'BN2', 3, SEQ_RESERVATION_NUM.NEXTVAL, 20000, 18, 2, 20, '2020/08/29', DEFAULT);
INSERT INTO RESERVATION VALUES('855674', 'werty23@daum.net', 'BN1', 2, SEQ_RESERVATION_NUM.NEXTVAL, 20000, 18, 2, 20, '2020/08/29', DEFAULT);

--MATCHREGIST-----------------------------------------------------------------------------------------
INSERT INTO MATCHREGIST VALUES(1, '432041', '023142', DEFAULT, 'BN1', 1); >>wer1@daum.net(예약자)
INSERT INTO MATCHREGIST VALUES(SEQ_MATCH_REGIST_NUM.NEXTVAL, '542042', '454356', DEFAULT, 'BN1', 2); >>wer2@daum.net(예약자) >>2번실행해주세요 한번실행할떄오류뜨고그다음되요(시퀸스순서문제)
INSERT INTO MATCHREGIST VALUES(SEQ_MATCH_REGIST_NUM.NEXTVAL, '542042', '454356', DEFAULT, 'BN1', 2); >>wer2@daum.net(예약자) 
INSERT INTO MATCHREGIST VALUES(SEQ_MATCH_REGIST_NUM.NEXTVAL, '656543', '959695', DEFAULT, 'BN2', 3); >>wer3@daum.net(예약자)
INSERT INTO MATCHREGIST VALUES(SEQ_MATCH_REGIST_NUM.NEXTVAL, '046768', '049857', DEFAULT, 'BN2', 3); >>wer4@daum.net(예약자)
INSERT INTO MATCHREGIST VALUES(SEQ_MATCH_REGIST_NUM.NEXTVAL, '745644', '023142', DEFAULT, 'BN1', 1); >>werty23@daum.net(예약자)
INSERT INTO MATCHREGIST VALUES(SEQ_MATCH_REGIST_NUM.NEXTVAL, '745644', '855674', DEFAULT, 'BN1', 2); >>werty23@daum.net(예약자)

SELECT * FROM MATCHREGIST;
SELECT * FROM RESERVATION;
SELECT * FROM STADIUM;
SELECT * FROM BRANCH;
SELECT * FROM TEAM;
SELECT * FROM MEMBER;

COMMIT;
