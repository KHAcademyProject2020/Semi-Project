package team.model.vo;

public class TeamMember {
	String supporter_email;
	String support_team;
	String position;
	String application_status;
	String delete_status;
	public TeamMember() {
		super();
	}
	public TeamMember(String supporter_email, String support_team, String position, String application_status,
			String delete_status) {
		super();
		this.supporter_email = supporter_email;
		this.support_team = support_team;
		this.position = position;
		this.application_status = application_status;
		this.delete_status = delete_status;
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
	@Override
	public String toString() {
		return "TeamMember [supporter_email=" + supporter_email + ", support_team=" + support_team + ", position="
				+ position + ", application_status=" + application_status + ", delete_status=" + delete_status + "]";
	}
	
	
	
	

}
