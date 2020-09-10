package team.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import team.model.service.TeamService;
import team.model.vo.PageInfo;
import team.model.vo.Team;
import team.model.vo.TeamMember;
import team.model.vo.TeamMemberInfo;

/**
 * Servlet implementation class TeamInfoServlet
 */
@WebServlet("/teamMemberInfo.me")
public class TeamMemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamMemberInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String team_code = request.getParameter("team_code");
		System.out.println(team_code);
		
		int listCount;
		int currentPage;
		int pageLimit;	
		int boardLimit;	
		int maxPage;	
		int startPage;	
		int endPage;		
		
		listCount = new TeamService().getTeamMemberCount(team_code);
		System.out.println(listCount);
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println(currentPage);
		}
		
		pageLimit = 5;
		boardLimit = 5;
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		
		Team teamInfo = new TeamService().selectTeam(team_code);
		System.out.println(teamInfo);
		request.setAttribute("teamInfo", teamInfo);
		
		ArrayList<TeamMemberInfo> teamMemberArr = new TeamService().selectTeamMember(team_code, pi);
		System.out.println(teamMemberArr);
		
		Calendar current = Calendar.getInstance();
		int year = current.get(Calendar.YEAR);
		for (int i = 0; i < teamMemberArr.size(); i++) {
		
			Date from = teamMemberArr.get(i).getBirthday();
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy");
			String to = transFormat.format(from);
			int birth = Integer.parseInt(to);
			teamMemberArr.get(i).setAge((year-birth)+1);

		}
		
		request.setAttribute("teamMemberArr", teamMemberArr);
		request.setAttribute("pi", pi);
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
