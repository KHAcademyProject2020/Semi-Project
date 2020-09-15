package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet(urlPatterns = "/updatePassword", name = "UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email =request.getParameter("update-pwd");
		
		System.out.println(email + "***");
		
		String newPwd1 = request.getParameter("newPwd1");
	
		int  result = new MemberService().updatePassword(email,newPwd1);
		
		System.out.println(result);
		
		if(result > 0) {
			/* response.sendRedirect("WEB-INF/views/common/loginForm.jsp"); */
			
			 request.getRequestDispatcher("WEB-INF/views/member/loginForm.jsp").forward( request, response);
			 
			// 너무 많은 데이터를 세션으로 사용하면 관리하기가 힘들다.
		} else {
			request.setAttribute("msg", "비밀번호 변경에 실패하였습니다.");
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
