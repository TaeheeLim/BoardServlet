package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.util.SqlSessionFactoryUtil;
import kr.or.ddit.vo.BoardVO;

public class BoardDAOImpl implements IBoardDAO {
	   private static BoardDAOImpl instance;
	   public static BoardDAOImpl getInstance() {
	      if(instance == null) instance = new BoardDAOImpl();
	      return instance;
	   }
	   
	   private SqlSessionFactory factory;
	   private SqlSession sqlSession;

	   public BoardDAOImpl() {
	      factory = SqlSessionFactoryUtil.getInstance();
	   }
	   
	   @Override
	   public int CountTotalBoard() {
	      int cnt = 0;
	      try {
	         sqlSession = factory.openSession();
	         int success = sqlSession.selectOne("BOARD.countTotalBoard");
	         sqlSession.close();
	         if(success == 1) cnt = 1;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return cnt;
	   }

	   @Override
	   public boolean InsertBoard(BoardVO vo) {
	      try {
	         sqlSession = factory.openSession();
	         int success = sqlSession.insert("BOARD.insertBoard", vo);
	         sqlSession.commit();
	         sqlSession.close();
	         if(success == 1) return true;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   }

	   @Override
	   public boolean DeleteBoard(String idx) {
	      try {
	         sqlSession = factory.openSession();
	         int success = sqlSession.delete("BOARD.deleteBoard", idx);
	         sqlSession.commit();
	         sqlSession.close();
	         if(success == 1) return true;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   }

	   @Override
	   public boolean UpdateBoard(BoardVO vo) {
	      try {
	         sqlSession = factory.openSession();
	         int success = sqlSession.update("BOARD.updateBoard", vo);
	         sqlSession.commit();
	         sqlSession.close();
	         if(success == 0) return true;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   }

	   @Override
	   public List<BoardVO> SelectListBoard() {
	      List<BoardVO> list = null;
	      try {
	         sqlSession = factory.openSession();
	         list = sqlSession.selectList("BOARD.selectListBoard");
	         sqlSession.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return list;
	   }

	   @Override
	   public List<BoardVO> SelectListBoard(HashMap<String, String> map) {
	      return null;
	   }

	   @Override
	   public BoardVO SeeBoard(String idx) {
	      BoardVO vo = null;
	      try {
	         sqlSession = factory.openSession();
	         vo = sqlSession.selectOne("BOARD.seeBoard");
	         sqlSession.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return vo;
	   }

	   @Override
	   public boolean UpdateCount(String idx) {
	      try {
	         sqlSession = factory.openSession();
	         int success = sqlSession.update("BOARD.updateCount", idx);
	         sqlSession.commit();
	         sqlSession.close();
	         if(success == 1) return true;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return false;
	   }


//	@Override
//	public List<BoardVO> searchBoard(String changeContent) {
//		List<BoardVO> list = new ArrayList<>();
//		
//		try {
//			
//			list = (List<BoardVO>) smc.queryForList("board.searchBoard", changeContent);
//			
//		} catch (SQLException e) {
//			list = null;
//			e.printStackTrace();
//		}
//		return list;
//	}
	
}
