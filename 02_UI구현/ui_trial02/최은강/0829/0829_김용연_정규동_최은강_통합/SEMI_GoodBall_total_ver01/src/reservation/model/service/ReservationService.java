package reservation.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import reservation.model.dao.ReservationDAO;
import reservation.model.vo.Branch;
import reservation.model.vo.ReservationInfo;
import reservation.model.vo.Stadium;
import team.model.vo.PageInfo;


public class ReservationService {

	public int getStadiumCount() {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().getStadiumCount(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Stadium> selectStadiumList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Stadium> list = new ReservationDAO().selectStadiumList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int getBranchCount(String userId) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().getBranchCount(conn, userId);
		
		close(conn);
		
		return result;
	}
	
	
	public ArrayList<Branch> selectBranchList(String userId) {
		Connection conn = getConnection();
		
		ArrayList<Branch> list = new ReservationDAO().selectBranchList(conn, userId);
		
		close(conn);
		
		return list;
	}

	public int stadiumNameCheck(String branch_num, String stadium_name) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().stadiumNameCheck(conn, branch_num, stadium_name);
		
		close(conn);
		
		return result;
	}

	public void stadiumRegist(String branch_num, String stadium_name, String stadium_matchMember, String startTime,
			String endTime) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().stadiumRegist(conn, branch_num, stadium_name, stadium_matchMember, startTime, endTime);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
	}

	public int getReservationCount(String userId) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().getReservationCount(conn, userId);
		
		close(conn);
		
		return result;
	}

	public ArrayList<ReservationInfo> selectReservationList(String userId, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<ReservationInfo> list = new ReservationDAO().selectReservationList(conn, userId, pi);
		
		close(conn);
		
		return list;
	}

	public int getStadiumSearchCount(String whereQuery) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().getStadiumSearchCount(conn, whereQuery);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Stadium> selectStadiumSearchList(String whereQuery) {
		Connection conn = getConnection();
		
		ArrayList<Stadium> list = new ReservationDAO().selectStadiumSearchList(conn, whereQuery);
		
		close(conn);
		
		return list;
	}

	public int codeCheck(String reservation_code) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().codeCheck(conn, reservation_code);
		
		close(conn);
		
		return result;
	}

	public int check(String reservation_code, String reservation_email) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().check(conn, reservation_code, reservation_email);
		
		close(conn);
		
		return result;
	}

	public ReservationInfo selectReservationInfo(String reservation_code) {
		Connection conn = getConnection();
		
		ReservationInfo reservationInfo = new ReservationDAO().selectReservationInfo(conn, reservation_code);
		
		close(conn);
		
		return reservationInfo;
	}

}
