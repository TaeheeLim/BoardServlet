package kr.or.ddit.service;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.or.ddit.dao.MemberDAOImp;
import kr.or.ddit.util.CryptoUtil;
import kr.or.ddit.util.SHA256Util;
import kr.or.ddit.util.Utils;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.UploadFileVO;

public class MemberServiceImpl implements IMemberService {
	private static MemberServiceImpl instance;
	private MemberDAOImp dao;
	
	private MemberServiceImpl() {
		dao = MemberDAOImp.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(instance == null) {
			instance = new MemberServiceImpl();
			return instance;
		}
		return instance;
	}
	
	@Override
	public boolean insertImg(MemberVO vo) {
		
		boolean insertImg = dao.InsertImg(vo);
		
		return insertImg;
	}

	@Override
	public String selectImg(String mail) {
		
		return dao.selectImage(mail);
	}

	@Override
	public MemberVO SelectMember(String mail) {
		return dao.SelectMember(mail);
	}

	@Override
	public boolean UpdateMember(MemberVO vo) {
		SHA256Util util = SHA256Util.getInstance();
		
		vo.setPassword(util.encrypt(vo.getPassword()));
		
		boolean updateMember = dao.UpdateMember(vo);
		return updateMember;
	}

	@Override
	public String updateIntro(MemberVO vo) {
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		
		if(dao.updateIntro(vo) > 0) {
			json.addProperty("sw", "ok");
		} else {
			json.addProperty("sw", "no");
		}
		
		return gson.toJson(json);
	}

	@Override
	public String updatePass(MemberVO vo) {
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		SHA256Util util = SHA256Util.getInstance();
		
		try {
			vo.setPassword(util.encrypt(vo.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(dao.updatePass(vo)==1) {
			json.addProperty("sw", "ok");	
		}else{
			json.addProperty("sw", "no");						
		}
		return gson.toJson(json);
	}

	@Override
	public String updateNickname(MemberVO vo) {
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		
		if(dao.updateNickname(vo) > 0 ) {
			json.addProperty("sw", "ok");;
		} else {
			json.addProperty("sw", "no");
		}
		return gson.toJson(json);
	}

}
