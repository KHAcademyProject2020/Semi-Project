package branch.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import branch.model.service.BranchService;
import branch.model.vo.Branch;
import branch.model.vo.Stadium;
import reservation.model.vo.PageInfo;

/**
 * Servlet implementation class BranchPagingServlet
 */
@WebServlet("/branchStadium.br")
public class BranchStadiumInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchStadiumInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("branch_num");

	    JSONObject stadiumObj = null;
	    JSONArray stadiumArray = null;
	    JSONObject stadiumMap = null;
	    
	    ArrayList<Stadium> stadiumArr = new BranchService().selectStadiumList(num);

	    stadiumArray = new JSONArray();
	    stadiumMap = new JSONObject();
	    
	    if(stadiumArr != null) {
	   
		    for(int i = 0; i < stadiumArr.size(); i++) {
		    	stadiumObj = new JSONObject();
		    	stadiumObj.put("stadium_num", stadiumArr.get(i).getStadium_num());
		    	stadiumObj.put("branch_num", stadiumArr.get(i).getBranch_num());
		    	stadiumObj.put("stadium_name", stadiumArr.get(i).getStadium_name());
		    	stadiumObj.put("stadium_match_member", stadiumArr.get(i).getStadium_match_member());
		    	stadiumObj.put("stadium_reservation_start_time", stadiumArr.get(i).getStadium_reservation_start_time());
		    	stadiumObj.put("stadium_reservation_end_time", stadiumArr.get(i).getStadium_reservation_end_time());
		    	stadiumObj.put("branch_manager_email", stadiumArr.get(i).getBranch_manager_email());
		    	stadiumObj.put("branch_address", stadiumArr.get(i).getBranch_address());
		    	stadiumObj.put("branch_phone", stadiumArr.get(i).getBranch_phone());
		    	stadiumObj.put("branch_img", stadiumArr.get(i).getBranch_img());
		    	stadiumObj.put("branch_website", stadiumArr.get(i).getBranch_website());
		    	stadiumObj.put("branch_point", stadiumArr.get(i).getBranch_point());
		    	stadiumObj.put("branch_option_shower", stadiumArr.get(i).getBranch_option_shower());
		    	stadiumObj.put("branch_option_park", stadiumArr.get(i).getBranch_option_park());
		    	stadiumObj.put("branch_option_uniform", stadiumArr.get(i).getBranch_option_uniform());
		    	stadiumObj.put("branch_option_shoes", stadiumArr.get(i).getBranch_option_shoes());
		    	stadiumObj.put("branch_option_ball", stadiumArr.get(i).getBranch_option_ball());
		    	stadiumObj.put("branch_option_inout", stadiumArr.get(i).getBranch_option_inout());
		    	
		    	stadiumArray.add(stadiumObj);
		    	stadiumMap.put("stadiumArray", stadiumArr);
		    	
		    }
	    }
	    
	    response.setContentType("application/json; charset=UTF-8");   
	    new Gson().toJson(stadiumMap, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
