package team.controller;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.model.service.TeamService;
import team.model.vo.Team;

/**
 * Servlet implementation class TeamRegistServlet
 */
@WebServlet("/teamRegist.me")
public class TeamRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String team_name = request.getParameter("team_name");
		String team_gender = request.getParameter("team_gender");
		String team_age = request.getParameter("team_age");
		String team_region = request.getParameter("team_region");
		String team_mark = request.getParameter("team_mark");
		
		System.out.println(userId);
		System.out.println(team_name);
		System.out.println(team_gender);
		System.out.println(team_age);
		System.out.println(team_region);
		System.out.println(team_mark);
		
		
		
		int result = new TeamService().teamRegistCheck(userId);
			
		if(result > 0) { //이미팀등록
			result = 1; //팀1개이상등록불가
		
		}else { //팀등록;
			
			int ckName = new TeamService().teamRegistNameCheck(team_name);
			if(ckName > 0) {
				result = 2; //팀이름중복
			}else {
				Random rand = new Random();
				String team_code = "";
				int ckCode = 0;
				do{
					for(int i=0; i<=5; i++) {
						String ran = Integer.toString(rand.nextInt(10));
						if(!team_code.contains(ran)) {
							team_code += ran;
						}else {
							i-=1;
						}
					}
					
					ckCode = new TeamService().teamCodeCheck(team_code);
				}while(ckCode == 1);
				
				new TeamService().teamRegist(new Team(team_code, userId, team_name, team_gender, team_age, team_region, team_mark));
				
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
