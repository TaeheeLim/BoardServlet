package kr.or.ddit.service;

import java.util.HashMap;
import java.util.List;

import kr.or.ddit.dao.BoardDAOImpl;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	private static BoardServiceImpl instance;
	
	private BoardDAOImpl dao;
	
	private BoardServiceImpl() {
		dao = BoardDAOImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(instance == null) {
			instance = new BoardServiceImpl();
			return instance;
		}
		return instance;
	}

	@Override
	public int CountTotalBoard() {
		return dao.CountTotalBoard();
	}

	@Override
	public boolean InsertBoard(BoardVO vo) {
		return dao.InsertBoard(vo);
	}

	@Override
	public boolean DeleteBoard(String idx) {
		return dao.DeleteBoard(idx);
	}

	@Override
	public boolean UpdateBoard(BoardVO vo) {
		return dao.UpdateBoard(vo);
	}

	@Override
	public boolean UpdateCount(String idx) {
		return dao.UpdateCount(idx);
	}

	@Override
	public List<BoardVO> SelectListBoard() {
		return dao.SelectListBoard();
	}

	@Override
	public List<BoardVO> SelectListBoard(HashMap<String, String> map) {
		return dao.SelectListBoard(map);
	}

	@Override
	public BoardVO SeeBoard(String idx) {
		return dao.SeeBoard(idx);
	}



}
