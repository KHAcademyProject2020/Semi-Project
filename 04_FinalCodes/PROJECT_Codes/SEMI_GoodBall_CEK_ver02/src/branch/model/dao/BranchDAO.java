package branch.model.dao;


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

import branch.model.vo.Branch;
import branch.model.vo.Stadium;
import member.model.dao.MemberDAO;
import reservation.model.vo.PageInfo;

public class BranchDAO {
	
	private Properties prop = null;

	public BranchDAO() {
		prop = new Properties();
		String fileName = MemberDAO.class.getResource("/sql/branch/branch-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertBranch(Connection conn, Branch branch) {
	      PreparedStatement pstmt = null; 
	      int result = 0;
	      
	      String query = prop.getProperty("insertBranch");
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, branch.getBranch_num());
	         pstmt.setString(2, branch.getBranch_manager_email());
	         pstmt.setString(3, branch.getBranch_address());
	         pstmt.setString(4, branch.getBranch_phone());
	         pstmt.setString(5, branch.getBranch_img());
	         pstmt.setString(6, branch.getBranch_website());
	         pstmt.setString(7, branch.getBranch_Info());
	         pstmt.setString(8, branch.getDetail_Info());
	         pstmt.setString(9, branch.getNotes());
	         pstmt.setInt(10, branch.getBranch_point());
	         pstmt.setString(11, branch.getBranch_option_shower());
	         pstmt.setString(12, branch.getBranch_option_park());
	         pstmt.setString(13, branch.getBranch_option_uniform());
	         pstmt.setString(14, branch.getBranch_option_shoes());
	         pstmt.setString(15, branch.getBranch_option_ball());
	         pstmt.setString(16, branch.getBranch_option_inout());
	         pstmt.setString(17, branch.getBranch_delete_status());
	         
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
	      return result;
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
				result  = rset.getInt(1);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Branch> selectBranchList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Branch> list = null;
		Branch branch = null;
		
		String query = prop.getProperty("selectBranchList");
		
		 int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
	     int endRow = startRow + pi.getBoardLimit() - 1;
	     
	     try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Branch>();
			while(rset.next()) {
				branch = new Branch(rset.getString("branch_num"),
									rset.getString("branch_manager_email"),
									rset.getString("branch_address"),
									rset.getString("branch_phone"),
									rset.getString("branch_img"),
									rset.getString("branch_website"),
									rset.getString("branch_branchinfo"),
									rset.getString("branch_detailinfo"),
									rset.getString("branch_notes"),
									rset.getInt("branch_point"),
									rset.getString("branch_option_shower"),
									rset.getString("branch_option_park"),
									rset.getString("branch_option_uniform"),
									rset.getString("branch_option_shoes"),
									rset.getString("branch_option_ball"),
									rset.getString("branch_option_inout"),
									rset.getString("branch_delete_status"));
			
				list.add(branch);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}  
		
		return list;
	}

	public Branch selectBranch(Connection conn, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Branch branch = null;
		
		String query = prop.getProperty("selectBranch");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				branch = new Branch(rset.getString("branch_num"),
									rset.getString("branch_manager_email"),
									rset.getString("branch_address"),
									rset.getString("branch_phone"),
									rset.getString("branch_img"),
									rset.getString("branch_website"),
									rset.getString("branch_branchinfo"),
									rset.getString("branch_detailinfo"),
									rset.getString("branch_notes"),
									rset.getInt("branch_point"),
									rset.getString("branch_option_shower"),
									rset.getString("branch_option_park"),
									rset.getString("branch_option_uniform"),
									rset.getString("branch_option_shoes"),
									rset.getString("branch_option_ball"),
									rset.getString("branch_option_inout"),
									rset.getString("BRANCH_DELETE_STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return branch;
	}

	public int searchBranch(Connection conn, String branchName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		String query = prop.getProperty("seacrhBranch");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, branchName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count  = rset.getInt(1);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return count;
	}

	public int branchUpdate(Connection conn, Branch branch) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBranch");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, branch.getBranch_phone());
			pstmt.setString(2, branch.getBranch_website());
			pstmt.setString(3, branch.getBranch_option_shower());
			pstmt.setString(4, branch.getBranch_option_park());
			pstmt.setString(5, branch.getBranch_option_uniform());
			pstmt.setString(6, branch.getBranch_option_shoes());
			pstmt.setString(7, branch.getBranch_option_ball());
			pstmt.setString(8, branch.getBranch_option_inout());
			pstmt.setString(9, branch.getBranch_Info());
			pstmt.setString(10, branch.getDetail_Info());
			pstmt.setString(11, branch.getNotes());
			pstmt.setString(12, branch.getBranch_img());
			pstmt.setString(13, branch.getBranch_num());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Stadium> selectStadiumList(Connection conn, String num) {
	     
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<Stadium> list = null;
	      Stadium s = null;
	      
	      String query = prop.getProperty("selectStadiumList");
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, num);
	         rset = pstmt.executeQuery();
	         
	         list = new ArrayList<Stadium>();
	         while(rset.next()) {
	            s = new Stadium(
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
	                        rset.getString("branch_option_inout"));
	            
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

	public int branchDelete(Connection conn, String name) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("branchDelete");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Stadium getStadiumInfo(Connection conn, String branch_num, String stadium_name) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Stadium stadium = null;
		
		String query = prop.getProperty("getStadiumInfo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, branch_num);
			pstmt.setString(2, stadium_name);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				stadium = new Stadium(
								rset.getString("STADIUM_NAME"),
								rset.getString("STADIUM_MATCH_MEMBER"),
								rset.getInt("STADIUM_RESERVATION_START_TIME"),
								rset.getInt("STADIUM_RESERVATION_END_TIME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return stadium;
	}

	public int deleteStadium(Connection conn, String branch_num, String stadium_name) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteStadium");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, branch_num);
			pstmt.setString(2, stadium_name);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int checkBranch(Connection conn, String branchName) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      int result = 0;

	      String query = prop.getProperty("branchCheck");

	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, branchName);

	         rset = pstmt.executeQuery();
	         
	         if (rset.next()) {
	            result = rset.getInt(1);
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	         close(rset);
	      }

	      return result;
	   }

	public void createBranchView(Connection conn, String query10) {
		  PreparedStatement pstmt = null;
	    
	      String query = query10;

	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.executeQuery();
	         

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	}
}
