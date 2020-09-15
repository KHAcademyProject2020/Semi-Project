package team.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import reservation.model.service.ReservationService;
import reservation.model.vo.ReservationInfo;
import team.model.service.TeamService;
import team.model.vo.Team;

/**
 * Servlet implementation class MatchRegistServlet
 */
@WebServlet("/matchRegist.me")
public class MatchRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String reservation_code = request.getParameter("reservation_code");
		
		
		int result = new TeamService().teamRegistCheck(userId);
		if(result > 0) { 
			int codeCheck = new ReservationService().codeCheck(reservation_code);
			if(codeCheck > 0) {
				int codeCheck2 = new TeamService().codeCheck(reservation_code);
				if(codeCheck2 > 0) {
					result = 1; //중복등록불가
				}else {
					int check = new ReservationService().check(reservation_code, userId);
					if(check > 0) {
						Team team = new TeamService().selectTeamCode(userId);
						ReservationInfo reservationInfo = new ReservationService().selectReservationInfo(reservation_code);
						new TeamService().matchRegist(team.getTeam_code(), reservation_code, reservationInfo.getReservation_branch_num(), reservationInfo.getReservation_stadium_num());
						result = 2; //등록
						
					}else {
						result = 3; //예약코드등록불가
						
					}
				}
				
			}else {
				result = 4; //예약코드없음
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
