package team.model.service;

import team.model.dao.TeamDAO;
import team.model.vo.Team;
import team.model.vo.TeamMember;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.vo.Member;

import static common.JDBCTemplate.close;

public class TeamService {

	public ArrayList<Team> selectAll() {
		Connection conn = getConnection();
		
		ArrayList<Team> teamArr = new TeamDAO().selectAll(conn);
		
		close(conn);
		
		return teamArr;
	}

	public Team selectTeam(String team_code) {
		Connection conn = getConnection();
		
		Team teamInfo = new TeamDAO().selectTeam(conn, team_code);
		
		close(conn);
		
		return teamInfo;
	}

	public ArrayList<TeamMember> selectTeamMember(String team_code) {
		Connection conn = getConnection();
		
		ArrayList<TeamMember> teamMemberArr = new TeamDAO().selectTeamMember(conn, team_code);
		
		close(conn);
		
		return teamMemberArr;
	}

	public Member selectMemberInfo(String supporter_email) {
		Connection conn = getConnection();
		
		Member memberInfo = new TeamDAO().selectMemberInfo(conn, supporter_email);
		
		close(conn);
		
		return memberInfo;
	}

	

}
