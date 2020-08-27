package member.model.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public void loginMember(Member member) {
		Connection conn = getConnection(); 
		
		new MemberDAO().loginMember(conn, member);
	}

}
