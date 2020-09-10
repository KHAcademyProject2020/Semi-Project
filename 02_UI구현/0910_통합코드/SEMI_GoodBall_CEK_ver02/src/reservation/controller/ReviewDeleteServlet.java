package reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import reservation.model.service.ReservationService;
import reservation.model.vo.Branch;
import reservation.model.vo.Review;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet("/reviewDelete.me")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch_num = request.getParameter("branch_num");
		String review_num = request.getParameter("review_num");
		int result = 1;
		new ReservationService().reviewDelete(review_num);
		Branch branch = new ReservationService().selectBranchPoint(branch_num);
		Review review = new ReservationService().selectReviewPoint(review_num);
		int avg = (branch.getBranch_point()*2) - review.getReview_point();
		new ReservationService().updateBranchPoint(branch_num, avg);
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
