package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class FindPwd
 */
@WebServlet("/FindPwd")
public class FindPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      String email = request.getParameter("find_email");
	      String name = request.getParameter("find_name");
	      
	      System.out.println(email);
	      System.out.println(name);
	   
	      Member findP = new Member();
	      findP.setEmail(email);
	      findP.setName(name);
	      
	      
	      System.out.println(findP +"서블릿1");

	      int result  = new MemberService().searchPassword2(findP);
	      System.out.println(result);
	      if(result > 0) {
	         Member member = new MemberService().searchPassword(findP);
	         request.setAttribute("member", member);
	         RequestDispatcher em = request.getRequestDispatcher("/WEB-INF/views/member/searchPassword.jsp");
	         em.forward(request, response);
	      }else {
	         request.setAttribute("msg", "정확한 정보를 입력해 주세요!");
	         RequestDispatcher em = request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
	         em.forward(request, response);
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
