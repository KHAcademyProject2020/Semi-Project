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
 * Servlet implementation class TeamLeaderServlet
 */
@WebServlet("/leader.me")
public class TeamLeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamLeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		String supporter = request.getParameter("supporter");
		String teamcode = request.getParameter("team_code");
		String team_code = request.getParameter("teamcode");
		String match_regist_num = request.getParameter("match_regist_num");
		String type = request.getParameter("type");
		
		int result = 0;
		if(type.equals("1")) { //추방
			result = 1;
			new TeamService().teamExpulsion(supporter, teamcode);
			
		}else if(type.equals("2")) { //수락
			result = 2;
			new TeamService().teamAccept(supporter, teamcode);
			
		}else if(type.equals("3")) { //취소
			result = 3;
			new TeamService().teamCancel(supporter, teamcode);
			
		}else if(type.equals("4")) { //매치수락
			int statusCheck = new TeamService().teamMatchStatusCheck(match_regist_num);
			if(statusCheck > 0) {
				result = 0; //1개팀만수락가능
			}else {
				new TeamService().teamMatchAcStatus(match_regist_num ,team_code);
				int ran =(int)(Math.random()*(3-1+1)+1);
				String winlose = "";
				if(ran == 1) {
					winlose = "W";
				}else if(ran == 2) {
					winlose = "L";				
				}else {
					winlose = "D";				
				}
				new TeamService().teamMatchAccept(match_regist_num, teamcode, winlose);
				result = 4;	
			}
			
			
		}else if(type.equals("5")) { //매치취소
			new TeamService().teamMatchCaStatus(match_regist_num ,team_code);
			new TeamService().teamMatchCancel(match_regist_num, teamcode);
			result = 5;
			
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
