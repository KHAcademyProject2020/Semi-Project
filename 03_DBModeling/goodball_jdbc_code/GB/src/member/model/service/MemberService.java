package member.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member member) {
		Connection conn = getConnection();
		
		Member loginUser = new MemberDAO().loginMember(conn, member);
		
		close(conn);
		
		return loginUser;
	}

}
