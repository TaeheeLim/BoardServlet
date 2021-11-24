package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.EarningDAOimpl;
import kr.or.ddit.dao.MemberDAOImp;
import kr.or.ddit.dao.SeedDAOImpl;
import kr.or.ddit.vo.EarningVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SeedVO;

public class SeedServiceImpl implements ISeedService{
	private static SeedServiceImpl instance;
	private SeedDAOImpl seedDao;
	private MemberDAOImp memberDao;
	private EarningDAOimpl earningDao;
	
	private SeedServiceImpl() {
		seedDao = SeedDAOImpl.getInstnace();
		memberDao = MemberDAOImp.getInstance();
		earningDao = EarningDAOimpl.getInstance();
	}
	
	public static SeedServiceImpl getInstance() {
		if(instance == null) {
			instance = new SeedServiceImpl();
			return instance;
		}
		return instance;
	}
	
	@Override
	public String insertSeed(String mail, SeedVO svo) {
//		if(svo.getSeed()==0) {
//			ret
//		}
		MemberVO memvo = memberDao.SelectMember(mail);
		EarningVO evo = new EarningVO();
		
		evo.setCharge(svo.getSeed() * 100);
		evo.setMember_mail(svo.getMember_mail());
		
		String name = memvo.getFirstname() + memvo.getLastname();
		seedDao.insertSeed(svo);
		earningDao.insertEarning(evo);
		 
		return name;
	}

	@Override
	public int selectSumSeed(String mail) {
		
		return seedDao.selectSumSeed(mail);
	}

	@Override
	public List<SeedVO> seedList(String mail) {
		return seedDao.seedList(mail);
	}

}
