package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.util.SqlSessionFactoryUtil;
import kr.or.ddit.vo.SeedVO;

public class SeedDAOImpl implements ISeedDAO {
	private static SeedDAOImpl instance;
	public static SeedDAOImpl getInstnace() {
		if(instance == null) instance = new SeedDAOImpl();
		return instance;
	}
	
	private SqlSessionFactory factory;
	private SqlSession sqlSession;
	
	public SeedDAOImpl() {
		factory = SqlSessionFactoryUtil.getInstance();
	}
	
	@Override
	public boolean insertSeed(SeedVO vo) {

		try {
			sqlSession = factory.openSession();
			int success = sqlSession.insert("SEED.insertSeed", vo);
			sqlSession.commit();
			sqlSession.close();
			if (success != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public int selectSumSeed(String mail) {
		int cnt = 0;
		
		try {
			sqlSession = factory.openSession();
			cnt = sqlSession.selectOne("SEED.selectSumSeed", mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<SeedVO> seedList(String mail) {
		List<SeedVO> list = null;
		try {
			sqlSession = factory.openSession();
			System.out.println("aaa");
			list = sqlSession.selectList("SEED.chargedSeedList", mail);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
