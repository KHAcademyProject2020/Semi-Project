package team.model.vo;

import java.sql.Date;

public class MatchApplication {
	private int match_regist_num;
	private String match_team;
	private int match_num;
	private String match_application_status;
	private String match_winlose;
	private String manager_point_status;
	private String match_branch_num;
	private int match_stadium_num;
	private String match_reservation_code;
	private int regist_num;
	private String regist_team;
	private String regist_reservation_code;
	private String regist_status;
	private String regist_branch_num;
	private int regist_stadium_num;
	private String team_code;
	private String team_leader;
	private int team_num;
	private String team_name;
	private String team_gender;
	private String team_age;
	private String team_region;
	private int team_point;
	private String team_mark_img;
	private Date team_active_lastday;
	private String team_delete_status;
	private String reservation_code;
	private String reservation_email;
	private String reservation_branch_num;
	private int reservation_stadium_num;
	private int reservation_num;
	private int reservation_price; 
	private int reservation_usage_start_time; 
	private int reservation_usage_time;
	private int reservation_usage_end_time; 
	private Date reservation_usage_start_date; 
	private String reservation_status; 
	private String branch_num;
	private String branch_manager_email;
	private String branch_address;
	private String branch_phone;
	private String branch_img;
	private String branch_website;
	private int branch_point;
	private String branch_option_shower;
	private String branch_option_park;
	private String branch_option_uniform;
	private String branch_option_shoes;
	private String branch_option_ball;
	private String branch_option_inout;
	private String branch_delete_status;
	private int stadium_num; 
	private String stadium_branch_num; 
	private String stadium_name; 
	private String stadium_match_member; 
	private int stadium_reservation_start_time; 
	private int stadium_reservation_end_time; 
	private String stadium_delete_status;
	public MatchApplication() {
		super();
	}
	public MatchApplication(int match_regist_num, String match_team, int match_num, String match_application_status,
			String match_winlose, String manager_point_status, String match_branch_num, int match_stadium_num,
			String match_reservation_code, int regist_num, String regist_team, String regist_reservation_code,
			String regist_status, String regist_branch_num, int regist_stadium_num, String team_code,
			String team_leader, int team_num, String team_name, String team_gender, String team_age, String team_region,
			int team_point, String team_mark_img, Date team_active_lastday, String team_delete_status,
			String reservation_code, String reservation_email, String reservation_branch_num,
			int reservation_stadium_num, int reservation_num, int reservation_price, int reservation_usage_start_time,
			int reservation_usage_time, int reservation_usage_end_time, Date reservation_usage_start_date,
			String reservation_status, String branch_num, String branch_manager_email, String branch_address,
			String branch_phone, String branch_img, String branch_website, int branch_point,
			String branch_option_shower, String branch_option_park, String branch_option_uniform,
			String branch_option_shoes, String branch_option_ball, String branch_option_inout,
			String branch_delete_status, int stadium_num, String stadium_branch_num, String stadium_name,
			String stadium_match_member, int stadium_reservation_start_time, int stadium_reservation_end_time,
			String stadium_delete_status) {
		super();
		this.match_regist_num = match_regist_num;
		this.match_team = match_team;
		this.match_num = match_num;
		this.match_application_status = match_application_status;
		this.match_winlose = match_winlose;
		this.manager_point_status = manager_point_status;
		this.match_branch_num = match_branch_num;
		this.match_stadium_num = match_stadium_num;
		this.match_reservation_code = match_reservation_code;
		this.regist_num = regist_num;
		this.regist_team = regist_team;
		this.regist_reservation_code = regist_reservation_code;
		this.regist_status = regist_status;
		this.regist_branch_num = regist_branch_num;
		this.regist_stadium_num = regist_stadium_num;
		this.team_code = team_code;
		this.team_leader = team_leader;
		this.team_num = team_num;
		this.team_name = team_name;
		this.team_gender = team_gender;
		this.team_age = team_age;
		this.team_region = team_region;
		this.team_point = team_point;
		this.team_mark_img = team_mark_img;
		this.team_active_lastday = team_active_lastday;
		this.team_delete_status = team_delete_status;
		this.reservation_code = reservation_code;
		this.reservation_email = reservation_email;
		this.reservation_branch_num = reservation_branch_num;
		this.reservation_stadium_num = reservation_stadium_num;
		this.reservation_num = reservation_num;
		this.reservation_price = reservation_price;
		this.reservation_usage_start_time = reservation_usage_start_time;
		this.reservation_usage_time = reservation_usage_time;
		this.reservation_usage_end_time = reservation_usage_end_time;
		this.reservation_usage_start_date = reservation_usage_start_date;
		this.reservation_status = reservation_status;
		this.branch_num = branch_num;
		this.branch_manager_email = branch_manager_email;
		this.branch_address = branch_address;
		this.branch_phone = branch_phone;
		this.branch_img = branch_img;
		this.branch_website = branch_website;
		this.branch_point = branch_point;
		this.branch_option_shower = branch_option_shower;
		this.branch_option_park = branch_option_park;
		this.branch_option_uniform = branch_option_uniform;
		this.branch_option_shoes = branch_option_shoes;
		this.branch_option_ball = branch_option_ball;
		this.branch_option_inout = branch_option_inout;
		this.branch_delete_status = branch_delete_status;
		this.stadium_num = stadium_num;
		this.stadium_branch_num = stadium_branch_num;
		this.stadium_name = stadium_name;
		this.stadium_match_member = stadium_match_member;
		this.stadium_reservation_start_time = stadium_reservation_start_time;
		this.stadium_reservation_end_time = stadium_reservation_end_time;
		this.stadium_delete_status = stadium_delete_status;
	}
	public int getMatch_regist_num() {
		return match_regist_num;
	}
	public void setMatch_regist_num(int match_regist_num) {
		this.match_regist_num = match_regist_num;
	}
	public String getMatch_team() {
		return match_team;
	}
	public void setMatch_team(String match_team) {
		this.match_team = match_team;
	}
	public int getMatch_num() {
		return match_num;
	}
	public void setMatch_num(int match_num) {
		this.match_num = match_num;
	}
	public String getMatch_application_status() {
		return match_application_status;
	}
	public void setMatch_application_status(String match_application_status) {
		this.match_application_status = match_application_status;
	}
	public String getMatch_winlose() {
		return match_winlose;
	}
	public void setMatch_winlose(String match_winlose) {
		this.match_winlose = match_winlose;
	}
	public String getManager_point_status() {
		return manager_point_status;
	}
	public void setManager_point_status(String manager_point_status) {
		this.manager_point_status = manager_point_status;
	}
	public String getMatch_branch_num() {
		return match_branch_num;
	}
	public void setMatch_branch_num(String match_branch_num) {
		this.match_branch_num = match_branch_num;
	}
	public int getMatch_stadium_num() {
		return match_stadium_num;
	}
	public void setMatch_stadium_num(int match_stadium_num) {
		this.match_stadium_num = match_stadium_num;
	}
	public String getMatch_reservation_code() {
		return match_reservation_code;
	}
	public void setMatch_reservation_code(String match_reservation_code) {
		this.match_reservation_code = match_reservation_code;
	}
	public int getRegist_num() {
		return regist_num;
	}
	public void setRegist_num(int regist_num) {
		this.regist_num = regist_num;
	}
	public String getRegist_team() {
		return regist_team;
	}
	public void setRegist_team(String regist_team) {
		this.regist_team = regist_team;
	}
	public String getRegist_reservation_code() {
		return regist_reservation_code;
	}
	public void setRegist_reservation_code(String regist_reservation_code) {
		this.regist_reservation_code = regist_reservation_code;
	}
	public String getRegist_status() {
		return regist_status;
	}
	public void setRegist_status(String regist_status) {
		this.regist_status = regist_status;
	}
	public String getRegist_branch_num() {
		return regist_branch_num;
	}
	public void setRegist_branch_num(String regist_branch_num) {
		this.regist_branch_num = regist_branch_num;
	}
	public int getRegist_stadium_num() {
		return regist_stadium_num;
	}
	public void setRegist_stadium_num(int regist_stadium_num) {
		this.regist_stadium_num = regist_stadium_num;
	}
	public String getTeam_code() {
		return team_code;
	}
	public void setTeam_code(String team_code) {
		this.team_code = team_code;
	}
	public String getTeam_leader() {
		return team_leader;
	}
	public void setTeam_leader(String team_leader) {
		this.team_leader = team_leader;
	}
	public int getTeam_num() {
		return team_num;
	}
	public void setTeam_num(int team_num) {
		this.team_num = team_num;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_gender() {
		return team_gender;
	}
	public void setTeam_gender(String team_gender) {
		this.team_gender = team_gender;
	}
	public String getTeam_age() {
		return team_age;
	}
	public void setTeam_age(String team_age) {
		this.team_age = team_age;
	}
	public String getTeam_region() {
		return team_region;
	}
	public void setTeam_region(String team_region) {
		this.team_region = team_region;
	}
	public int getTeam_point() {
		return team_point;
	}
	public void setTeam_point(int team_point) {
		this.team_point = team_point;
	}
	public String getTeam_mark_img() {
		return team_mark_img;
	}
	public void setTeam_mark_img(String team_mark_img) {
		this.team_mark_img = team_mark_img;
	}
	public Date getTeam_active_lastday() {
		return team_active_lastday;
	}
	public void setTeam_active_lastday(Date team_active_lastday) {
		this.team_active_lastday = team_active_lastday;
	}
	public String getTeam_delete_status() {
		return team_delete_status;
	}
	public void setTeam_delete_status(String team_delete_status) {
		this.team_delete_status = team_delete_status;
	}
	public String getReservation_code() {
		return reservation_code;
	}
	public void setReservation_code(String reservation_code) {
		this.reservation_code = reservation_code;
	}
	public String getReservation_email() {
		return reservation_email;
	}
	public void setReservation_email(String reservation_email) {
		this.reservation_email = reservation_email;
	}
	public String getReservation_branch_num() {
		return reservation_branch_num;
	}
	public void setReservation_branch_num(String reservation_branch_num) {
		this.reservation_branch_num = reservation_branch_num;
	}
	public int getReservation_stadium_num() {
		return reservation_stadium_num;
	}
	public void setReservation_stadium_num(int reservation_stadium_num) {
		this.reservation_stadium_num = reservation_stadium_num;
	}
	public int getReservation_num() {
		return reservation_num;
	}
	public void setReservation_num(int reservation_num) {
		this.reservation_num = reservation_num;
	}
	public int getReservation_price() {
		return reservation_price;
	}
	public void setReservation_price(int reservation_price) {
		this.reservation_price = reservation_price;
	}
	public int getReservation_usage_start_time() {
		return reservation_usage_start_time;
	}
	public void setReservation_usage_start_time(int reservation_usage_start_time) {
		this.reservation_usage_start_time = reservation_usage_start_time;
	}
	public int getReservation_usage_time() {
		return reservation_usage_time;
	}
	public void setReservation_usage_time(int reservation_usage_time) {
		this.reservation_usage_time = reservation_usage_time;
	}
	public int getReservation_usage_end_time() {
		return reservation_usage_end_time;
	}
	public void setReservation_usage_end_time(int reservation_usage_end_time) {
		this.reservation_usage_end_time = reservation_usage_end_time;
	}
	public Date getReservation_usage_start_date() {
		return reservation_usage_start_date;
	}
	public void setReservation_usage_start_date(Date reservation_usage_start_date) {
		this.reservation_usage_start_date = reservation_usage_start_date;
	}
	public String getReservation_status() {
		return reservation_status;
	}
	public void setReservation_status(String reservation_status) {
		this.reservation_status = reservation_status;
	}
	public String getBranch_num() {
		return branch_num;
	}
	public void setBranch_num(String branch_num) {
		this.branch_num = branch_num;
	}
	public String getBranch_manager_email() {
		return branch_manager_email;
	}
	public void setBranch_manager_email(String branch_manager_email) {
		this.branch_manager_email = branch_manager_email;
	}
	public String getBranch_address() {
		return branch_address;
	}
	public void setBranch_address(String branch_address) {
		this.branch_address = branch_address;
	}
	public String getBranch_phone() {
		return branch_phone;
	}
	public void setBranch_phone(String branch_phone) {
		this.branch_phone = branch_phone;
	}
	public String getBranch_img() {
		return branch_img;
	}
	public void setBranch_img(String branch_img) {
		this.branch_img = branch_img;
	}
	public String getBranch_website() {
		return branch_website;
	}
	public void setBranch_website(String branch_website) {
		this.branch_website = branch_website;
	}
	public int getBranch_point() {
		return branch_point;
	}
	public void setBranch_point(int branch_point) {
		this.branch_point = branch_point;
	}
	public String getBranch_option_shower() {
		return branch_option_shower;
	}
	public void setBranch_option_shower(String branch_option_shower) {
		this.branch_option_shower = branch_option_shower;
	}
	public String getBranch_option_park() {
		return branch_option_park;
	}
	public void setBranch_option_park(String branch_option_park) {
		this.branch_option_park = branch_option_park;
	}
	public String getBranch_option_uniform() {
		return branch_option_uniform;
	}
	public void setBranch_option_uniform(String branch_option_uniform) {
		this.branch_option_uniform = branch_option_uniform;
	}
	public String getBranch_option_shoes() {
		return branch_option_shoes;
	}
	public void setBranch_option_shoes(String branch_option_shoes) {
		this.branch_option_shoes = branch_option_shoes;
	}
	public String getBranch_option_ball() {
		return branch_option_ball;
	}
	public void setBranch_option_ball(String branch_option_ball) {
		this.branch_option_ball = branch_option_ball;
	}
	public String getBranch_option_inout() {
		return branch_option_inout;
	}
	public void setBranch_option_inout(String branch_option_inout) {
		this.branch_option_inout = branch_option_inout;
	}
	public String getBranch_delete_status() {
		return branch_delete_status;
	}
	public void setBranch_delete_status(String branch_delete_status) {
		this.branch_delete_status = branch_delete_status;
	}
	public int getStadium_num() {
		return stadium_num;
	}
	public void setStadium_num(int stadium_num) {
		this.stadium_num = stadium_num;
	}
	public String getStadium_branch_num() {
		return stadium_branch_num;
	}
	public void setStadium_branch_num(String stadium_branch_num) {
		this.stadium_branch_num = stadium_branch_num;
	}
	public String getStadium_name() {
		return stadium_name;
	}
	public void setStadium_name(String stadium_name) {
		this.stadium_name = stadium_name;
	}
	public String getStadium_match_member() {
		return stadium_match_member;
	}
	public void setStadium_match_member(String stadium_match_member) {
		this.stadium_match_member = stadium_match_member;
	}
	public int getStadium_reservation_start_time() {
		return stadium_reservation_start_time;
	}
	public void setStadium_reservation_start_time(int stadium_reservation_start_time) {
		this.stadium_reservation_start_time = stadium_reservation_start_time;
	}
	public int getStadium_reservation_end_time() {
		return stadium_reservation_end_time;
	}
	public void setStadium_reservation_end_time(int stadium_reservation_end_time) {
		this.stadium_reservation_end_time = stadium_reservation_end_time;
	}
	public String getStadium_delete_status() {
		return stadium_delete_status;
	}
	public void setStadium_delete_status(String stadium_delete_status) {
		this.stadium_delete_status = stadium_delete_status;
	}
	
}
