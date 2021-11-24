package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.CommentDAOImpl;
import kr.or.ddit.vo.CommentVO;

public class CommentServiceImpl implements ICommentService {
	private static CommentServiceImpl instance;
	private CommentDAOImpl dao;
	
	private CommentServiceImpl() {
		dao = CommentDAOImpl.getInstance();
	}
	
	public static CommentServiceImpl getInstance() {
		if(instance == null) {
			instance = new CommentServiceImpl();
			return instance;
		}
		return instance;
	}
	@Override
	public int insertComment(CommentVO vo) {
		return dao.insertComment(vo);
	}

	@Override
	public int updateComment(CommentVO vo) {
		return dao.updateComment(vo);
	}

	@Override
	public int deleteComment(int commentIdx) {
		return dao.deleteComment(commentIdx);
	}

	@Override
	public List<CommentVO> selectComment(int commentIdx) {
		return dao.selectComment(commentIdx);
	}

}
