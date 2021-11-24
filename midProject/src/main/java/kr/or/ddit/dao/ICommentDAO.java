package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.CommentVO;

public interface ICommentDAO {
	//댓글 작성 메소드
	public int insertComment(CommentVO vo);
	
	//댓글 수정 메소드
	public int updateComment(CommentVO vo);
	
	//댓글 삭제 메소드
	public int deleteComment(int commentIdx);
	
	public List<CommentVO> selectComment(int commentIdx);
	
	
	
	
}
