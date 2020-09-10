package team.model.vo;

import java.sql.Date;

public class TeamMemberInfo {
	private String supporter_email;
	private String support_team;
	private String position;
	private String application_status;
	private String delete_status;
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
	private int age;
	
	public TeamMemberInfo() {
		super();
	}
	public TeamMemberInfo(String supporter_email, String support_team, String position, String application_status,
			String delete_status, String email, String pwd, String name, Date birthday, String gender, String phone,
			String address, String member_kakao, String member_type, String member_delete_status) {
		super();
		this.supporter_email = supporter_email;
		this.support_team = support_team;
		this.position = position;
		this.application_status = application_status;
		this.delete_status = delete_status;
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
	public String getSupporter_email() {
		return supporter_email;
	}
	public void setSupporter_email(String supporter_email) {
		this.supporter_email = supporter_email;
	}
	public String getSupport_team() {
		return support_team;
	}
	public void setSupport_team(String support_team) {
		this.support_team = support_team;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getApplication_status() {
		return application_status;
	}
	public void setApplication_status(String application_status) {
		this.application_status = application_status;
	}
	public String getDelete_status() {
		return delete_status;
	}
	public void setDelete_status(String delete_status) {
		this.delete_status = delete_status;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MemberTeamInfo [supporter_email=" + supporter_email + ", support_team=" + support_team + ", position="
				+ position + ", application_status=" + application_status + ", delete_status=" + delete_status
				+ ", email=" + email + ", pwd=" + pwd + ", name=" + name + ", birthday=" + birthday + ", gender="
				+ gender + ", phone=" + phone + ", address=" + address + ", member_kakao=" + member_kakao
				+ ", member_type=" + member_type + ", member_delete_status=" + member_delete_status + "]";
	}
	
	
	
	

}
