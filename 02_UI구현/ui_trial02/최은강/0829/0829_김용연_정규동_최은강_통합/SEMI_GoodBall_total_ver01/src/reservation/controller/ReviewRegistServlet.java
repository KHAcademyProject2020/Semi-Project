package reservation.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.model.vo.Member;
import reservation.model.service.ReservationService;
import reservation.model.vo.Branch;

/**
 * Servlet implementation class ReviewRegistServlet
 */
@WebServlet("/reviewRegist.me")
public class ReviewRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch_num = request.getParameter("branch_num");
		String review_content = request.getParameter("review_content");
		
		int review_point = Integer.parseInt(request.getParameter("review_point")); // 부여한 리뷰점수...
		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getEmail();
		
		// (최은강) reviewer_count: 구장상관없이 지점을 이용한 리뷰작성자 수
		int reviewer_count=new ReservationService().countReviewer(branch_num); // 0~ (지점리뷰수)
		
		// (최은강) sum_branch_point: 지점 리뷰 총점수
		int sum_branch_point= new ReservationService().getTotalBranchPoint(branch_num); // 지점에대한 리뷰점수 전체합계
		
				
		int result = new ReservationService().reviewIdCheck(userId, branch_num);
		if(result > 0) { //아이디중복
			result = 1;
		}else {
			int check = new ReservationService().branchUseCheck(userId, branch_num);
			if(check > 0) { //사용함
				Branch branch = new ReservationService().selectBranchPoint(branch_num);
				
				//(정창섭)
				//int avg = (branch.getBranch_point() +  review_point) /2;
				
				//(최은강)+(정창섭) : reviewer_count+1 
				//					=> 현재 리뷰등록자(1) + 지점리뷰등록자수(reviewer_count)
				int avg= ((review_point+ sum_branch_point)/ (reviewer_count+1));
				
				//(정창섭)
				new ReservationService().updateBranchPoint(branch_num, avg);
							
				SimpleDateFormat transFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
				String date = transFormat.format(System.currentTimeMillis());
				new ReservationService().reviewRegist(userId, branch_num, review_content, review_point, date);
				result = 2; //등록
				
			}else {
				result = 3; //사용하지않음
				
			}
			
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
