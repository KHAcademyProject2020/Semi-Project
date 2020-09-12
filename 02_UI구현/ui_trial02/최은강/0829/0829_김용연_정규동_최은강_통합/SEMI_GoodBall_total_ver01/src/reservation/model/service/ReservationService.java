package reservation.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import reservation.model.dao.ReservationDAO;
import reservation.model.vo.Branch;
import reservation.model.vo.ReservationInfo;
import reservation.model.vo.Review;
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

	public Stadium selectStadiumInfo(String stadium_num) {
		Connection conn = getConnection();
		
		Stadium stadium = new ReservationDAO().selectStadiumInfo(conn, stadium_num);
		
		close(conn);
		
		return stadium;
	}


	public int getReviewCount(String branch_num) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().getReviewCount(conn, branch_num);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Review> branchReview(String branch_num, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new ReservationDAO().branchReview(conn, branch_num, pi);
		
		close(conn);
		
		return list;
	}

	public int reviewIdCheck(String userId, String branch_num) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().reviewIdCheck(conn, userId, branch_num);
		
		close(conn);
		
		return result;
	}

	public Branch selectBranchPoint(String branch_num) {
		Connection conn = getConnection();
		
		Branch branch = new ReservationDAO().selectBranchPoint(conn, branch_num);
		
		close(conn);
		
		return branch;
	}

	public void updateBranchPoint(String branch_num, int avg) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().updateBranchPoint(conn, branch_num, avg);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);	
		
	}

	public void reviewRegist(String userId, String branch_num, String review_content, int review_point, String date) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().reviewRegist(conn, userId, branch_num, review_content, review_point, date);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
	}

	public void reviewDelete(String review_num) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().reviewDelete(conn, review_num);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
	}

	public Review selectReviewPoint(String review_num) {
		Connection conn = getConnection();
		
		Review review = new ReservationDAO().selectReviewPoint(conn, review_num);
		
		close(conn);
		
		return review;
	}

	public int branchUseCheck(String userId, String branch_num) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().branchUseCheck(conn, userId, branch_num);
		
		close(conn);
		
		return result;
	}

	public int reservationCodeCheck(String reservation_code) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().reservationCodeCheck(conn, reservation_code);
		
		close(conn);
		
		return result;
	}

	public void reservationRegist(ReservationInfo reservation) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().reservationRegist(conn, reservation);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
	}


	public ArrayList<ReservationInfo> selectReservationDateList(int reservation_stadium_num, Date dat) {
		Connection conn = getConnection();
		
		ArrayList<ReservationInfo> list = new ReservationDAO().selectReservationDateList(conn, reservation_stadium_num, dat);
		
		close(conn);
		
		return list;
	}
	
	public void createStadiumView(String query) {
		Connection conn = getConnection();
		
		new ReservationDAO().createStadiumView(conn, query);
		
		close(conn);
		
	}
	
	
	public void createReservationView(String query4) {
		Connection conn = getConnection();
		
		new ReservationDAO().createReservationView(conn, query4);
		
		
		close(conn);
		
	}

	public void createReservationView2(String query4) {
		Connection conn = getConnection();
		
		new ReservationDAO().createReservationView2(conn, query4);
		
		
		close(conn);
		
	}

	public ArrayList<ReservationInfo> selectReservationList2(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<ReservationInfo> list = new ReservationDAO().selectReservationList2(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int getReservationCount2(String userId) {
		Connection conn = getConnection();
		
		int result = new ReservationDAO().getReservationCount2(conn, userId);
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<ReservationInfo> selectReservationList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<ReservationInfo> list = new ReservationDAO().selectReservationList(conn, pi);
		
		close(conn);
		
		return list;
	}
	

}
