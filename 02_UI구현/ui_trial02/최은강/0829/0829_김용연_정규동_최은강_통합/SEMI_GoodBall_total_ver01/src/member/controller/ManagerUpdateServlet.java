package member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ManagerMyPageUpdateServlet
 */

@WebServlet(urlPatterns="/updateMember.me",name="ManagerUpdateServlet")
public class ManagerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		String memberType = loginUser.getMember_type();
		
		String originPwd = loginUser.getPwd();
		String originAddress = loginUser.getAddress();
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		String pwd = request.getParameter("password1");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birth");
		String gender= request.getParameter("gender");
		
		String password = null;
		if(pwd.equals("z4PhNX7vuL3xVChQ1m2AB9Yg5AULVxXcg/SpIdNs6c5H0NE8XYXysP+DGNKHfuwvY7kxvUdBeoGlODJ6+SfaPg==")) {
			password = originPwd;
		} else {
			password = pwd;
		}
		
		Date birth = null;
		if(birthday != "") {
			String[] birthArr = birthday.split("-");
			
			int year = Integer.parseInt(birthArr[0]);
			int month = Integer.parseInt(birthArr[1]) - 1;
			int day = Integer.parseInt(birthArr[2]);
			
			birth = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		} else {
			birth = new Date(new GregorianCalendar().getTimeInMillis());
		}
		
		  String address2 = request.getParameter("address2");
	      String address3 = request.getParameter("address3");
	      String address4 = request.getParameter("address4");
	      String address5 = request.getParameter("address5");
	      
	      ArrayList<String> addressArr = new ArrayList<String>();

	      addressArr.add(address2);
	      addressArr.add(address3);
	      addressArr.add(address4);
	      addressArr.add(address5);
	      
	      String branch_address  = "";

	      for (int i = 0; i < addressArr.size(); i++) {

	         if (i == addressArr.size() - 1) {
	            branch_address  += addressArr.get(i);

	         } else {
	            branch_address  += addressArr.get(i) + " ";

	         }
	      }
	     
	     if(branch_address.equals("null null null null")) {
	    	 branch_address = originAddress;
	     }
	      
	    System.out.println(branch_address);

		Member userInfo = null;
		
		if(memberType.equals("M")) {
			userInfo = new Member(id, password, name, birth, gender, phone, branch_address, "M");		
		} else {
			userInfo = new Member(id, password, name, birth, gender, phone, branch_address, "G");
		}
		
		
		int result = new MemberService().updateMember(userInfo);
		
		request.getSession().setAttribute("loginUser", userInfo);
		
		if(memberType.equals("M")) {
			request.getRequestDispatcher("WEB-INF/views/member/manager/Manager_ManagerPage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/views/member/general/General_GeneralPage.jsp").forward(request, response);
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