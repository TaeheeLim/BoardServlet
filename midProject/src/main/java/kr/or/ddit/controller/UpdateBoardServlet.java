package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.vo.BoardVO;

@WebServlet("/updateBoard.do")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("editordata");
		String idx = request.getParameter("boardIdx");
		
		BoardVO vo = new BoardVO();
		vo.setBoard_index(idx);
		vo.setBoard_title(title);
		vo.setBoard_content(content);
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		service.UpdateBoard(vo);
		
		response.sendRedirect(request.getContextPath() + "/boardList.do");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
