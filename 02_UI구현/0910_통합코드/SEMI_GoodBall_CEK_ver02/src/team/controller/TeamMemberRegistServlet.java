package team.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.model.service.TeamService;
import team.model.vo.TeamMember;

/**
 * Servlet implementation class TeamMemberRegistServlet
 */
@WebServlet("/teamMemberRegist.me")
public class TeamMemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamMemberRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String position = request.getParameter("position");
		String team_code = request.getParameter("team_code");
		TeamMember teamMember = new TeamMember();
		System.out.println(userId);
		System.out.println(team_code);
		
		int result = 0;
		
		int ckNum = new TeamService().teamMemberRegistCheckNum(userId);
		if(ckNum >= 3) {
			result = 1; //3개이상가입불가
			
		}else {
			int ck = new TeamService().teamMemberRegistCheck(userId, team_code);
			
			if(ck > 0) { //등록된회원
				teamMember = new TeamService().teamMemberApplicationInfo(userId, team_code);
				
				if(teamMember.getApplication_status().equals("Y")) {
					result = 2; //이미회원
					
				}else if(teamMember.getApplication_status().equals("W")) {
					result = 3; //이미신청
					
				}else if(teamMember.getApplication_status().equals("N")) {
					result = 4; //재신청
					new TeamService().teamMemberReApplication(userId, team_code);
					
				}else {
					
				}
				
			}else { //가입신청
				result = 0;
				new TeamService().teamMemberApplication(userId, team_code, position);
				
			}
			
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
