package reservation.model.vo;

import java.sql.Date;

public class Review {
	
	private int review_num;
	private String review_email;
	private String review_branch_num;
	private String review_content; 
	private int review_point; 
	private String review_date;
	private String review_delete_status;
	private String email;
	private String pwd;
	private String name;
	private Date birthday;
	private String gender;
	private String phone;
	private String address;
	private String member_kakao;
	private String member_type;
	private String member_delete_status;
	public Review() {
		super();
	}
	public Review(int review_point) {
		super();
		this.review_point = review_point;
	}
	public Review(int review_num, String review_email, String review_branch_num, String review_content,
			int review_point, String review_date, String review_delete_status, String email, String pwd, String name,
			Date birthday, String gender, String phone, String address, String member_kakao, String member_type,
			String member_delete_status) {
		super();
		this.review_num = review_num;
		this.review_email = review_email;
		this.review_branch_num = review_branch_num;
		this.review_content = review_content;
		this.review_point = review_point;
		this.review_date = review_date;
		this.review_delete_status = review_delete_status;
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.member_kakao = member_kakao;
		this.member_type = member_type;
		this.member_delete_status = member_delete_status;
	}
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public String getReview_email() {
		return review_email;
	}
	public void setReview_email(String review_email) {
		this.review_email = review_email;
	}
	public String getReview_branch_num() {
		return review_branch_num;
	}
	public void setReview_branch_num(String review_branch_num) {
		this.review_branch_num = review_branch_num;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_point() {
		return review_point;
	}
	public void setReview_point(int review_point) {
		this.review_point = review_point;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	public String getReview_delete_status() {
		return review_delete_status;
	}
	public void setReview_delete_status(String review_delete_status) {
		this.review_delete_status = review_delete_status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMember_kakao() {
		return member_kakao;
	}
	public void setMember_kakao(String member_kakao) {
		this.member_kakao = member_kakao;
	}
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
	public String getMember_delete_status() {
		return member_delete_status;
	}
	public void setMember_delete_status(String member_delete_status) {
		this.member_delete_status = member_delete_status;
	}
	@Override
	public String toString() {
		return "Review [review_num=" + review_num + ", review_email=" + review_email + ", review_branch_num="
				+ review_branch_num + ", review_content=" + review_content + ", review_point=" + review_point
				+ ", review_date=" + review_date + ", review_delete_status=" + review_delete_status + ", email=" + email
				+ ", pwd=" + pwd + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", phone="
				+ phone + ", address=" + address + ", member_kakao=" + member_kakao + ", member_type=" + member_type
				+ ", member_delete_status=" + member_delete_status + "]";
	}
	
	
	
	
	
	
	
}
