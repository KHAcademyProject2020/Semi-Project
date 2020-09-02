package reservation.controller;

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

import reservation.model.service.ReservationService;
import reservation.model.vo.ReservationInfo;
import team.model.service.TeamService;
import team.model.vo.PageInfo;
import team.model.vo.TeamMemberInfo;

/**
 * Servlet implementation class ReservationInfo
 */
@WebServlet("/reservationInfo.me")
public class ReservationInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		
		int listCount = 0;
		int currentPage;
		int pageLimit;	
		int boardLimit;	
		int maxPage;	
		int startPage;	
		int endPage;	
		
		listCount = new ReservationService().getReservationCount(userId);

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
		JSONArray reservation = null;
		JSONObject userMap = null;
		
		pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		ArrayList<ReservationInfo> reservationArr = new ReservationService().selectReservationList(userId, pi);
		
		
		reservation = new JSONArray();
		userMap = new JSONObject();
		for(int i = 0; i < reservationArr.size(); i++) {
			userObj = new JSONObject();
			userObj.put("reservation_code", reservationArr.get(i).getReservation_code());
			userObj.put("reservation_email", reservationArr.get(i).getReservation_email());
			userObj.put("reservation_stadium_num", reservationArr.get(i).getReservation_stadium_num());
			userObj.put("reservation_num", reservationArr.get(i).getReservation_num());
			userObj.put("reservation_price", reservationArr.get(i).getReservation_price());
			userObj.put("reservation_usage_start_time", reservationArr.get(i).getReservation_usage_start_time());
			userObj.put("reservation_usage_time", reservationArr.get(i).getReservation_usage_time());
			userObj.put("reservation_usage_end_time", reservationArr.get(i).getReservation_usage_end_time());
			userObj.put("reservation_usage_start_date", reservationArr.get(i).getReservation_usage_start_date());
			userObj.put("reservation_status", reservationArr.get(i).getReservation_status());
			userObj.put("stadium_num", reservationArr.get(i).getStadium_num());
			userObj.put("stadium_branch_num", reservationArr.get(i).getStadium_branch_num());
			userObj.put("stadium_name", reservationArr.get(i).getStadium_name());
			userObj.put("stadium_match_member", reservationArr.get(i).getStadium_match_member());
			userObj.put("stadium_reservation_start_time", reservationArr.get(i).getStadium_reservation_start_time());
			userObj.put("stadium_reservation_end_time", reservationArr.get(i).getStadium_reservation_end_time());
			userObj.put("stadium_delete_status", reservationArr.get(i).getStadium_delete_status());
			
			reservation.add(userObj);
			userMap.put("reservation", reservation);
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
