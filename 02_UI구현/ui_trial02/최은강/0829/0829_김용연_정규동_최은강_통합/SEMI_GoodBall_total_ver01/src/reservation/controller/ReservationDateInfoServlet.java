package reservation.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
import reservation.model.vo.Stadium;

/**
 * Servlet implementation class ReservationDateInfoServlet
 */
@WebServlet("/reservationDateInfo.me")
public class ReservationDateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int reservation_stadium_num = (Integer.parseInt(request.getParameter("reservation_stadium_num")));
		String reservation_usage_start_date = request.getParameter("reservation_usage_start_date");
		Date dat = null;
		if(reservation_usage_start_date != "") {
			String[] dateArr = reservation_usage_start_date.split("-");
			
			int year = Integer.parseInt(dateArr[0]);
			int month = Integer.parseInt(dateArr[1]) - 1;
			int day = Integer.parseInt(dateArr[2]);
			
			dat = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		} else {
			dat = new Date(new GregorianCalendar().getTimeInMillis());
			
		}
		
		ArrayList<ReservationInfo> reservationDateArr = new ReservationService().selectReservationDateList(reservation_stadium_num, dat);
		
		JSONObject userObj = null;
		JSONArray reservation = new JSONArray();
		JSONObject userMap = new JSONObject();
		for(int i = 0; i < reservationDateArr.size(); i++) {
			userObj = new JSONObject();
			userObj.put("reservation_code", reservationDateArr.get(i).getReservation_code());
			userObj.put("reservation_email", reservationDateArr.get(i).getReservation_email());
			userObj.put("reservation_branch_num", reservationDateArr.get(i).getReservation_branch_num());
			userObj.put("reservation_stadium_num", reservationDateArr.get(i).getReservation_stadium_num());
			userObj.put("reservation_num", reservationDateArr.get(i).getReservation_num());
			userObj.put("reservation_price", reservationDateArr.get(i).getReservation_price());
			userObj.put("reservation_usage_start_time", reservationDateArr.get(i).getReservation_usage_start_time());
			userObj.put("reservation_usage_time", reservationDateArr.get(i).getReservation_usage_time());
			userObj.put("reservation_usage_end_time", reservationDateArr.get(i).getReservation_usage_end_time());
			userObj.put("reservation_usage_start_date", reservationDateArr.get(i).getReservation_usage_start_date());
			
			reservation.add(userObj);
			userMap.put("reservation", reservation);
			
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
