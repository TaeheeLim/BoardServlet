package kr.or.ddit.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.util.SqlSessionFactoryUtil;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.UploadFileVO;

public class MemberDAOImp implements IMemberDAO {
	private static MemberDAOImp instance;
	public static MemberDAOImp getInstance() {
		if(instance == null) instance = new MemberDAOImp();
		return instance;
	}
	
	private SqlSessionFactory factory;
	private SqlSession sqlSession;
	
	public MemberDAOImp() {
		factory = SqlSessionFactoryUtil.getInstance();
	}
	
	@Override
	public boolean CheckMember(String mail) {
		try {
			sqlSession = factory.openSession();
			int check = sqlSession.selectOne("MEMBER.checkMember",mail);
			sqlSession.commit();
			sqlSession.close();
			if(check==0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean InsertMember(MemberVO vo) {
		try {
			sqlSession = factory.openSession();
			int success = sqlSession.insert("MEMBER.insertMember", vo);
			sqlSession.commit();
			sqlSession.close();
			if(success!=0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean PasswordCheck(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberVO> SelectListMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> SelectListMember(String mail) {
		
	
		return null;
	}

	@Override
	public List<MemberVO> SelectListMember(String condition, String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int MemberCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO SelectMember(String mail) {
		MemberVO vo = null;
		try {
			sqlSession = factory.openSession();
			vo = sqlSession.selectOne("MEMBER.selectMember", mail);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean UpdateMember(MemberVO vo) {
		
		return false;
	}

	@Override
	public boolean InsertImg(MemberVO vo) {
		try {
			sqlSession = factory.openSession();			
			int img = sqlSession.update("myPage.updateImage",vo);
			sqlSession.commit();
			sqlSession.close();
			
			if (img > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String selectImage(String mail) {
		try {
			sqlSession = factory.openSession();
			String selectOne = sqlSession.selectOne("myPage.selectImage", mail);
			sqlSession.commit();
			sqlSession.close();
			return selectOne; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int updateIntro(MemberVO vo) {
		int cnt = 0;
		try {
			sqlSession = factory.openSession();
			cnt = sqlSession.update("myPage.updateIntro", vo);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updatePass(MemberVO vo) {
		int cnt = 0;
		try {
			sqlSession = factory.openSession();
			cnt = sqlSession.update("myPage.updatePass",vo);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateNickname(MemberVO vo) {
		int cnt = 0;
		try {
			sqlSession = factory.openSession();
			cnt = sqlSession.update("myPage.updateNick",vo);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
