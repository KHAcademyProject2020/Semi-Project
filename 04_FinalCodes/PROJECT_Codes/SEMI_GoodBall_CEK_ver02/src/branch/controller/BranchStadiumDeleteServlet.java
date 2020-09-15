package branch.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import branch.model.service.BranchService;

/**
 * Servlet implementation class BranchStadiumDeleteServlet
 */
@WebServlet("/branchStadiumDelete.br")
public class BranchStadiumDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchStadiumDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String branch_num = request.getParameter("branch_num");
		String stadium_name = request.getParameter("stadium_name");
		
		int result = new BranchService().deleteStadium(branch_num, stadium_name);
		
		if(result > 0) {
			request.getRequestDispatcher("WEB-INF/views/member/manager/Manager_BranchConPage.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "삭제되지 않았습니다");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
