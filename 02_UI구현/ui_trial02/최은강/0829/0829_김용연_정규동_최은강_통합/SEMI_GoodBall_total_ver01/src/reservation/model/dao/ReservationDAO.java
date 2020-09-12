package reservation.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import reservation.model.vo.Branch;
import reservation.model.vo.ReservationInfo;
import reservation.model.vo.Review;
import reservation.model.vo.Stadium;
import team.model.vo.PageInfo;
import team.model.vo.TeamMemberInfo;

public class ReservationDAO {
	private Properties prop = null;

	public ReservationDAO() {
		prop = new Properties();
		String fileName = ReservationDAO.class.getResource("/sql/reservation/reservation-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getStadiumCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getStadiumCount");

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Stadium> selectStadiumList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Stadium> list = null;

		String query = prop.getProperty("selectStadiumList");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		System.out.println(startRow);
		System.out.println(endRow);

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			list = new ArrayList<Stadium>();
			while (rset.next()) {
				Stadium s = new Stadium(rset.getInt("stadium_num"), rset.getString("stadium_branch_num"),
						rset.getString("stadium_name"), rset.getString("stadium_match_member"),
						rset.getInt("stadium_reservation_start_time"), rset.getInt("stadium_reservation_end_time"),
						rset.getString("branch_manager_email"), rset.getString("branch_address"),
						rset.getString("branch_phone"), rset.getString("branch_img"), rset.getString("branch_website"),
						rset.getInt("branch_point"), rset.getString("branch_option_shower"),
						rset.getString("branch_option_park"), rset.getString("branch_option_uniform"),
						rset.getString("branch_option_shoes"), rset.getString("branch_option_ball"),
						rset.getString("branch_option_inout"), rset.getString("branch_branchInfo"),
						rset.getString("branch_detailInfo"), rset.getString("branch_notes")

				);
				list.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getBranchCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getBranchCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Branch> selectBranchList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Branch> list = null;

		String query = prop.getProperty("selectBranchList");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			list = new ArrayList<Branch>();
			while (rset.next()) {
				Branch b = new Branch(rset.getString("branch_num"), rset.getString("branch_manager_email"),
						rset.getString("branch_address"), rset.getString("branch_phone"), rset.getString("branch_img"),
						rset.getString("branch_website"), rset.getInt("branch_point"),
						rset.getString("branch_option_shower"), rset.getString("branch_option_park"),
						rset.getString("branch_option_uniform"), rset.getString("branch_option_shoes"),
						rset.getString("branch_option_ball"), rset.getString("branch_option_inout"));
				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int stadiumNameCheck(Connection conn, String branch_num, String stadium_name) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("stadiumNameCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, branch_num);
			pstmt.setString(2, stadium_name);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int stadiumRegist(Connection conn, String branch_num, String stadium_name, String stadium_matchMember,
			String startTime, String endTime) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("stadiumRegist");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, branch_num);
			pstmt.setString(2, stadium_name);
			pstmt.setString(3, stadium_matchMember);
			pstmt.setString(4, startTime);
			pstmt.setString(5, endTime);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getReservationCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getReservationCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<ReservationInfo> selectReservationList(Connection conn, String userId, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationInfo> list = null;
		ReservationInfo r = null;

		String query = prop.getProperty("selectReservationList");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			list = new ArrayList<ReservationInfo>();
			while (rset.next()) {
				r = new ReservationInfo(rset.getString("reservation_code"), rset.getString("reservation_email"),
						rset.getInt("reservation_stadium_num"), rset.getInt("reservation_num"),
						rset.getInt("reservation_price"), rset.getInt("reservation_usage_start_time"),
						rset.getInt("reservation_usage_time"), rset.getInt("reservation_usage_end_time"),
						rset.getDate("reservation_usage_start_date"), rset.getString("reservation_status"),
						rset.getInt("stadium_num"), rset.getString("stadium_branch_num"),
						rset.getString("stadium_name"), rset.getString("stadium_match_member"),
						rset.getInt("stadium_reservation_start_time"), rset.getInt("stadium_reservation_end_time"),
						rset.getString("stadium_delete_status"));

				list.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public int getStadiumSearchCount(Connection conn, String whereQuery) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = whereQuery;

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Stadium> selectStadiumSearchList(Connection conn, String whereQuery) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Stadium> list = null;

		String query = whereQuery;

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			list = new ArrayList<Stadium>();
			while (rset.next()) {
				Stadium s = new Stadium(rset.getInt("stadium_num"), rset.getString("stadium_branch_num"),
						rset.getString("stadium_name"), rset.getString("stadium_match_member"),
						rset.getInt("stadium_reservation_start_time"), rset.getInt("stadium_reservation_end_time"),
						rset.getString("branch_manager_email"), rset.getString("branch_address"),
						rset.getString("branch_phone"), rset.getString("branch_img"), rset.getString("branch_website"),
						rset.getInt("branch_point"), rset.getString("branch_option_shower"),
						rset.getString("branch_option_park"), rset.getString("branch_option_uniform"),
						rset.getString("branch_option_shoes"), rset.getString("branch_option_ball"),
						rset.getString("branch_option_inout"), rset.getString("branch_branchInfo"),
						rset.getString("branch_detailInfo"), rset.getString("branch_notes"));
				list.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int codeCheck(Connection conn, String reservation_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("codeCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reservation_code);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int check(Connection conn, String reservation_code, String reservation_email) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("check");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reservation_code);
			pstmt.setString(2, reservation_email);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public ReservationInfo selectReservationInfo(Connection conn, String reservation_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReservationInfo reservationInfo = null;

		String query = prop.getProperty("selectReservationInfo");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reservation_code);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				reservationInfo = new ReservationInfo(rset.getString("reservation_branch_num"),
						rset.getInt("reservation_stadium_num"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return reservationInfo;
	}

	public Stadium selectStadiumInfo(Connection conn, String stadium_num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Stadium s = null;

		String query = prop.getProperty("selectStadiumInfo");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, stadium_num);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				s = new Stadium(rset.getInt("stadium_num"), rset.getString("stadium_branch_num"),
						rset.getString("stadium_name"), rset.getString("stadium_match_member"),
						rset.getInt("stadium_reservation_start_time"), rset.getInt("stadium_reservation_end_time"),
						rset.getString("branch_manager_email"), rset.getString("branch_address"),
						rset.getString("branch_phone"), rset.getString("branch_img"), rset.getString("branch_website"),
						rset.getInt("branch_point"), rset.getString("branch_option_shower"),
						rset.getString("branch_option_park"), rset.getString("branch_option_uniform"),
						rset.getString("branch_option_shoes"), rset.getString("branch_option_ball"),
						rset.getString("branch_option_inout"), rset.getString("branch_branchInfo"),
						rset.getString("branch_detailInfo"), rset.getString("branch_notes")

				);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return s;
	}

	public int getReviewCount(Connection conn, String branch_num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getReviewCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, branch_num);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Review> branchReview(Connection conn, String branch_num, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = null;
		Review r = null;

		String query = prop.getProperty("branchReview");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, branch_num);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			list = new ArrayList<Review>();
			while (rset.next()) {
				r = new Review(rset.getInt("review_num"), rset.getString("review_email"),
						rset.getString("review_branch_num"), rset.getString("review_content"),
						rset.getInt("review_point"), rset.getString("review_date"),
						rset.getString("review_delete_status"), rset.getString("email"), rset.getString("pwd"),
						rset.getString("name"), rset.getDate("birthday"), rset.getString("gender"),
						rset.getString("phone"), rset.getString("address"), rset.getString("member_kakao"),
						rset.getString("member_type"), rset.getString("member_delete_status"));

				list.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public int reviewIdCheck(Connection conn, String userId, String branch_num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("reviewIdCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, branch_num);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public Branch selectBranchPoint(Connection conn, String branch_num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Branch branch = null;

		String query = prop.getProperty("selectBranchPoint");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, branch_num);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				branch = new Branch(rset.getInt("branch_point"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return branch;
	}

	public int updateBranchPoint(Connection conn, String branch_num, int avg) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateBranchPoint");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, avg);
			pstmt.setString(2, branch_num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int reviewRegist(Connection conn, String userId, String branch_num, String review_content, int review_point,
			String date) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("reviewRegist");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, branch_num);
			pstmt.setString(3, review_content);
			pstmt.setInt(4, review_point);
			pstmt.setString(5, date);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int reviewDelete(Connection conn, String review_num) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("reviewDelete");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review_num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Review selectReviewPoint(Connection conn, String review_num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review review = null;

		String query = prop.getProperty("selectReviewPoint");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review_num);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				review = new Review(rset.getInt("review_point"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return review;
	}

	public int branchUseCheck(Connection conn, String userId, String branch_num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("branchUseCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, branch_num);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int reservationCodeCheck(Connection conn, String reservation_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("reservationCodeCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reservation_code);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int reservationRegist(Connection conn, ReservationInfo reservation) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("reservationRegist");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reservation.getReservation_code());
			pstmt.setString(2, reservation.getReservation_email());
			pstmt.setString(3, reservation.getReservation_branch_num());
			pstmt.setInt(4, reservation.getReservation_stadium_num());
			pstmt.setInt(5, reservation.getReservation_price());
			pstmt.setInt(6, reservation.getReservation_usage_start_time());
			pstmt.setInt(7, reservation.getReservation_usage_time());
			pstmt.setInt(8, reservation.getReservation_usage_end_time());
			pstmt.setDate(9, reservation.getReservation_usage_start_date());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<ReservationInfo> selectReservationDateList(Connection conn, int reservation_stadium_num,
			Date dat) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationInfo> list = null;

		String query = prop.getProperty("selectReservationDateList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reservation_stadium_num);
			pstmt.setDate(2, dat);
			rset = pstmt.executeQuery();

			list = new ArrayList<ReservationInfo>();
			while (rset.next()) {
				ReservationInfo s = new ReservationInfo(rset.getString("reservation_code"),
						rset.getString("reservation_email"), rset.getString("reservation_branch_num"),
						rset.getInt("reservation_stadium_num"), rset.getInt("reservation_price"),
						rset.getInt("reservation_usage_start_time"), rset.getInt("reservation_usage_time"),
						rset.getInt("reservation_usage_end_time"), rset.getDate("reservation_usage_start_date")

				);
				list.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public void createStadiumView(Connection conn, String query) {
		PreparedStatement pstmt = null;

		String query2 = query;

		try {
			pstmt = conn.prepareStatement(query2);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}

	public void createReservationView(Connection conn, String query4) {
		PreparedStatement pstmt = null;

		String query = query4;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

	}

	public void createReservationView2(Connection conn, String query4) {
		PreparedStatement pstmt = null;

		String query = query4;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

	}

	public ArrayList<ReservationInfo> selectReservationList2(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationInfo> list = null;
		ReservationInfo r = null;

		String query = prop.getProperty("selectReservationList2");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			list = new ArrayList<ReservationInfo>();
			while (rset.next()) {
				r = new ReservationInfo(rset.getString("reservation_code"), rset.getString("reservation_email"),
						rset.getString("reservation_branch_num"), rset.getInt("reservation_stadium_num"),
						rset.getInt("reservation_num"), rset.getInt("reservation_price"),
						rset.getInt("reservation_usage_start_time"), rset.getInt("reservation_usage_time"),
						rset.getInt("reservation_usage_end_time"), rset.getDate("reservation_usage_start_date"),
						rset.getString("reservation_status"), rset.getInt("stadium_num"),
						rset.getString("stadium_branch_num"), rset.getString("stadium_name"),
						rset.getString("stadium_match_member"), rset.getInt("stadium_reservation_start_time"),
						rset.getInt("stadium_reservation_end_time"), rset.getString("stadium_delete_status"),
						rset.getString("branch_manager_email"));

				list.add(r);
			}

			System.out.println(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public int getReservationCount2(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getReservationCount2");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<ReservationInfo> selectReservationList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationInfo> list = null;
		ReservationInfo r = null;

		String query = prop.getProperty("selectReservationList");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			list = new ArrayList<ReservationInfo>();
			while (rset.next()) {
				r = new ReservationInfo(rset.getString("reservation_code"), rset.getString("reservation_email"),
						rset.getInt("reservation_stadium_num"), rset.getInt("reservation_num"),
						rset.getInt("reservation_price"), rset.getInt("reservation_usage_start_time"),
						rset.getInt("reservation_usage_time"), rset.getInt("reservation_usage_end_time"),
						rset.getDate("reservation_usage_start_date"), rset.getString("reservation_status"),
						rset.getInt("stadium_num"), rset.getString("stadium_branch_num"),
						rset.getString("stadium_name"), rset.getString("stadium_match_member"),
						rset.getInt("stadium_reservation_start_time"), rset.getInt("stadium_reservation_end_time"),
						rset.getString("stadium_delete_status"));

				list.add(r);
			}

			System.out.println(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

}
