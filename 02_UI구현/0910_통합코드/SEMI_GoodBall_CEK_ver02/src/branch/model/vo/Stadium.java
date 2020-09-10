package branch.model.vo;

public class Stadium {
   private int stadium_num;
   private String branch_num;
   private String stadium_name;
   private String stadium_match_member;
   private int stadium_reservation_start_time;
   private int stadium_reservation_end_time;
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
   public Stadium() {
      super();
   }
   public Stadium(int stadium_num, String branch_num, String stadium_name, String stadium_match_member,
         int stadium_reservation_start_time, int stadium_reservation_end_time, String branch_manager_email,
         String branch_address, String branch_phone, String branch_img, String branch_website, int branch_point,
         String branch_option_shower, String branch_option_park, String branch_option_uniform,
         String branch_option_shoes, String branch_option_ball, String branch_option_inout) {
      super();
      this.stadium_num = stadium_num;
      this.branch_num = branch_num;
      this.stadium_name = stadium_name;
      this.stadium_match_member = stadium_match_member;
      this.stadium_reservation_start_time = stadium_reservation_start_time;
      this.stadium_reservation_end_time = stadium_reservation_end_time;
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
   }
   
   public Stadium(String stadium_name, String stadium_match_member, int stadium_reservation_start_time,
		int stadium_reservation_end_time) {
	super();
	this.stadium_name = stadium_name;
	this.stadium_match_member = stadium_match_member;
	this.stadium_reservation_start_time = stadium_reservation_start_time;
	this.stadium_reservation_end_time = stadium_reservation_end_time;
}
public int getStadium_num() {
      return stadium_num;
   }
   public void setStadium_num(int stadium_num) {
      this.stadium_num = stadium_num;
   }
   public String getBranch_num() {
      return branch_num;
   }
   public void setBranch_num(String branch_num) {
      this.branch_num = branch_num;
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
   @Override
   public String toString() {
      return "Stadium [stadium_num=" + stadium_num + ", branch_num=" + branch_num + ", stadium_name=" + stadium_name
            + ", stadium_match_member=" + stadium_match_member + ", stadium_reservation_start_time="
            + stadium_reservation_start_time + ", stadium_reservation_end_time=" + stadium_reservation_end_time
            + ", branch_manager_email=" + branch_manager_email + ", branch_address=" + branch_address
            + ", branch_phone=" + branch_phone + ", branch_img=" + branch_img + ", branch_website=" + branch_website
            + ", branch_point=" + branch_point + ", branch_option_shower=" + branch_option_shower
            + ", branch_option_park=" + branch_option_park + ", branch_option_uniform=" + branch_option_uniform
            + ", branch_option_shoes=" + branch_option_shoes + ", branch_option_ball=" + branch_option_ball
            + ", branch_option_inout=" + branch_option_inout + "]";
   }
   

   
   

}