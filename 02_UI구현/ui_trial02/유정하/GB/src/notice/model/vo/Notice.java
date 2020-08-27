package notice.model.vo;

import java.sql.Date;

public class Notice {
	private int noticeNum;
	private String noticeEmail;
	private String noticeTitle;
	private String noticeContent;
	private String noticeImage;
	private Date noticeDate;
	
	public Notice() {}
	
	public Notice(int noticeNum, String noticeEmail, String noticeTitle, Date noticeDate) {
		super();
		this.noticeNum = noticeNum;
		this.noticeEmail = noticeEmail;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
	}
	
	

	public Notice(int noticeNum, String noticeEmail, String noticeTitle, String noticeContent, String noticeImage,
			Date noticeDate) {
		super();
		this.noticeNum = noticeNum;
		this.noticeEmail = noticeEmail;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeImage = noticeImage;
		this.noticeDate = noticeDate;
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getNoticeEmail() {
		return noticeEmail;
	}

	public void setNoticeEmail(String noticeEmail) {
		this.noticeEmail = noticeEmail;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeImage() {
		return noticeImage;
	}

	public void setNoticeImage(String noticeImage) {
		this.noticeImage = noticeImage;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	
	

	@Override
	public String toString() {
		return "Notice [noticeNum=" + noticeNum + ", noticeEmail=" + noticeEmail + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeImage=" + noticeImage + ", noticeDate=" + noticeDate
				+ "]";
	}
	
	
	
	
	
}
