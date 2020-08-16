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