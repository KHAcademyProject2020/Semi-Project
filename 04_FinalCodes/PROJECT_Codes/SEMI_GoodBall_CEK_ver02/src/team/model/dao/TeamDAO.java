package team.model.dao;

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

import team.model.vo.Match;
import team.model.vo.MatchApplication;
import team.model.vo.PageInfo;
import team.model.vo.Team;
import team.model.vo.TeamMember;
import team.model.vo.TeamMemberInfo;

public class TeamDAO {

	private Properties prop = null;

	public TeamDAO() {
		prop = new Properties();
		String fileName = TeamDAO.class.getResource("/sql/team/team-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Team selectTeam(Connection conn, String team_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Team teamInfo = null;

		String query = prop.getProperty("selectTeam");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				teamInfo = new Team(rset.getString("team_code"), rset.getString("team_leader"), rset.getInt("team_num"),
						rset.getString("team_name"), rset.getString("team_gender"), rset.getString("team_age"),
						rset.getString("team_region"), rset.getInt("team_point"), rset.getString("team_mark_img"),
						rset.getDate("team_active_lastday"), rset.getString("team_delete_status"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return teamInfo;
	}

	public int getTeamCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getTeamCount");

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

	public ArrayList<Team> getSelectTeamList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Team> list = null;

		String query = prop.getProperty("selectTeamList");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			list = new ArrayList<Team>();
			while (rset.next()) {
				Team t = new Team(rset.getString("team_code"), rset.getString("team_leader"), rset.getInt("team_num"),
						rset.getString("team_name"), rset.getString("team_gender"), rset.getString("team_age"),
						rset.getString("team_region"), rset.getInt("team_point"), rset.getString("team_mark_img"),
						rset.getDate("team_active_lastday"), rset.getString("team_delete_status"));
				list.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}

	public int getTeamMemberCount(Connection conn, String team_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getTeamMemberCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
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

	public ArrayList<TeamMemberInfo> selectTeamMember(Connection conn, String team_code, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TeamMemberInfo> teamMemberArr = null;
		TeamMemberInfo TeamMemberInfo = null;

		String query = prop.getProperty("selectTeamMember");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			teamMemberArr = new ArrayList<TeamMemberInfo>();
			while (rset.next()) {
				TeamMemberInfo = new TeamMemberInfo(rset.getString("supporter_email"), rset.getString("support_team"),
						rset.getString("position"), rset.getString("application_status"),
						rset.getString("delete_status"), rset.getString("EMAIL"), rset.getString("PWD"),
						rset.getString("NAME"), rset.getDate("BIRTHDAY"), rset.getString("GENDER"),
						rset.getString("PHONE"), rset.getString("ADDRESS"), rset.getString("MEMBER_KAKAO"),
						rset.getString("MEMBER_TYPE"), rset.getString("MEMBER_DELETE_STATUS")

				);

				teamMemberArr.add(TeamMemberInfo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return teamMemberArr;
	}

	public int getTeamMemberRegistCheck(Connection conn, String userId, String team_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("teamMemberRegistCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, team_code);
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

	public TeamMember getTeamMemberApplicationInfo(Connection conn, String userId, String team_code) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TeamMember teamMember = null;

		String query = prop.getProperty("teamMemberApplicationInfo");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, team_code);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				teamMember = new TeamMember(rset.getString("supporter_email"), rset.getString("support_team"),
						rset.getString("position"), rset.getString("application_status"),
						rset.getString("delete_status"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return teamMember;

	}

	public int teamMemberReApplication(Connection conn, String userId, String team_code) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("teamMemberReApplication");
		System.out.println(userId);
		System.out.println(team_code);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, team_code);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int teamMemberApplication(Connection conn, String userId, String team_code, String position) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("teamMemberApplication");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, team_code);
			pstmt.setString(3, position);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getTeamRegistCheck(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("teamRegistCheck");

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
			close(pstmt);
			close(rset);
		}

		return result;
	}

	public int getTeamCodeCheck(Connection conn, String team_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("teamCodeCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
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

	public int teamRegist(Connection conn, Team team) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("teamRegist");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team.getTeam_code());
			pstmt.setString(2, team.getTeam_leader());
			pstmt.setString(3, team.getTeam_name());
			pstmt.setString(4, team.getTeam_gender());
			pstmt.setString(5, team.getTeam_age());
			pstmt.setString(6, team.getTeam_region());
			pstmt.setString(7, team.getTeam_mark_img());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int teamRegistNameCheck(Connection conn, String team_name) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("teamRegistNameCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_name);
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

	public int teamMemberRegistCheckNum(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("teamMemberRegistCheckNum");

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
			close(pstmt);
			close(rset);
		}

		return result;

	}

	public int getTeamApplicationCount(Connection conn, String team_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getTeamApplicationCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
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

	public ArrayList<TeamMemberInfo> selectTeamApplication(Connection conn, String team_code, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TeamMemberInfo> teamMemberArr = null;
		TeamMemberInfo TeamMemberInfo = null;

		String query = prop.getProperty("selectTeamApplication");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			teamMemberArr = new ArrayList<TeamMemberInfo>();
			while (rset.next()) {
				TeamMemberInfo = new TeamMemberInfo(rset.getString("supporter_email"), rset.getString("support_team"),
						rset.getString("position"), rset.getString("application_status"),
						rset.getString("delete_status"), rset.getString("EMAIL"), rset.getString("PWD"),
						rset.getString("NAME"), rset.getDate("BIRTHDAY"), rset.getString("GENDER"),
						rset.getString("PHONE"), rset.getString("ADDRESS"), rset.getString("MEMBER_KAKAO"),
						rset.getString("MEMBER_TYPE"), rset.getString("MEMBER_DELETE_STATUS")

				);

				teamMemberArr.add(TeamMemberInfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return teamMemberArr;
	}

	public int teamExpulsion(Connection conn, String supporter, String team_code) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("teamExpulsion");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, supporter);
			pstmt.setString(2, team_code);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int teamAccept(Connection conn, String supporter, String team_code) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("teamAccept");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, supporter);
			pstmt.setString(2, team_code);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int teamCancel(Connection conn, String supporter, String team_code) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("teamCancel");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, supporter);
			pstmt.setString(2, team_code);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getMatchCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getMatchCount");

		try {
			pstmt = conn.prepareStatement(query);
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

	public ArrayList<Match> selectMatchList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Match> matchArr = null;
		Match m = null;

		String query = prop.getProperty("selectMatchList");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			matchArr = new ArrayList<Match>();
			while (rset.next()) {
				m = new Match(rset.getInt("regist_num"), rset.getString("regist_team"),
						rset.getString("regist_reservation_code"), rset.getString("regist_status"),
						rset.getString("regist_branch_num"), rset.getInt("regist_stadium_num"),
						rset.getString("team_code"), rset.getString("team_leader"), rset.getInt("team_num"),
						rset.getString("team_name"), rset.getString("team_gender"), rset.getString("team_age"),
						rset.getString("team_region"), rset.getInt("team_point"), rset.getString("team_mark_img"),
						rset.getDate("team_active_lastday"), rset.getString("team_delete_status"),
						rset.getString("reservation_code"), rset.getString("reservation_email"),
						rset.getString("reservation_branch_num"), rset.getInt("reservation_stadium_num"),
						rset.getInt("reservation_num"), rset.getInt("reservation_price"),
						rset.getInt("reservation_usage_start_time"), rset.getInt("reservation_usage_time"),
						rset.getInt("reservation_usage_end_time"), rset.getDate("reservation_usage_start_date"),
						rset.getString("reservation_status"), rset.getString("branch_num"),
						rset.getString("branch_manager_email"), rset.getString("branch_address"),
						rset.getString("branch_phone"), rset.getString("branch_img"), rset.getString("branch_website"),
						rset.getInt("branch_point"), rset.getString("branch_option_shower"),
						rset.getString("branch_option_park"), rset.getString("branch_option_uniform"),
						rset.getString("branch_option_shoes"), rset.getString("branch_option_ball"),
						rset.getString("branch_option_inout"), rset.getString("branch_delete_status"),
						rset.getInt("stadium_num"), rset.getString("stadium_branch_num"),
						rset.getString("stadium_name"), rset.getString("stadium_match_member"),
						rset.getInt("stadium_reservation_start_time"), rset.getInt("stadium_reservation_end_time"),
						rset.getString("stadium_delete_status")

				);

				matchArr.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return matchArr;
	}

	public int getMatchSearchCount(Connection conn, String whereQuery2) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = whereQuery2;

		try {
			pstmt = conn.prepareStatement(query);
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

	public ArrayList<Match> selectMatchSearchList(Connection conn, String whereQuery) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Match> matchArr = null;
		Match m = null;

		String query = whereQuery;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			matchArr = new ArrayList<Match>();
			while (rset.next()) {
				m = new Match(rset.getInt("regist_num"), rset.getString("regist_team"),
						rset.getString("regist_reservation_code"), rset.getString("regist_status"),
						rset.getString("regist_branch_num"), rset.getInt("regist_stadium_num"),
						rset.getString("team_code"), rset.getString("team_leader"), rset.getInt("team_num"),
						rset.getString("team_name"), rset.getString("team_gender"), rset.getString("team_age"),
						rset.getString("team_region"), rset.getInt("team_point"), rset.getString("team_mark_img"),
						rset.getDate("team_active_lastday"), rset.getString("team_delete_status"),
						rset.getString("reservation_code"), rset.getString("reservation_email"),
						rset.getString("reservation_branch_num"), rset.getInt("reservation_stadium_num"),
						rset.getInt("reservation_num"), rset.getInt("reservation_price"),
						rset.getInt("reservation_usage_start_time"), rset.getInt("reservation_usage_time"),
						rset.getInt("reservation_usage_end_time"), rset.getDate("reservation_usage_start_date"),
						rset.getString("reservation_status"), rset.getString("branch_num"),
						rset.getString("branch_manager_email"), rset.getString("branch_address"),
						rset.getString("branch_phone"), rset.getString("branch_img"), rset.getString("branch_website"),
						rset.getInt("branch_point"), rset.getString("branch_option_shower"),
						rset.getString("branch_option_park"), rset.getString("branch_option_uniform"),
						rset.getString("branch_option_shoes"), rset.getString("branch_option_ball"),
						rset.getString("branch_option_inout"), rset.getString("branch_delete_status"),
						rset.getInt("stadium_num"), rset.getString("stadium_branch_num"),
						rset.getString("stadium_name"), rset.getString("stadium_match_member"),
						rset.getInt("stadium_reservation_start_time"), rset.getInt("stadium_reservation_end_time"),
						rset.getString("stadium_delete_status")

				);

				matchArr.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return matchArr;
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
			close(pstmt);
			close(rset);
		}

		return result;
	}

	public Team selectTeamCode(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Team teamInfo = null;

		String query = prop.getProperty("selectTeamCode");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				teamInfo = new Team(rset.getString("team_code"), rset.getString("team_leader"), rset.getInt("team_num"),
						rset.getString("team_name"), rset.getString("team_gender"), rset.getString("team_age"),
						rset.getString("team_region"), rset.getInt("team_point"), rset.getString("team_mark_img"),
						rset.getDate("team_active_lastday"), rset.getString("team_delete_status"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return teamInfo;

	}

	public int matchRegist(Connection conn, String team_code, String reservation_code, String reservation_branch_num,
			int reservation_stadium_num) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("matchRegist");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
			pstmt.setString(2, reservation_code);
			pstmt.setString(3, reservation_branch_num);
			pstmt.setInt(4, reservation_stadium_num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int matchApplicationCheck(Connection conn, String regist_num, String team_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("matchApplicationCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regist_num);
			pstmt.setString(2, team_code);
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

	public int matchReapplicationCheck(Connection conn, String regist_num, String team_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("matchReapplicationCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regist_num);
			pstmt.setString(2, team_code);
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

	public int matchApplication(Connection conn, String regist_num, String team_code, String branch_num,
			String stadium_num, String reservation_code) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("matchApplication");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regist_num);
			pstmt.setString(2, team_code);
			pstmt.setString(3, branch_num);
			pstmt.setString(4, stadium_num);
			pstmt.setString(5, reservation_code);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getMatchApplicationCount(Connection conn, String team_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getMatchApplicationCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
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

	public ArrayList<MatchApplication> selectMatchApplicationList(Connection conn, String team_code, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MatchApplication> matchArr = null;
		MatchApplication m = null;

		String query = prop.getProperty("selectMatchApplicationList");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			matchArr = new ArrayList<MatchApplication>();
			while (rset.next()) {
				m = new MatchApplication(rset.getInt("match_regist_num"), rset.getString("match_team"),
						rset.getInt("match_num"), rset.getString("match_application_status"),
						rset.getString("match_winlose"), rset.getString("manager_point_status"),
						rset.getString("match_branch_num"), rset.getInt("match_stadium_num"),
						rset.getString("match_reservation_code"), rset.getInt("regist_num"),
						rset.getString("regist_team"), rset.getString("regist_reservation_code"),
						rset.getString("regist_status"), rset.getString("regist_branch_num"),
						rset.getInt("regist_stadium_num"), rset.getString("team_code"), rset.getString("team_leader"),
						rset.getInt("team_num"), rset.getString("team_name"), rset.getString("team_gender"),
						rset.getString("team_age"), rset.getString("team_region"), rset.getInt("team_point"),
						rset.getString("team_mark_img"), rset.getDate("team_active_lastday"),
						rset.getString("team_delete_status"), rset.getString("reservation_code"),
						rset.getString("reservation_email"), rset.getString("reservation_branch_num"),
						rset.getInt("reservation_stadium_num"), rset.getInt("reservation_num"),
						rset.getInt("reservation_price"), rset.getInt("reservation_usage_start_time"),
						rset.getInt("reservation_usage_time"), rset.getInt("reservation_usage_end_time"),
						rset.getDate("reservation_usage_start_date"), rset.getString("reservation_status"),
						rset.getString("branch_num"), rset.getString("branch_manager_email"),
						rset.getString("branch_address"), rset.getString("branch_phone"), rset.getString("branch_img"),
						rset.getString("branch_website"), rset.getInt("branch_point"),
						rset.getString("branch_option_shower"), rset.getString("branch_option_park"),
						rset.getString("branch_option_uniform"), rset.getString("branch_option_shoes"),
						rset.getString("branch_option_ball"), rset.getString("branch_option_inout"),
						rset.getString("branch_delete_status"), rset.getInt("stadium_num"),
						rset.getString("stadium_branch_num"), rset.getString("stadium_name"),
						rset.getString("stadium_match_member"), rset.getInt("stadium_reservation_start_time"),
						rset.getInt("stadium_reservation_end_time"), rset.getString("stadium_delete_status")

				);

				matchArr.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return matchArr;
	}

	public int teamMatchAcStatus(Connection conn, String match_regist_num, String team_code) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("teamMatchAcStatus");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, match_regist_num);
			pstmt.setString(2, team_code);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int teamMatchAccept(Connection conn, String match_regist_num, String team_code, String winlose) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("teamMatchAccept");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, winlose);
			pstmt.setString(2, match_regist_num);
			pstmt.setString(3, team_code);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int teamMatchCaStatus(Connection conn, String match_regist_num, String team_code) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("teamMatchCaStatus");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, match_regist_num);
			pstmt.setString(2, team_code);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int teamMatchCancel(Connection conn, String match_regist_num, String team_code) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("teamMatchCancel");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, match_regist_num);
			pstmt.setString(2, team_code);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int teamMatchStatusCheck(Connection conn, String match_regist_num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("teamMatchStatusCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, match_regist_num);
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

	public ArrayList<Team> searchTeamName(Connection conn, String team_name, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Team> list = null;

		String query = prop.getProperty("searchTeamName");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_name);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			list = new ArrayList<Team>();
			while (rset.next()) {
				Team t = new Team(rset.getString("team_code"), rset.getString("team_leader"), rset.getInt("team_num"),
						rset.getString("team_name"), rset.getString("team_gender"), rset.getString("team_age"),
						rset.getString("team_region"), rset.getInt("team_point"), rset.getString("team_mark_img"),
						rset.getDate("team_active_lastday"), rset.getString("team_delete_status"));
				list.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getTeamNameCount(Connection conn, String team_name) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getTeamNameCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_name);
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

	public int teamWithdraw(Connection conn, String code, String id) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("teamWithdraw");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, code);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public Team getTeamLeader(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Team team = null;

		String query = prop.getProperty("getTeamLeader");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				team = new Team(rset.getString("team_code"), rset.getInt("team_num"), rset.getString("team_name"),
						rset.getString("team_gender"), rset.getString("team_age"), rset.getString("team_region"),
						rset.getString("team_mark_img"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return team;

	}

	public ArrayList<Team> getTeam(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Team> list = null;
		Team team = null;

		String query = prop.getProperty("getTeam");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			list = new ArrayList<Team>();
			while (rset.next()) {
				team = new Team(rset.getString("team_code"), rset.getString("team_leader"), rset.getInt("team_num"),
						rset.getString("team_name"), rset.getString("team_gender"), rset.getString("team_age"),
						rset.getString("team_region"), rset.getString("team_mark_img"));

				list.add(team);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public int teamDelete(Connection conn, String code) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("teamDelete");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, code);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;

	}
	
	public void createMatchView(Connection conn, String query) {
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

}
