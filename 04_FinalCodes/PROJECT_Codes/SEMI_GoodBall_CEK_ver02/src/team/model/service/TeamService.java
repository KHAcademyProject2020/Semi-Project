package team.model.service;

import team.model.dao.TeamDAO;
import team.model.vo.Match;
import team.model.vo.MatchApplication;
import team.model.vo.PageInfo;
import team.model.vo.Team;
import team.model.vo.TeamMember;
import team.model.vo.TeamMemberInfo;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.dao.MemberDAO;

public class TeamService {

	public Team selectTeam(String team_code) {
		Connection conn = getConnection();

		Team teamInfo = new TeamDAO().selectTeam(conn, team_code);

		close(conn);

		return teamInfo;
	}

	public int getTeamCount() {

		Connection conn = getConnection();

		int result = new TeamDAO().getTeamCount(conn);

		close(conn);

		return result;
	}

	public ArrayList<Team> selectTeamList(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Team> list = new TeamDAO().getSelectTeamList(conn, pi);

		close(conn);

		return list;

	}

	public int getTeamMemberCount(String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().getTeamMemberCount(conn, team_code);

		close(conn);

		return result;

	}

	public ArrayList<TeamMemberInfo> selectTeamMember(String team_code, PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<TeamMemberInfo> teamMemberArr = new TeamDAO().selectTeamMember(conn, team_code, pi);

		close(conn);

		return teamMemberArr;
	}

	public int teamMemberRegistCheck(String userId, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().getTeamMemberRegistCheck(conn, userId, team_code);

		close(conn);

		return result;
	}

	public TeamMember teamMemberApplicationInfo(String userId, String team_code) {
		Connection conn = getConnection();

		TeamMember teamMember = new TeamDAO().getTeamMemberApplicationInfo(conn, userId, team_code);

		close(conn);

		return teamMember;
	}

	public void teamMemberReApplication(String userId, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamMemberReApplication(conn, userId, team_code);

		if (result > 0) {
			commit(conn);
		}

		close(conn);

	}

	public int teamMemberApplication(String userId, String team_code, String position) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamMemberApplication(conn, userId, team_code, position);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int teamRegistCheck(String userId) {
		Connection conn = getConnection();

		int result = new TeamDAO().getTeamRegistCheck(conn, userId);

		close(conn);

		return result;
	}

	public int teamCodeCheck(String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().getTeamCodeCheck(conn, team_code);

		close(conn);

		return result;
	}

	public void teamRegist(Team team) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamRegist(conn, team);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

	}

	public int teamRegistNameCheck(String team_name) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamRegistNameCheck(conn, team_name);

		close(conn);

		return result;

	}

	public int teamMemberRegistCheckNum(String userId) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamMemberRegistCheckNum(conn, userId);

		close(conn);

		return result;

	}

	public int getTeamApplicationCount(String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().getTeamApplicationCount(conn, team_code);

		close(conn);

		return result;
	}

	public ArrayList<TeamMemberInfo> selectTeamApplication(String team_code, PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<TeamMemberInfo> teamMemberArr = new TeamDAO().selectTeamApplication(conn, team_code, pi);

		close(conn);

		return teamMemberArr;
	}

	public void teamExpulsion(String supporter, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamExpulsion(conn, supporter, team_code);

		if (result > 0) {
			commit(conn);
		}

		close(conn);

	}

	public void teamAccept(String supporter, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamAccept(conn, supporter, team_code);

		if (result > 0) {
			commit(conn);
		}

		close(conn);

	}

	public void teamCancel(String supporter, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamCancel(conn, supporter, team_code);

		if (result > 0) {
			commit(conn);
		}

		close(conn);

	}

	public int getMatchCount() {
		Connection conn = getConnection();

		int result = new TeamDAO().getMatchCount(conn);

		close(conn);

		return result;
	}

	public ArrayList<Match> selectMatchList(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Match> matchArr = new TeamDAO().selectMatchList(conn, pi);

		close(conn);

		return matchArr;
	}

	public int getMatchSearchCount(String whereQuery2) {
		Connection conn = getConnection();

		int result = new TeamDAO().getMatchSearchCount(conn, whereQuery2);

		close(conn);

		return result;
	}

	public ArrayList<Match> selectMatchSearchList(String whereQuery) {
		Connection conn = getConnection();

		ArrayList<Match> matchArr = new TeamDAO().selectMatchSearchList(conn, whereQuery);

		close(conn);

		return matchArr;
	}

	public int codeCheck(String reservation_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().codeCheck(conn, reservation_code);

		close(conn);

		return result;
	}

	public Team selectTeamCode(String userId) {
		Connection conn = getConnection();

		Team team = new TeamDAO().selectTeamCode(conn, userId);

		close(conn);

		return team;
	}

	public void matchRegist(String team_code, String reservation_code, String reservation_branch_num,
			int reservation_stadium_num) {
		Connection conn = getConnection();

		int result = new TeamDAO().matchRegist(conn, team_code, reservation_code, reservation_branch_num,
				reservation_stadium_num);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

	}

	public int matchApplicationCheck(String regist_num, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().matchApplicationCheck(conn, regist_num, team_code);

		close(conn);

		return result;
	}

	public int matchReapplicationCheck(String regist_num, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().matchReapplicationCheck(conn, regist_num, team_code);

		close(conn);

		return result;
	}

	public void matchApplication(String regist_num, String team_code, String branch_num, String stadium_num,
			String reservation_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().matchApplication(conn, regist_num, team_code, branch_num, stadium_num,
				reservation_code);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

	}

	public int getMatchApplicationCount(String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().getMatchApplicationCount(conn, team_code);

		close(conn);

		return result;
	}

	public ArrayList<MatchApplication> selectMatchApplicationList(String team_code, PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<MatchApplication> matchArr = new TeamDAO().selectMatchApplicationList(conn, team_code, pi);

		close(conn);

		return matchArr;
	}

	public void teamMatchAcStatus(String match_regist_num, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamMatchAcStatus(conn, match_regist_num, team_code);

		if (result > 0) {
			commit(conn);
		}

		close(conn);

	}

	public void teamMatchAccept(String match_regist_num, String team_code, String winlose) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamMatchAccept(conn, match_regist_num, team_code, winlose);

		if (result > 0) {
			commit(conn);
		}

		close(conn);

	}

	public void teamMatchCaStatus(String match_regist_num, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamMatchCaStatus(conn, match_regist_num, team_code);

		if (result > 0) {
			commit(conn);
		}

		close(conn);
	}

	public void teamMatchCancel(String match_regist_num, String team_code) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamMatchCancel(conn, match_regist_num, team_code);

		if (result > 0) {
			commit(conn);
		}

		close(conn);
	}

	public int teamMatchStatusCheck(String match_regist_num) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamMatchStatusCheck(conn, match_regist_num);

		close(conn);

		return result;
	}

	public ArrayList<Team> searchTeamName(String team_name, PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Team> teamArr = new TeamDAO().searchTeamName(conn, team_name, pi);

		close(conn);

		return teamArr;
	}

	public int getTeamNameCount(String team_name) {
		Connection conn = getConnection();

		int result = new TeamDAO().getTeamNameCount(conn, team_name);

		close(conn);

		return result;
	}

	public int teamWithdraw(String code, String id) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamWithdraw(conn, code, id);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public Team getTeamLeader(String userId) {
		Connection conn = getConnection();

		Team team = new TeamDAO().getTeamLeader(conn, userId);

		close(conn);

		return team;

	}

	public ArrayList<Team> getTeam(String userId) {
		Connection conn = getConnection();

		ArrayList<Team> teamArr = new TeamDAO().getTeam(conn, userId);

		close(conn);

		return teamArr;

	}

	public int teamDelete(String code) {
		Connection conn = getConnection();

		int result = new TeamDAO().teamDelete(conn, code);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}
	
	public void createMatchView(String query) {
		Connection conn = getConnection();
		new TeamDAO().createMatchView(conn, query);
		
		close(conn);
	}
	
	
	

}
