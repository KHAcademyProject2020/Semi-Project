package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import team.model.service.TeamService;
import team.model.vo.Team;


/**
 * Servlet implementation class GeneralTeamServlet
 */
@WebServlet("/generalTeam.mp")
public class GeneralTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneralTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		String userId = loginUser.getEmail();
		
		Team team = new TeamService().getTeamLeader(userId);
		
		ArrayList<Team> teamArr = new TeamService().getTeam(userId);
		
		request.setAttribute("team", team);
		request.setAttribute("teamArr", teamArr);

		request.getRequestDispatcher("WEB-INF/views/member/general/General_TeamPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}