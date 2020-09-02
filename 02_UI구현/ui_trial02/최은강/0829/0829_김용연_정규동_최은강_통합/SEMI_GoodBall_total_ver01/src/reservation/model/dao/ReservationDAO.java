package reservation.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import reservation.model.vo.Branch;
import reservation.model.vo.ReservationInfo;
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
		}catch (IOException e) {
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
			
			if(rset.next()) {
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
		
		int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		System.out.println(startRow);
		System.out.println(endRow);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Stadium>();
			while(rset.next()) {
				Stadium s = new Stadium(
								rset.getInt("stadium_num"),
								rset.getString("stadium_branch_num"),
								rset.getString("stadium_name"),
								rset.getString("stadium_match_member"),
								rset.getInt("stadium_reservation_start_time"),
								rset.getInt("stadium_reservation_end_time"),
								rset.getString("branch_manager_email"),
								rset.getString("branch_address"),
								rset.getString("branch_phone"),
								rset.getString("branch_img"),
								rset.getString("branch_website"),
								rset.getInt("branch_point"),
								rset.getString("branch_option_shower"),
								rset.getString("branch_option_park"),
								rset.getString("branch_option_uniform"),
								rset.getString("branch_option_shoes"),
								rset.getString("branch_option_ball"),
								rset.getString("branch_option_inout")
								
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
			
			if(rset.next()) {
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
			while(rset.next()) {
				Branch b = new Branch(rset.getString("branch_num"),
								rset.getString("branch_manager_email"),
								rset.getString("branch_address"),
								rset.getString("branch_phone"),
								rset.getString("branch_img"),
								rset.getString("branch_website"),
								rset.getInt("branch_point"),
								rset.getString("branch_option_shower"),
								rset.getString("branch_option_park"),
								rset.getString("branch_option_uniform"),
								rset.getString("branch_option_shoes"),
								rset.getString("branch_option_ball"),
								rset.getString("branch_option_inout"));
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
			
			if(rset.next()) {
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
			
			if(rset.next()) {
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

		int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ReservationInfo>();
			while(rset.next()) {
				r = new ReservationInfo(
									rset.getString("reservation_code"),
									rset.getString("reservation_email"),
									rset.getInt("reservation_stadium_num"),
									rset.getInt("reservation_num"),
									rset.getInt("reservation_price"),
									rset.getInt("reservation_usage_start_time"),
									rset.getInt("reservation_usage_time"),
									rset.getInt("reservation_usage_end_time"),
									rset.getDate("reservation_usage_start_date"),
									rset.getString("reservation_status"),
									rset.getInt("stadium_num"),
									rset.getString("stadium_branch_num"),
									rset.getString("stadium_name"),
									rset.getString("stadium_match_member"),
									rset.getInt("stadium_reservation_start_time"),
									rset.getInt("stadium_reservation_end_time"),
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
			
			if(rset.next()) {
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
			while(rset.next()) {
				Stadium s = new Stadium(
								rset.getInt("stadium_num"),
								rset.getString("stadium_branch_num"),
								rset.getString("stadium_name"),
								rset.getString("stadium_match_member"),
								rset.getInt("stadium_reservation_start_time"),
								rset.getInt("stadium_reservation_end_time"),
								rset.getString("branch_manager_email"),
								rset.getString("branch_address"),
								rset.getString("branch_phone"),
								rset.getString("branch_img"),
								rset.getString("branch_website"),
								rset.getInt("branch_point"),
								rset.getString("branch_option_shower"),
								rset.getString("branch_option_park"),
								rset.getString("branch_option_uniform"),
								rset.getString("branch_option_shoes"),
								rset.getString("branch_option_ball"),
								rset.getString("branch_option_inout")
								
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

	public int codeCheck(Connection conn, String reservation_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("codeCheck");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reservation_code);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
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
			
			if(rset.next()) {
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
			
			if(rset.next()) {
				reservationInfo = new ReservationInfo(
									rset.getString("reservation_branch_num"),
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
	

}
