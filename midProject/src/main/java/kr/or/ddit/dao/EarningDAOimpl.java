package kr.or.ddit.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.util.SqlSessionFactoryUtil;
import kr.or.ddit.vo.EarningVO;
import kr.or.ddit.vo.SeedVO;

public class EarningDAOimpl implements IEarningDAO {
	private static EarningDAOimpl instance;
	public static EarningDAOimpl getInstance() {
		if(instance == null) instance = new EarningDAOimpl();
		return instance;
	}
	
	private SqlSessionFactory factory;
	private SqlSession sqlSession;
	
	public EarningDAOimpl() {
		factory = SqlSessionFactoryUtil.getInstance();
	}
	
	@Override
	public int insertEarning(EarningVO evo) {
		int cnt = 0;
		try {
			sqlSession = factory.openSession(); 
			int success = sqlSession.insert("SEED.insertEarning", evo);
			sqlSession.commit();
			sqlSession.close();
			
			if(success > 0) {
				cnt = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
