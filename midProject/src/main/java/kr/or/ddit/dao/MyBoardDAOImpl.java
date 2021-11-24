package kr.or.ddit.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.util.SqlSessionFactoryUtil;

public class MyBoardDAOImpl implements IMyBoardDAO {
	private static MyBoardDAOImpl instance;
	
	public static MyBoardDAOImpl getInstance() {
		if(instance == null) instance = new MyBoardDAOImpl();
		return instance;
	}
	
	private SqlSessionFactory factory;
	private SqlSession sqlSession;
	
	public MyBoardDAOImpl() {
		factory = SqlSessionFactoryUtil.getInstance();
	}
	
	
	
	@Override
	public int getMyBoard(String mail) {
		int cnt = 0;
		try {
			sqlSession = factory.openSession();
			cnt = sqlSession.selectOne("myBoard.selectMyBoard", mail);
			sqlSession.commit();
			sqlSession.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int getMyComment(String mail) {
		int cnt = 0;
		
		try {
			sqlSession = factory.openSession();
			cnt = sqlSession.selectOne("myBoard.selectMyComment", mail);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
