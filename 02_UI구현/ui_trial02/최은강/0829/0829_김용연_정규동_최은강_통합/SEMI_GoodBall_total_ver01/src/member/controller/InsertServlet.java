package member.controller;

import java.io.File;
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
 * Servlet implementation class InsertServlet
 */
@WebServlet(urlPatterns = "/insert", name = "InsertServlet")
public class InsertServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public InsertServlet() {
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

      String email = request.getParameter("email");
      String pwd = request.getParameter("password");
      String name = request.getParameter("name");
      String date = request.getParameter("birthday");
      String gender = request.getParameter("gender");
      String phone1 = request.getParameter("phone1");
      /*
       * String phone2= request.getParameter("phone2"); String phone3 =
       * request.getParameter("phone3");
       */
      //String address1 = request.getParameter("address1");
      String address2 = request.getParameter("address2");
      String address3 = request.getParameter("address3");
      String address4 = request.getParameter("address4");
      String address5 = request.getParameter("address5");
      String member_type = request.getParameter("member_type");

      ArrayList<String> addressArr = new ArrayList<String>();

      //addressArr.add(address1);
      addressArr.add(address2);
      addressArr.add(address3);
      addressArr.add(address4);
      addressArr.add(address5);
      
       String address = ""; 
       for(int i = 0; i < addressArr.size(); i++) {
       
          if(i == addressArr.size()-1) { 
             address += addressArr.get(i); 
             
          } else { 
             address += addressArr.get(i) + " "; 
             
          }
          
       }
   
       System.out.println(address);
       
     
    

      Date dat = null;
      if (date != "") {
         String[] dateArr = date.split("-");

         int year = Integer.parseInt(dateArr[0]);
         int month = Integer.parseInt(dateArr[1]) - 1;
         int day = Integer.parseInt(dateArr[2]);

         dat = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
      } else {
         dat = new Date(new GregorianCalendar().getTimeInMillis());
      }

      Member member = new Member(email, pwd, name, dat, gender, phone1, address, member_type);

      int result = new MemberService().insertMember(member);
      System.out.println(result);
      String path = null;

      String root= request.getSession().getServletContext().getRealPath("/");
      if (result > 0) {
         path= root+"/resources/storage/"+email+"/";
         File Folder = new File(path);

         // 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
         if (!Folder.exists()) {
            try {
               Folder.mkdir(); // 폴더 생성합니다.
               System.out.println("폴더가 생성되었습니다.");
            } catch (Exception e) {
               e.getStackTrace();
            }
         } else {
            System.out.println("이미 폴더가 생성되어 있습니다.");
         }
         response.sendRedirect(request.getContextPath());
         request.getSession().setAttribute("msg", "회원가입에 성공하였습니다.");
         // 너무 많은 데이터를 세션으로 사용하면 관리하기가 힘들다.
      } else {
         request.setAttribute("msg", "회원가입에 실패하였습니다.");
         request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
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