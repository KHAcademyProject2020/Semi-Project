package team.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import team.model.vo.MatchApplication;
import team.model.vo.PageInfo;
import team.model.vo.TeamMemberInfo;

/**
 * Servlet implementation class TeamMemberInfoServlet
 */
@WebServlet("/teamPageInfo.me")
public class TeamPageInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamPageInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		String team_code = request.getParameter("team_code");
		String type = request.getParameter("type");
		System.out.println(type);
		System.out.println(team_code);
		int listCount = 0;
		int currentPage;
		int pageLimit;	
		int boardLimit;	
		int maxPage;	
		int startPage;	
		int endPage;	
		
		if(type.equals("1")) {
			listCount = new TeamService().getTeamMemberCount(team_code);
		}else if(type.equals("2")) {
			listCount = new TeamService().getTeamApplicationCount(team_code);
		}else if(type.equals("3")) {
			listCount = new TeamService().getMatchApplicationCount(team_code);
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
		JSONArray memberArr = null;
		JSONObject userMap = null;
		if(type.equals("1")) { //팀정보
			pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
			ArrayList<TeamMemberInfo> teamMemberArr = new TeamService().selectTeamMember(team_code, pi);
			System.out.println(teamMemberArr);
			memberArr = new JSONArray();
			userMap = new JSONObject();
			for(int i = 0; i < teamMemberArr.size(); i++) {
				userObj = new JSONObject();
				userObj.put("supporter_email", teamMemberArr.get(i).getSupporter_email());
				userObj.put("support_team", teamMemberArr.get(i).getSupport_team());
				userObj.put("name", teamMemberArr.get(i).getName());
				userObj.put("gender", teamMemberArr.get(i).getGender());
				userObj.put("phone", teamMemberArr.get(i).getPhone());
				userObj.put("birthday", teamMemberArr.get(i).getBirthday());
				userObj.put("position", teamMemberArr.get(i).getPosition());
				
				memberArr.add(userObj);
				userMap.put("teamMember", memberArr);
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
			
		}else if(type.equals("2")) { //용병지원정보
			pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
			ArrayList<TeamMemberInfo> teamMemberArr = new TeamService().selectTeamApplication(team_code, pi);
			
			System.out.println(teamMemberArr);
			memberArr = new JSONArray();
			userMap = new JSONObject();
			for(int i = 0; i < teamMemberArr.size(); i++) {
				userObj = new JSONObject();
				userObj.put("supporter_email", teamMemberArr.get(i).getSupporter_email());
				userObj.put("support_team", teamMemberArr.get(i).getSupport_team());
				userObj.put("name", teamMemberArr.get(i).getName());
				userObj.put("gender", teamMemberArr.get(i).getGender());
				userObj.put("phone", teamMemberArr.get(i).getPhone());
				userObj.put("birthday", teamMemberArr.get(i).getBirthday());
				userObj.put("position", teamMemberArr.get(i).getPosition());
				
				memberArr.add(userObj);
				userMap.put("teamMember", memberArr);
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
			
		}else if(type.equals("3")) { //매칭신청정보
			pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
			ArrayList<MatchApplication> matchArr = new TeamService().selectMatchApplicationList(team_code, pi);

			memberArr = new JSONArray();
			userMap = new JSONObject();
			for(int i = 0; i < matchArr.size(); i++) {
				userObj = new JSONObject();
				
				userObj.put("match_regist_num", matchArr.get(i).getMatch_regist_num());
				userObj.put("match_team", matchArr.get(i).getMatch_team());
				userObj.put("match_num", matchArr.get(i).getMatch_num());
				userObj.put("match_application_status", matchArr.get(i).getMatch_application_status());
				userObj.put("match_winlose", matchArr.get(i).getMatch_winlose());
				userObj.put("manager_point_status", matchArr.get(i).getManager_point_status());
				userObj.put("match_branch_num", matchArr.get(i).getMatch_branch_num());
				userObj.put("match_stadium_num", matchArr.get(i).getMatch_stadium_num());
				userObj.put("match_reservation_code", matchArr.get(i).getMatch_reservation_code());
				userObj.put("regist_num", matchArr.get(i).getRegist_num());
				userObj.put("regist_team", matchArr.get(i).getRegist_team());
				userObj.put("regist_reservation_code", matchArr.get(i).getRegist_reservation_code());
				userObj.put("regist_status", matchArr.get(i).getRegist_status());
				userObj.put("regist_branch_num", matchArr.get(i).getRegist_branch_num());
				userObj.put("regist_stadium_num", matchArr.get(i).getRegist_stadium_num());
				userObj.put("team_code", matchArr.get(i).getTeam_code());
				userObj.put("team_leader", matchArr.get(i).getTeam_leader());
				userObj.put("team_num", matchArr.get(i).getTeam_num());
				userObj.put("team_name", matchArr.get(i).getTeam_name());
				userObj.put("team_gender", matchArr.get(i).getTeam_gender());
				userObj.put("team_age", matchArr.get(i).getTeam_age());
				userObj.put("team_region", matchArr.get(i).getTeam_region());
				userObj.put("team_point", matchArr.get(i).getTeam_point());
				userObj.put("team_mark_img", matchArr.get(i).getTeam_mark_img());
				userObj.put("team_active_lastday", matchArr.get(i).getTeam_active_lastday());
				userObj.put("team_delete_status", matchArr.get(i).getTeam_delete_status());
				userObj.put("reservation_code", matchArr.get(i).getReservation_code());
				userObj.put("reservation_email", matchArr.get(i).getReservation_email());
				userObj.put("reservation_branch_num", matchArr.get(i).getReservation_branch_num());
				userObj.put("reservation_stadium_num", matchArr.get(i).getReservation_stadium_num());
				userObj.put("reservation_num", matchArr.get(i).getReservation_num());
				userObj.put("reservation_price", matchArr.get(i).getReservation_price());
				userObj.put("reservation_usage_start_time", matchArr.get(i).getReservation_usage_start_time());
				userObj.put("reservation_usage_time", matchArr.get(i).getReservation_usage_time());
				userObj.put("reservation_usage_end_time", matchArr.get(i).getReservation_usage_end_time());
				userObj.put("reservation_usage_start_date", matchArr.get(i).getReservation_usage_start_date());
				userObj.put("reservation_status", matchArr.get(i).getReservation_status());
				userObj.put("branch_num", matchArr.get(i).getBranch_num());
				userObj.put("branch_manager_email", matchArr.get(i).getBranch_manager_email());
				userObj.put("branch_address", matchArr.get(i).getBranch_address());
				userObj.put("branch_phone", matchArr.get(i).getBranch_phone());
				userObj.put("branch_img", matchArr.get(i).getBranch_img());
				userObj.put("branch_website", matchArr.get(i).getBranch_website());
				userObj.put("branch_point", matchArr.get(i).getBranch_point());
				userObj.put("branch_option_shower", matchArr.get(i).getBranch_option_shower());
				userObj.put("branch_option_park", matchArr.get(i).getBranch_option_park());
				userObj.put("branch_option_uniform", matchArr.get(i).getBranch_option_uniform());
				userObj.put("branch_option_shoes", matchArr.get(i).getBranch_option_shoes());
				userObj.put("branch_option_ball", matchArr.get(i).getBranch_option_ball());
				userObj.put("branch_option_inout", matchArr.get(i).getBranch_option_inout());
				userObj.put("branch_delete_status", matchArr.get(i).getBranch_delete_status());
				userObj.put("stadium_num", matchArr.get(i).getStadium_num());
				userObj.put("stadium_branch_num", matchArr.get(i).getStadium_branch_num());
				userObj.put("stadium_name", matchArr.get(i).getStadium_name());
				userObj.put("stadium_match_member", matchArr.get(i).getStadium_match_member());
				userObj.put("stadium_reservation_start_time", matchArr.get(i).getStadium_reservation_start_time());
				userObj.put("stadium_reservation_end_time", matchArr.get(i).getStadium_reservation_end_time());
				userObj.put("stadium_delete_status", matchArr.get(i).getStadium_delete_status());
				
				memberArr.add(userObj);
				userMap.put("teamMatch", memberArr);
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
