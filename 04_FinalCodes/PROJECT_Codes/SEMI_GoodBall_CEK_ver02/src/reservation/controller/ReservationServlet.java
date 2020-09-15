package reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.model.service.ReservationService;
import reservation.model.vo.Branch;
import reservation.model.vo.Stadium;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/reservation.me")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//구장에서 예약페이지로 넘어간다.
		String stadium_num = request.getParameter("stadium_num");
		
	    Stadium stadium = new ReservationService().selectStadiumInfo(stadium_num);
	    System.out.println(stadium_num);

		request.setAttribute("stadium", stadium);
		
		request.getRequestDispatcher("WEB-INF/views/reservation/GB_frame_reservation.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
