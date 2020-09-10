package team.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.model.service.TeamService;
import team.model.vo.Team;

/**
 * Servlet implementation class MatchApplicationServlet
 */
@WebServlet("/matchApplication.me")
public class MatchApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String regist_num = request.getParameter("regist_num");
		String branch_num = request.getParameter("branch_num");
		String stadium_num = request.getParameter("stadium_num");
		String reservation_code = request.getParameter("reservation_code");
		System.out.println(userId);
		System.out.println(regist_num);
		System.out.println(branch_num);
		System.out.println(stadium_num);
		System.out.println(reservation_code);
		
		int result = new TeamService().teamRegistCheck(userId);
		if(result > 0) {
			Team team = new TeamService().selectTeamCode(userId);
			int appCheck = new TeamService().matchApplicationCheck(regist_num, team.getTeam_code());
			if(appCheck > 0) { 
				result = 1; //자기팀에게신청불가
			}else {
				int reappCheck = new TeamService().matchReapplicationCheck(regist_num, team.getTeam_code());				
				if(reappCheck > 0) {
					result = 2; //중복신청불가
				}else {
					new TeamService().matchApplication(regist_num, team.getTeam_code(), branch_num, stadium_num, reservation_code);
					result = 3; //신청
				}
			}
		}else {
			result = 0; //팀없음
		}
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(result, response.getWriter());
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
