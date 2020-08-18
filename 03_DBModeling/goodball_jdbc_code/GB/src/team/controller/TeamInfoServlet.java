package team.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import team.model.service.TeamService;
import team.model.vo.Team;
import team.model.vo.TeamMember;

/**
 * Servlet implementation class TeamInfoServlet
 */
@WebServlet("/teamInfo.me")
public class TeamInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String team_code = request.getParameter("team_code");
		System.out.println(team_code);
		
		Team teamInfo = new TeamService().selectTeam(team_code);
		System.out.println(teamInfo);
		request.setAttribute("teamInfo", teamInfo);
		
		ArrayList<TeamMember> teamMemberArr = new TeamService().selectTeamMember(team_code);
		System.out.println(teamMemberArr);
		request.setAttribute("teamMemberArr", teamMemberArr);
		
		ArrayList<Member> memberArr = new ArrayList<Member>();
		for (int i = 0; i < teamMemberArr.size(); i++) {
			Member member = new TeamService().selectMemberInfo(teamMemberArr.get(i).getSupporter_email());

			memberArr.add(member);
		}
		
		System.out.println(memberArr);
		request.setAttribute("memberArr", memberArr);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/team/GB_frame_teamPage.jsp");
		view.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
