package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDAO {
	
	private Properties prop = null;
	
	public MemberDAO() {
		prop = new Properties();
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, Member member) {
		// SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPwd());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(
						rset.getString("EMAIL"),
						rset.getString("PWD"),
						rset.getString("NAME"),
						rset.getDate("BIRTHDAY"),
						rset.getString("GENDER"),
						rset.getString("PHONE"),
						rset.getString("ADDRESS"),
						rset.getString("MEMBER_KAKAO"),
						rset.getString("MEMBER_TYPE"),
						rset.getString("MEMBER_DELETE_STATUS")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);			
		}
		return loginUser;
		
	}

}
