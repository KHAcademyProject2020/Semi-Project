package reservation.model.vo;

import java.sql.Date;

public class ReservationInfo {
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
	private int stadium_num; 
	private String stadium_branch_num; 
	private String stadium_name; 
	private String stadium_match_member; 
	private int stadium_reservation_start_time; 
	private int stadium_reservation_end_time; 
	private String stadium_delete_status;
	private String branch_manager_email;
	public ReservationInfo() {
		super();
	}
	
	public ReservationInfo(String reservation_code, String reservation_email, String reservation_branch_num,
			int reservation_stadium_num, int reservation_price, int reservation_usage_start_time,
			int reservation_usage_time, int reservation_usage_end_time, Date reservation_usage_start_date) {
		super();
		this.reservation_code = reservation_code;
		this.reservation_email = reservation_email;
		this.reservation_branch_num = reservation_branch_num;
		this.reservation_stadium_num = reservation_stadium_num;
		this.reservation_price = reservation_price;
		this.reservation_usage_start_time = reservation_usage_start_time;
		this.reservation_usage_time = reservation_usage_time;
		this.reservation_usage_end_time = reservation_usage_end_time;
		this.reservation_usage_start_date = reservation_usage_start_date;
	}

	public ReservationInfo(String reservation_branch_num, int reservation_stadium_num) {
		super();
		this.reservation_branch_num = reservation_branch_num;
		this.reservation_stadium_num = reservation_stadium_num;
	}

	public ReservationInfo(String reservation_code, String reservation_email, int reservation_stadium_num,
			int reservation_num, int reservation_price, int reservation_usage_start_time, int reservation_usage_time,
			int reservation_usage_end_time, Date reservation_usage_start_date, String reservation_status,
			int stadium_num, String stadium_branch_num, String stadium_name, String stadium_match_member,
			int stadium_reservation_start_time, int stadium_reservation_end_time, String stadium_delete_status) {
		super();
		this.reservation_code = reservation_code;
		this.reservation_email = reservation_email;
		this.reservation_stadium_num = reservation_stadium_num;
		this.reservation_num = reservation_num;
		this.reservation_price = reservation_price;
		this.reservation_usage_start_time = reservation_usage_start_time;
		this.reservation_usage_time = reservation_usage_time;
		this.reservation_usage_end_time = reservation_usage_end_time;
		this.reservation_usage_start_date = reservation_usage_start_date;
		this.reservation_status = reservation_status;
		this.stadium_num = stadium_num;
		this.stadium_branch_num = stadium_branch_num;
		this.stadium_name = stadium_name;
		this.stadium_match_member = stadium_match_member;
		this.stadium_reservation_start_time = stadium_reservation_start_time;
		this.stadium_reservation_end_time = stadium_reservation_end_time;
		this.stadium_delete_status = stadium_delete_status;
	}
	
	
	
	
	public ReservationInfo(String reservation_code, String reservation_email, String reservation_branch_num,
			int reservation_stadium_num, int reservation_num, int reservation_price, int reservation_usage_start_time,
			int reservation_usage_time, int reservation_usage_end_time, Date reservation_usage_start_date,
			String reservation_status, int stadium_num, String stadium_branch_num, String stadium_name,
			String stadium_match_member, int stadium_reservation_start_time, int stadium_reservation_end_time,
			String stadium_delete_status, String branch_manager_email) {
		super();
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
		this.stadium_num = stadium_num;
		this.stadium_branch_num = stadium_branch_num;
		this.stadium_name = stadium_name;
		this.stadium_match_member = stadium_match_member;
		this.stadium_reservation_start_time = stadium_reservation_start_time;
		this.stadium_reservation_end_time = stadium_reservation_end_time;
		this.stadium_delete_status = stadium_delete_status;
		this.branch_manager_email = branch_manager_email;
	}

	

	public String getBranch_manager_email() {
		return branch_manager_email;
	}

	public void setBranch_manager_email(String branch_manager_email) {
		this.branch_manager_email = branch_manager_email;
	}

	public String getReservation_branch_num() {
		return reservation_branch_num;
	}

	public void setReservation_branch_num(String reservation_branch_num) {
		this.reservation_branch_num = reservation_branch_num;
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

	@Override
	public String toString() {
		return "ReservationInfo [reservation_code=" + reservation_code + ", reservation_email=" + reservation_email
				+ ", reservation_branch_num=" + reservation_branch_num + ", reservation_stadium_num="
				+ reservation_stadium_num + ", reservation_num=" + reservation_num + ", reservation_price="
				+ reservation_price + ", reservation_usage_start_time=" + reservation_usage_start_time
				+ ", reservation_usage_time=" + reservation_usage_time + ", reservation_usage_end_time="
				+ reservation_usage_end_time + ", reservation_usage_start_date=" + reservation_usage_start_date
				+ ", reservation_status=" + reservation_status + ", stadium_num=" + stadium_num
				+ ", stadium_branch_num=" + stadium_branch_num + ", stadium_name=" + stadium_name
				+ ", stadium_match_member=" + stadium_match_member + ", stadium_reservation_start_time="
				+ stadium_reservation_start_time + ", stadium_reservation_end_time=" + stadium_reservation_end_time
				+ ", stadium_delete_status=" + stadium_delete_status + ", branch_manager_email=" + branch_manager_email
				+ "]";
	}

}
