package member.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;

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

	public int checkEmail(String userEmail) {
		Connection conn = getConnection();
		int result = new MemberDAO().checkEmail(conn, userEmail);

		close(conn);

		return result;

	}

	public int insertMember(Member member) {
		Connection conn = getConnection();

		int result = new MemberDAO().insertMember(conn, member);

		// 트랜잭션 처리
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		// 연결닫기
		close(conn);

		// 결과 리턴 (1 성공 0 실패)
		return result;
	}

	public int deleteMember(Member loginUser) {
		Connection conn = getConnection();
		int result = new MemberDAO().deleteMember(conn, loginUser);

		if (result != 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int updateMember(Member userInfo) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().updateMember(conn, userInfo);
		
		if(result != 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	   // 아이디 찾기

	   public static Member seaechEamil(Member find) {
	      
	      Connection conn = getConnection();
	      Member findEmail = new MemberDAO().seaechEamil(conn,find);

	   
	   
	      close(conn);

	      return findEmail;
	   }

	   public  Member searchPassword(Member findP) {
	      
	      System.out.println("서비스시작");
	      
	      Connection conn = getConnection();
	      Member findPwd = new MemberDAO().searchPassword(conn,findP);
	      System.out.println(findP.getName());

	      System.out.println("서비스끝");
	   
	      close(conn);
	      return findPwd;
	   }


	   public int updatePassword(String email, String newPwd1) {
	      Connection conn = getConnection();
	      int result = new MemberDAO().updatePwd(conn, email,newPwd1);
	      
	      if(result > 0) {
	         commit(conn);
	      } else {
	         rollback(conn);  
	      }
	      close(conn);
	      return result;
	   }
}
