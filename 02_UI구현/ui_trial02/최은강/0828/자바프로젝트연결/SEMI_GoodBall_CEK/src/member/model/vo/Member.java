package member.model.vo;

import java.sql.Date;

public class Member {

	private String email;
	private String pwd;
	private String name;
	private Date birthday;
	private String phone;
	private String address;
	
	private String memberKakao;
	private String memberType;
	private String status;

	Member(){}

	public Member(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}

	public Member(String email, String pwd, String name, Date birthday, String phone, String address,
			String memberKakao, String memberType) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.memberKakao = memberKakao;
		this.memberType = memberType;
	}

	public Member(String email, String pwd, String name, Date birthday, String phone, String address,
			String memberKakao, String memberType, String status) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.memberKakao = memberKakao;
		this.memberType = memberType;
		this.status = status;
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

	public String getMemberKakao() {
		return memberKakao;
	}

	public void setMemberKakao(String memberKakao) {
		this.memberKakao = memberKakao;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", pwd=" + pwd + ", name=" + name + ", birthday=" + birthday + ", phone="
				+ phone + ", address=" + address + ", memberKakao=" + memberKakao + ", memberType=" + memberType
				+ ", status=" + status + "]";
	}

}
