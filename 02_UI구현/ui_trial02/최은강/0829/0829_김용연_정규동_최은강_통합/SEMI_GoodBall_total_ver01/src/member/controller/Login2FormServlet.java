package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;



/**
 * Servlet implementation class Login2FormServlet
 */
@WebServlet(urlPatterns="/login2.me",name="Login2FormServlet")
public class Login2FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login2FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			
			String userEmail = request.getParameter("inputEmail");
			String userPwd = request.getParameter("inputPassword");
			
			System.out.println(userEmail);
			System.out.println(userPwd);
			
			
			Member member = new Member(userEmail, userPwd);
			Member loginUser = new MemberService().loginMember(member);
				
			if(loginUser != null) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(600); // 
				session.setAttribute("loginUser", loginUser); 
				response.sendRedirect(request.getContextPath());
			} else {
				request.setAttribute("msg", "로그인실패");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
				view.forward(request, response);
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
