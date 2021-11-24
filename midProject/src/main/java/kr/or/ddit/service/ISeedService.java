package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.SeedVO;

public interface ISeedService {
	public String insertSeed(String mail, SeedVO vo);
	
	public int selectSumSeed(String mail);
	
	public List<SeedVO> seedList(String mail);
}
