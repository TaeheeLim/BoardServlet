package kr.or.ddit.service;


import kr.or.ddit.vo.MemberVO;

public interface IMemberService {
	public boolean insertImg(MemberVO vo);
	
	public String selectImg(String mail);
	
	MemberVO SelectMember(String mail);
	
	boolean UpdateMember(MemberVO vo);
	
	public String updateIntro(MemberVO vo);

	public String updatePass(MemberVO vo);
	
	public String updateNickname(MemberVO vo);
	
}
