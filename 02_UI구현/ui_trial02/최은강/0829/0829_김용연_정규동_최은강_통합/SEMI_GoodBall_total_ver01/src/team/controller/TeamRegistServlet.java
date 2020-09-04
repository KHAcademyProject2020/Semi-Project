package team.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;

import member.model.vo.Member;
import team.model.service.TeamService;
import team.model.vo.Team;

/**
 * Servlet implementation class TeamRegistServlet
 */
@WebServlet("/teamRegist.me")
public class TeamRegistServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      request.setCharacterEncoding("UTF-8");
      
      String userId = ((Member)request.getSession().getAttribute("loginUser")).getEmail();
      String root = request.getSession().getServletContext().getRealPath("/");
      String savePath = root + "resources/storage/"+userId+"/team_img/";
      //String savePath= "C:/Users/USER/Documents/GitHub/Semi-Project/02_UI구현/ui_trial02/최은강/0829/0829_김용연_정규동_최은강_통합/SEMI_GoodBall_total_ver01/WebContent/resources/storage/"+userId+"/team_img";
      
      File f = new File(savePath);
      if(!f.exists()) {
         f.mkdirs();
      }
      String savePath2 = root + "resources/storage/"+userId+"/team_img/";
      
      //String savePath2= "C:/Users/USER/Documents/GitHub/Semi-Project/02_UI구현/ui_trial02/최은강/0829/0829_김용연_정규동_최은강_통합/SEMI_GoodBall_total_ver01/WebContent/resources/storage/"+userId+"/team_img";
      System.out.println(savePath2);
      
      
      int maxSize = 1024 * 1024 * 10;
      MultipartRequest multiRequest = new MultipartRequest(request, savePath2, maxSize, "UTF-8", new MyFileRenamePolicy());
      System.out.println(multiRequest.getFileNames());
      
      String team_name = multiRequest.getParameter("team_name");
      String team_gender = multiRequest.getParameter("team_gender");
      String team_age = multiRequest.getParameter("team_age");
      String sido1 = multiRequest.getParameter("sido1");
      String gugun1 = multiRequest.getParameter("gugun1");
      String team_mark = multiRequest.getParameter("fileName");
      String team_region = sido1 + " " + gugun1;
      
      System.out.println(team_name);
      System.out.println(team_gender);
      System.out.println(team_age);
      System.out.println(team_region);
      System.out.println(team_mark);
         
      String teamMessage = null;
      int result = new TeamService().teamRegistCheck(userId);
         
      if(result > 0) {
         teamMessage = "팀1개이상등록불가";
      
      }else { //팀등록;
         
         int ckName = new TeamService().teamRegistNameCheck(team_name);
         if(ckName > 0) {
            teamMessage = "팀이름중복";
         }else {
            
            Random rand = new Random();
            String team_code = "";
            int ckCode = 0;
            do{
               for(int i=0; i<=5; i++) {
                  String ran = Integer.toString(rand.nextInt(10));
                  if(!team_code.contains(ran)) {
                     team_code += ran;
                  }else {
                     i-=1;
                  }
               }
               
               ckCode = new TeamService().teamCodeCheck(team_code);
            }while(ckCode == 1);
            
            
            new TeamService().teamRegist(new Team(team_code, userId, team_name, team_gender, team_age, team_region, team_mark));
            teamMessage = "팀가입완료";
         }
           
      }
      System.out.println(teamMessage);
      HttpSession session = request.getSession();
        session.setAttribute("teamMessage", teamMessage); // loginUser라는 name으로 넘겨줌
      RequestDispatcher view = request.getRequestDispatcher("/team.me");
      view.forward(request, response);
   
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}