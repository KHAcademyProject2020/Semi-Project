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

import member.model.vo.Member;
import team.model.vo.Team;
import team.model.vo.TeamMember;

public class TeamDAO {

private Properties prop = null;
	
	public TeamDAO() {
		prop = new Properties();
		String fileName = TeamDAO.class.getResource("/sql/team/team-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Team> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Team team = null;
		ArrayList<Team> teamArr = null;

		String query = prop.getProperty("selectAll");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			teamArr = new ArrayList<Team>();
			while(rset.next()) {
				team = new Team(rset.getString("team_code"),
									rset.getString("team_leader"),
									rset.getString("team_name"),
									rset.getString("team_gender"),
									rset.getString("team_age"),
									rset.getString("team_region"),
									rset.getInt("team_point"),
									rset.getString("team_mark_img"),
									rset.getDate("team_active_lastday"),
									rset.getString("team_delete_status")
								);
										
				teamArr.add(team);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return teamArr;
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
			if(rset.next()) {
				teamInfo = new Team(rset.getString("team_code"),
									rset.getString("team_leader"),
									rset.getString("team_name"),
									rset.getString("team_gender"),
									rset.getString("team_age"),
									rset.getString("team_region"),
									rset.getInt("team_point"),
									rset.getString("team_mark_img"),
									rset.getDate("team_active_lastday"),
									rset.getString("team_delete_status")
								);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return teamInfo;
	}


	public ArrayList<TeamMember> selectTeamMember(Connection conn, String team_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TeamMember> teamMemberArr = null;
		TeamMember teamMember = null;

		String query = prop.getProperty("selectTeamMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, team_code);
			rset = pstmt.executeQuery();
			
			teamMemberArr = new ArrayList<TeamMember>();
			while(rset.next()) {
				teamMember = new TeamMember(rset.getString("supporter_email"),
									rset.getString("support_team"),
									rset.getString("position"),
									rset.getString("application_status"),
									rset.getString("delete_status")
								);
										
				teamMemberArr.add(teamMember);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return teamMemberArr;
	}


	public Member selectMemberInfo(Connection conn, String supporter_email) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member memberInfo = null;
		
		String query = prop.getProperty("selectMemberInfo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, supporter_email);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberInfo = new Member(
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
		return memberInfo;
		
	}

}
