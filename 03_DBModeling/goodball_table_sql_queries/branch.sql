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
    branch_option_inout VARCHAR2(1) DEFAULT 'O' NOT NULL CONSTRAINT CK_BRANCH_OPTION_INOUT CHECK(branch_option_inout IN ('I', 'O')),
    CONSTRAINT FK_BRANCH_MANAGER_EMAIL FOREIGN KEY(branch_manager_email) REFERENCES MEMBER(email) ON DELETE SET NULL
);