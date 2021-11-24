package kr.or.ddit.service;

import kr.or.ddit.dao.MyBoardDAOImpl;

public class MyBoardServiceImpl implements IMyBoardService {
	 private static MyBoardServiceImpl instance;
	 private MyBoardDAOImpl dao;
	 
	 private MyBoardServiceImpl() {
		 dao = MyBoardDAOImpl.getInstance();
	 }
	 
	 public static MyBoardServiceImpl getInstance() {
		 if(instance == null) {
			 instance = new MyBoardServiceImpl();
			 return instance;
		 }
		 return instance;
	 }
	
	@Override
	public int getMyBoard(String mail) {
		return dao.getMyBoard(mail);
	}

	@Override
	public int getMyComment(String mail) {
		return dao.getMyComment(mail);
	}

}
