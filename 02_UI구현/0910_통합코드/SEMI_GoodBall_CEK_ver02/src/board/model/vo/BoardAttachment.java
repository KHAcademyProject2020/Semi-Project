package board.model.vo;

import java.sql.Date;

public class BoardAttachment {
	private int fileId; //파일번호
	private int boardId;//게시판 번호
	private String originName;
	private String changeName;
	private String filePath;
	private Date updateDate;
	private String status;
	
	public BoardAttachment() {}
	
	public BoardAttachment(int boardId, String changeName) {
		this();
		this.boardId= boardId;
		this.changeName= changeName;
	}
	
	public BoardAttachment(int fileId, int boardId, String originName, 
			String changeName, String filePath,
			Date updateDate, String status) {
		super();
		this.fileId = fileId;
		this.boardId = boardId;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.updateDate = updateDate;
		this.status = status;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BoardAttachment [fileId=" + fileId + ", boardId=" + boardId + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", updateDate=" + updateDate + ", status="
				+ status + "]";
	}
}
