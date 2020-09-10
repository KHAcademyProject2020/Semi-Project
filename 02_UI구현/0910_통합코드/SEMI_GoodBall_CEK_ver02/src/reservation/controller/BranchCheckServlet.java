package reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import reservation.model.service.ReservationService;
import reservation.model.vo.Branch;

/**
 * Servlet implementation class BranchCheckServlet
 */
@WebServlet("/branchCheck.me")
public class BranchCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		String userId = request.getParameter("userId");
		System.out.println(userId);
		ArrayList<Branch> branchArr = null;
		
		result = new ReservationService().getBranchCount(userId);
		System.out.println(result);
		branchArr = new ArrayList<Branch>();
		if(result > 0) {
			branchArr = new ReservationService().selectBranchList(userId);
		}else {
			branchArr = null;
		}
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(branchArr, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
