package kr.or.ddit.vo;

public class CommentVO {
	private int comment_idx;
	private String comment_writer;
	private String comment_content;
	private String comment_date;
	private int comment_number;
	private int board_idx;
	
	public CommentVO() {}

	public CommentVO(int comment_idx, String comment_writer, String comment_content, String comment_date,
			int comment_number, int board_idx) {
		super();
		this.comment_idx = comment_idx;
		this.comment_writer = comment_writer;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
		this.comment_number = comment_number;
		this.board_idx = board_idx;
	}

	public int getComment_idx() {
		return comment_idx;
	}

	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}

	public String getComment_writer() {
		return comment_writer;
	}

	public void setComment_writer(String comment_writer) {
		this.comment_writer = comment_writer;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_date() {
		return comment_date;
	}

	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}

	public int getComment_number() {
		return comment_number;
	}

	public void setComment_number(int comment_number) {
		this.comment_number = comment_number;
	}

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	
	
}
