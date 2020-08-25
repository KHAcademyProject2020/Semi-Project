CREATE TABLE MEMBER(
    email VARCHAR2(40) PRIMARY KEY,
    pwd VARCHAR2(20) NOT NULL,
    name VARCHAR2(10) NOT NULL,
    birthday DATE NOT NULL,
    gender VARCHAR2(2) NOT NULL CONSTRAINT CK_GENDER CHECK(gender IN ('³²', '¿©')),
    phone VARCHAR2(20) NOT NULL,
    address VARCHAR2(100),
    member_kakao VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_MEMBER_KAKAO CHECK(member_kakao IN ('Y', 'N')),
    member_type VARCHAR2(1) DEFAULT 'G' NOT NULL CONSTRAINT CK_MEMBER_TYPE CHECK(member_type IN ('G', 'M', 'R')),
    member_delete_status VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_MEMBER_DELETE_STATUS CHECK(member_delete_status IN ('Y', 'N'))
);