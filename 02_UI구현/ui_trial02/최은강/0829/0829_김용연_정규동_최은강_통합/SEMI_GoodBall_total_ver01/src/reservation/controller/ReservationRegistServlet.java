package reservation.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.model.vo.Member;
import reservation.model.service.ReservationService;
import reservation.model.vo.ReservationInfo;

/**
 * Servlet implementation class ReservationRegistServlet
 */
@WebServlet("/reservationRegist.me")
public class ReservationRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = 1;
		//코드확인
		Random rand = new Random();
		String reservation_code = "";
		int ckCode = 0;
		do{
			for(int i=0; i<=5; i++) {
				String ran = Integer.toString(rand.nextInt(10));
				if(!reservation_code.contains(ran)) {
					reservation_code += ran;
				}else {
					i-=1;
				}
			}
			ckCode = new ReservationService().reservationCodeCheck(reservation_code);
		}while(ckCode == 1);
		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getEmail();
		String reservation_branch_num = request.getParameter("reservation_branch_num");
		int reservation_stadium_num = (Integer.parseInt(request.getParameter("reservation_stadium_num")));
		int reservation_price = (Integer.parseInt(request.getParameter("reservation_price")));
		int reservation_usage_start_time = (Integer.parseInt(request.getParameter("reservation_usage_start_time")));
		int reservation_usage_time = (Integer.parseInt(request.getParameter("reservation_usage_time")));
		int reservation_usage_end_time = (Integer.parseInt(request.getParameter("reservation_usage_end_time")));
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
		
		ReservationInfo reservation = new ReservationInfo(reservation_code, userId, reservation_branch_num, reservation_stadium_num, reservation_price,
				reservation_usage_start_time, reservation_usage_time, reservation_usage_end_time, dat);
		
		new ReservationService().reservationRegist(reservation);
		
		
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
