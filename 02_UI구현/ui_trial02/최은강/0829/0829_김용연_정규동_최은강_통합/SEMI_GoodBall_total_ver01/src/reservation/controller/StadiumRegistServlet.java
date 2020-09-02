package reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import reservation.model.service.ReservationService;

/**
 * Servlet implementation class StadiumRegistServlet
 */
@WebServlet("/stadiumRegist.me")
public class StadiumRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StadiumRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String branch_num = request.getParameter("branch_num");
		String stadium_name = request.getParameter("stadium_name");
		String stadium_matchMember = request.getParameter("stadium_matchMember");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		System.out.println(userId);
		System.out.println(stadium_name);
		System.out.println(branch_num);
		System.out.println(stadium_matchMember);
		System.out.println(startTime);
		System.out.println(endTime);
		
		int result = new ReservationService().stadiumNameCheck(branch_num, stadium_name);
		if(result > 0) {
			result = 1;
		}else {
			new ReservationService().stadiumRegist(branch_num, stadium_name, stadium_matchMember, startTime, endTime);
			result = 2;
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
