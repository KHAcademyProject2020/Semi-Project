package member.model.vo;

import java.sql.Date;

public class Member {
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
	
	public Member() {
		
	}
	
	public Member(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}

	public Member(String email, String pwd, String name, Date birthday, String gender, String phone, String address,
			String member_kakao, String member_type, String member_delete_status) {
		super();
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
		return "Member [email=" + email + ", pwd=" + pwd + ", name=" + name + ", birthday=" + birthday + ", gender="
				+ gender + ", phone=" + phone + ", address=" + address + ", member_kakao=" + member_kakao
				+ ", member_type=" + member_type + ", member_delete_status=" + member_delete_status + "]";
	}

	
	
	
	
	
	
	
	

}
