package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.SeedVO;

public interface ISeedDAO {
	public boolean insertSeed(SeedVO vo);
	
	public int selectSumSeed(String mail);
	
	public List<SeedVO> seedList(String mail);
}
