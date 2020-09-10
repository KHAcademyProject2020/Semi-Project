package branch.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;

import java.sql.Connection;
import java.util.ArrayList;

import branch.model.dao.BranchDAO;
import branch.model.vo.Branch;
import branch.model.vo.Stadium;
import reservation.model.vo.PageInfo;

public class BranchService {

	public int insertBranch(Branch branch) {
		Connection conn = getConnection();
		
		int result = new BranchDAO().insertBranch(conn, branch);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int getBranchCount(String userId) {
		Connection conn = getConnection();
		
		int result = new BranchDAO().getBranchCount(conn, userId);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Branch> selectBranchList(String userId, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Branch> list = new BranchDAO().selectBranchList(conn, userId, pi);
		
		close(conn);
		
		return list;
	}

	public Branch selectBranch(String num) {
		Connection conn = getConnection();
		
		Branch branch = new BranchDAO().selectBranch(conn, num);
		
		close(conn);
		
		return branch;
	}

	public int searchBranch(String branchName) {
		Connection conn = getConnection();
		
		int count = new BranchDAO().searchBranch(conn, branchName);
		
		close(conn);
		
		return count;
	}

	public int branchUpdate(Branch branch) {
		Connection conn = getConnection();
		
		int result = new BranchDAO().branchUpdate(conn, branch);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Stadium> selectStadiumList(String num) {
		Connection conn = getConnection();
		
		ArrayList<Stadium> list = new BranchDAO().selectStadiumList(conn, num);
		
		close(conn);
		
		return list;
	}

	public int branchDelete(String name) {
		Connection conn = getConnection();

		int result = new BranchDAO().branchDelete(conn, name);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Stadium getStadiumInfo(String branch_num, String stadium_name) {
		Connection conn = getConnection();
		
		Stadium stadium = new BranchDAO().getStadiumInfo(conn, branch_num, stadium_name);
		
		close(conn);
		
		return stadium;
	}

	public int deleteStadium(String branch_num, String stadium_name) {
		Connection conn = getConnection();
		
		int result = new BranchDAO().deleteStadium(conn, branch_num, stadium_name);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int checkBranch(String branchName) {
	     Connection conn = getConnection();
	     
	     int result = new BranchDAO().checkBranch(conn, branchName);

	     close(conn);

	     return result;
	   }
	
	
}
