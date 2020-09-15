package team.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import team.model.service.TeamService;
import team.model.vo.PageInfo;
import team.model.vo.Team;

/**
 * Servlet implementation class TeamSearchServlet
 */
@WebServlet("/teamSearch.me")
public class TeamSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String team_name = request.getParameter("team_name");

		int listCount = 0;
		int currentPage;
		int pageLimit;	
		int boardLimit;	
		int maxPage;	
		int startPage;	
		int endPage;	
		
		if(!team_name.equals("")) {
			//listCount = 1;
			listCount = new TeamService().getTeamNameCount(team_name);
		}else {
			listCount = new TeamService().getTeamCount();	
		}
		
		currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		pageLimit = 5;
		boardLimit = 5;
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		PageInfo pi = null;
		JSONObject userObj = null;
		JSONArray team = null;
		JSONObject userMap = null;
		
		
		if(!team_name.equals("")) {
			pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
			team = new JSONArray();
			userMap = new JSONObject();
			ArrayList<Team> teamArr = new TeamService().searchTeamName(team_name, pi);
			for(int i = 0; i < teamArr.size(); i++) {
				userObj = new JSONObject();
				userObj.put("team_code", teamArr.get(i).getTeam_code());
				userObj.put("team_leader", teamArr.get(i).getTeam_leader());
				userObj.put("team_num", teamArr.get(i).getTeam_num());
				userObj.put("team_name", teamArr.get(i).getTeam_name());
				userObj.put("team_gender", teamArr.get(i).getTeam_gender());
				userObj.put("team_age", teamArr.get(i).getTeam_age());
				userObj.put("team_region", teamArr.get(i).getTeam_region());
				userObj.put("team_point", teamArr.get(i).getTeam_point());
				userObj.put("team_mark_img", teamArr.get(i).getTeam_mark_img());
				userObj.put("team_active_lastday", teamArr.get(i).getTeam_active_lastday());
				userObj.put("team_delete_status", teamArr.get(i).getTeam_delete_status());

				team.add(userObj);
				userMap.put("team", team);
				//userMap.put("teamMember-" + teamMember.getEmail(), userObj);
				
			}
			userObj = new JSONObject();
			userObj.put("listCount", listCount);
			userObj.put("currentPage", currentPage);
			userObj.put("pageLimit", pageLimit);
			userObj.put("boardLimit", boardLimit);
			userObj.put("maxPage", maxPage);
			userObj.put("startPage", startPage);
			userObj.put("endPage", endPage);
			userMap.put("pi", userObj);
			//JSONObject result = new JSONObject();
			//result.put("memberArr", memberArr);
			
		}else {
			pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
			ArrayList<Team> teamArr = new TeamService().selectTeamList(pi);
			team = new JSONArray();
			userMap = new JSONObject();
			for(int i = 0; i < teamArr.size(); i++) {
				userObj = new JSONObject();
				userObj.put("team_code", teamArr.get(i).getTeam_code());
				userObj.put("team_leader", teamArr.get(i).getTeam_leader());
				userObj.put("team_num", teamArr.get(i).getTeam_num());
				userObj.put("team_name", teamArr.get(i).getTeam_name());
				userObj.put("team_gender", teamArr.get(i).getTeam_gender());
				userObj.put("team_age", teamArr.get(i).getTeam_age());
				userObj.put("team_region", teamArr.get(i).getTeam_region());
				userObj.put("team_point", teamArr.get(i).getTeam_point());
				userObj.put("team_mark_img", teamArr.get(i).getTeam_mark_img());
				userObj.put("team_active_lastday", teamArr.get(i).getTeam_active_lastday());
				userObj.put("team_delete_status", teamArr.get(i).getTeam_delete_status());

				team.add(userObj);
				userMap.put("team", team);
				//userMap.put("teamMember-" + teamMember.getEmail(), userObj);
				
			}
			userObj = new JSONObject();
			userObj.put("listCount", listCount);
			userObj.put("currentPage", currentPage);
			userObj.put("pageLimit", pageLimit);
			userObj.put("boardLimit", boardLimit);
			userObj.put("maxPage", maxPage);
			userObj.put("startPage", startPage);
			userObj.put("endPage", endPage);
			userMap.put("pi", userObj);
			//JSONObject result = new JSONObject();
			//result.put("memberArr", memberArr);
			
		}
		
		response.setContentType("application/json; charset=UTF-8");		
		new Gson().toJson(userMap, response.getWriter());
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
