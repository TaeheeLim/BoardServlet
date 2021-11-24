package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.CommentVO;

public class CommentDAOImpl implements ICommentDAO {
	private static CommentDAOImpl instance;
	private SqlMapClient smc;
	
	private CommentDAOImpl() {
		smc = SqlMapClientFactory.getInsatnce();
	}
	
	public static CommentDAOImpl getInstance() {
		if(instance == null) {
			instance = new CommentDAOImpl();
			return instance;
		}
		return instance;
	}

	@Override
	public int insertComment(CommentVO vo) {
		int cnt = 0;
		
		try {
			Object object = smc.insert("comment.insertComment", vo);
			
			if(object == null ) {
				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateComment(CommentVO vo) {
		int cnt = 0;
		
		try {
			cnt  = smc.update("comment.updateComment",vo);
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0; 
		}
		return cnt;
	}

	@Override
	public int deleteComment(int commentIdx) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("comment.deleteComment", commentIdx);
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		}
		return cnt;
	}
	
	public List<CommentVO> selectComment(int commentIdx){
		List<CommentVO> list;
		
		try {
			list = smc.queryForList("comment.selectComment", commentIdx);
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}
	
	
	
}
