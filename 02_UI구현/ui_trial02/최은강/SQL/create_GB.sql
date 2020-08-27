-- SYSTEM 유저에서 사용 : 유저 생성 및 유저에게 권한 부여 / DCL

-- 유저를 만든다
CREATE USER GB IDENTIFIED BY GB;

-- GB유저에게 권한을 준다.
GRANT RESOURCE, CONNECT TO GB;
