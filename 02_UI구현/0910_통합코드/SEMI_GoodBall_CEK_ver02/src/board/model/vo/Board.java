package board.model.vo;

import java.sql.Date;

public class Board {
	private int boardNum;
	private String boardWriter; //작성자이름
	private String boardWriterEmail; //작성자 이메일
	private String boardTitle; //제목
	private String boardContent; //내용
	private String boardImgPath; //이미지파일 경로
	private Date boardDate; //공지사항 등록날짜
	private String boardDeleteStatus; //게시판 삭제여부
	
	public Board() {}
	
	public Board(int boardNum, String boardWriter, String boardWriterEmail, String boardTitle, String boardContent) {
		super();
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.boardWriterEmail = boardWriterEmail;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public Board(int boardNum, String boardWriter, String boardWriterEmail, String boardTitle, String boardContent,
			String boardImgPath) {
		super();
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.boardWriterEmail = boardWriterEmail;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardImgPath = boardImgPath;
	}

	public Board(int boardNum, String boardWriter, String boardWriterEmail, String boardTitle, String boardContent,
			String boardImgPath, Date boardDate, String boardDeleteStatus) {
		super();
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.boardWriterEmail = boardWriterEmail;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardImgPath = boardImgPath;
		this.boardDate = boardDate;
		this.boardDeleteStatus = boardDeleteStatus;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardWriterEmail() {
		return boardWriterEmail;
	}

	public void setBoardWriterEmail(String boardWriterEmail) {
		this.boardWriterEmail = boardWriterEmail;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardImgPath() {
		return boardImgPath;
	}

	public void setBoardImgPath(String boardImgPath) {
		this.boardImgPath = boardImgPath;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardDeleteStatus() {
		return boardDeleteStatus;
	}

	public void setBoardDeleteStatus(String boardDeleteStatus) {
		this.boardDeleteStatus = boardDeleteStatus;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardWriter=" + boardWriter + ", boardWriterEmail=" + boardWriterEmail
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardImgPath=" + boardImgPath
				+ ", boardDate=" + boardDate + ", boardDeleteStatus=" + boardDeleteStatus + "]";
	}
	
	
	
}
