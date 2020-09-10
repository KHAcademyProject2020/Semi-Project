package member.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet("/findEmail")
public class FindEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindEmail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("find_name");
		String phone = request.getParameter("find_phone");

		Member find = new Member();
		find.setName(name);
		find.setPhone(phone);


		Member member = MemberService.seaechEamil(find);

		System.out.println(member);
		
		if (member != null) {
			request.setAttribute("Member", member);
			RequestDispatcher em = request.getRequestDispatcher("/WEB-INF/views/member/searchEmail.jsp");
			em.forward(request, response);
		} else {
			request.setAttribute("msg", "정확한 정보를 입력해 주세요!");
			RequestDispatcher em = request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
			em.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
