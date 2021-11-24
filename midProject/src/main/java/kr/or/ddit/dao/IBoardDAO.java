package kr.or.ddit.dao;

import java.util.HashMap;
import java.util.List;

import kr.or.ddit.vo.BoardVO;



public interface IBoardDAO {
	   public int CountTotalBoard();
	   
	   public boolean InsertBoard(BoardVO vo);
	   
	   public boolean DeleteBoard(String idx);
	   
	   public boolean UpdateBoard(BoardVO vo);
	   
	   public boolean UpdateCount(String idx);
	   /**
	    * 전체 리스트 출력
	    * @return
	    */
	   public List<BoardVO> SelectListBoard();
	   
	   /**
	    * 검색
	    * @param condition 검색 조건
	    * @param value 검색 값
	    * @return
	    */
	   public List<BoardVO> SelectListBoard(HashMap<String, String> map);
	   
	   public BoardVO SeeBoard(String idx);

		//검색
//		public List<BoardVO> searchBoard(String changeContent);
}
