CREATE TABLE MATCH(
    match_regist_num NUMBER NOT NULL,
    match_team VARCHAR2(10) NOT NULL,
    match_application_status VARCHAR2(10) DEFAULT '�����' NOT NULL CONSTRAINT CK_MATCH_APPLICATION_STATUS CHECK(match_application_status IN ('�����', '����', '���')),
    match_winlose VARCHAR2(2) CONSTRAINT CK_MATCH_WINLOSE CHECK(match_winlose IN ('��', '��', '��')),
    match_usage_date DATE NOT NULL,
    manager_point_status VARCHAR2(1) DEFAULT 'N' NOT NULL CONSTRAINT CK_MANAGER_POINT_STATUS CHECK(manager_point_status IN ('Y', 'N')),
    branch_num VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_MATCH_REGIST_NUM FOREIGN KEY(match_regist_num) REFERENCES MATCHREGIST(match_regist_num) ON DELETE SET NULL,
    CONSTRAINT FK_MATCH_MATCH_TEAM FOREIGN KEY(match_team) REFERENCES TEAM(team_code) ON DELETE SET NULL,
    CONSTRAINT FK_MATCH_BRANCH_NUM FOREIGN KEY(branch_num) REFERENCES BRANCH(branch_num) ON DELETE SET NULL
);