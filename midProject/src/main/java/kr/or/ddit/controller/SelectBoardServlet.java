package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.CommentServiceImpl;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.CommentVO;

@WebServlet("/selectBoard.do")
public class SelectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String idx = request.getParameter("boardIdx");
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		
		CommentServiceImpl commentService = CommentServiceImpl.getInstance();
		
		BoardVO vo = new BoardVO();
		vo.setBoard_index(idx);
		BoardVO board = service.SeeBoard(idx);
		service.UpdateCount(idx);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/boardShow.jsp");
		
		CommentVO cvo = new CommentVO();
		cvo.setBoard_idx(idx);
		List<CommentVO> list = commentService.selectComment(newiDX);
		
		request.setAttribute("board", board);
		request.setAttribute("comment", list);
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
