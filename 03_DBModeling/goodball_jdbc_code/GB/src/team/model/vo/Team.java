package team.model.vo;

import java.sql.Date;

public class Team {
	String team_code;
	String team_leader;
	String team_name;
	String team_gender;
	String team_age;
	String team_region;
	int team_point;
	String team_mark_img;
	Date team_active_lastday;
	String team_delete_status;
	public Team() {
		super();
	}
	public Team(String team_code, String team_leader, String team_name, String team_gender, String team_age,
			String team_region, int team_point, String team_mark_img, Date team_active_lastday,
			String team_delete_status) {
		super();
		this.team_code = team_code;
		this.team_leader = team_leader;
		this.team_name = team_name;
		this.team_gender = team_gender;
		this.team_age = team_age;
		this.team_region = team_region;
		this.team_point = team_point;
		this.team_mark_img = team_mark_img;
		this.team_active_lastday = team_active_lastday;
		this.team_delete_status = team_delete_status;
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
	@Override
	public String toString() {
		return "Team [team_code=" + team_code + ", team_leader=" + team_leader + ", team_name=" + team_name
				+ ", team_gender=" + team_gender + ", team_age=" + team_age + ", team_region=" + team_region
				+ ", team_point=" + team_point + ", team_mark_img=" + team_mark_img + ", team_active_lastday="
				+ team_active_lastday + ", team_delete_status=" + team_delete_status + "]";
	}
	
	
	
	
}
