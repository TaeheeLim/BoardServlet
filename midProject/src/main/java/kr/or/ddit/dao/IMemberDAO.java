package kr.or.ddit.dao;

import java.util.HashMap;
import java.util.List;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.UploadFileVO;

public interface IMemberDAO {

	boolean CheckMember(String mail);

	boolean PasswordCheck(String password);

	List<MemberVO> SelectListMember();

	List<MemberVO> SelectListMember(String condition, String mail);

	MemberVO SelectMember(String mail);

	int MemberCount();

	List<MemberVO> SelectListMember(String mail);

	boolean InsertMember(MemberVO vo);

	boolean UpdateMember(MemberVO vo);
	
	boolean InsertImg(MemberVO vo);
	
	public String selectImage(String mail);
	
	public int updateIntro(MemberVO vo);

	public int updatePass(MemberVO vo);
	
	public int updateNickname(MemberVO vo);

}
