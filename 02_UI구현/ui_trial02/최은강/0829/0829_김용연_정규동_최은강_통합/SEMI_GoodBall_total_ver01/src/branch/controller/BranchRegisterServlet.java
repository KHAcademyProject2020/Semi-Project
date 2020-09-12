package branch.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import branch.model.service.BranchService;
import branch.model.vo.Branch;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class BranchRegisterServlet
 */
@WebServlet("/registerBranch.br")
public class BranchRegisterServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String userId = ((Member)request.getSession().getAttribute("loginUser")).getEmail();
      String root = request.getSession().getServletContext().getRealPath("/");
      //String savePath = root + "resources/storage/"+userId;
      String savePath = root+"/resources/storage/"+userId+"/branch_img";
      File f = new File(savePath);
      if(!f.exists()) {
         f.mkdirs();
      }
      String savePath2 = root + "resources/storage/"+userId+"/";
      //String savePath2 = "/Users/dennis/Desktop/GB-total4/SEMI_GoodBall_CEK/WebContent/resources/storage/"+userId+"/branch_img";
      System.out.println(savePath2);
      
      
      int maxSize = 1024 * 1024 * 10;
      MultipartRequest multiRequest = new MultipartRequest(request, savePath2, maxSize, "UTF-8", new MyFileRenamePolicy());
      System.out.println(multiRequest.getFileNames());
      
      String branch_num = multiRequest.getParameter("branchName");
      String branch_branchInfo = multiRequest.getParameter("branchInfo");
      String branch_detailInfo = multiRequest.getParameter("detailInfo");
      String branch_option_shower = multiRequest.getParameter("shower");
      String branch_option_park = multiRequest.getParameter("parking");
      String branch_option_uniform = multiRequest.getParameter("uniform");
      String branch_option_shoes = multiRequest.getParameter("shoes");
      String branch_option_ball = multiRequest.getParameter("ball");
      String branch_option_inout = multiRequest.getParameter("place");
      String branch_notes = multiRequest.getParameter("notes");
      String branch_website = multiRequest.getParameter("sns");
      String branch_img = multiRequest.getParameter("fileName");
      String branch_phone = multiRequest.getParameter("phone");
      int point = 0;
      String status = "N";
      
      String address2 = multiRequest.getParameter("address2");
      String address3 = multiRequest.getParameter("address3");
      String address4 = multiRequest.getParameter("address4");
      String address5 = multiRequest.getParameter("address5");
      
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
         
         Branch branch = new Branch(branch_num, userId, branch_address, branch_phone, branch_img, branch_website, branch_branchInfo, branch_detailInfo, branch_notes, point, branch_option_shower, branch_option_park, branch_option_uniform, branch_option_shoes, branch_option_ball, branch_option_inout, status);

         int result = new BranchService().insertBranch(branch);
      
         if(result > 0) {
            request.getRequestDispatcher("WEB-INF/views/member/manager/moveView.jsp").forward(request, response);
         } else {
            request.setAttribute("msg", "지점등록에 실패하였습니다.");
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