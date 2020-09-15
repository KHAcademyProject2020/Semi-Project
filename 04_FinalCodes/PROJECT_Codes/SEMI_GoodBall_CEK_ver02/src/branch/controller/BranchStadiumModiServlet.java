package branch.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import branch.model.service.BranchService;
import branch.model.vo.Stadium;

/**
 * Servlet implementation class BranchStadiumModiServlet
 */
@WebServlet("/branchStadiumModify.br")
public class BranchStadiumModiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchStadiumModiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String branch_num = request.getParameter("branch_num");
		String stadium_name = request.getParameter("stadium_name");
		
		System.out.println(branch_num);
		System.out.println(stadium_name);
		
		Stadium stadium = new BranchService().getStadiumInfo(branch_num, stadium_name);
		
		request.setAttribute("stadium", stadium);
		request.getRequestDispatcher("WEB-INF/views/member/manager/Manager_BranchStadiumModiPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
