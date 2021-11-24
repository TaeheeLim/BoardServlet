package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.vo.BoardVO;

@WebServlet("/insertBoard.do")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("title");
		String writer  = request.getParameter("writer");
		String content = request.getParameter("editordata");
		
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		
		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		
		writer = writer.replaceAll("<", "&lt;");
		writer = writer.replaceAll(">", "&gt;");
		
		BoardVO vo = new BoardVO();

		vo.setBoard_title(title);
		vo.setBoard_content(content);
		vo.setMember_mail(writer);
		
		
		service.InsertBoard(vo);
		
		response.sendRedirect(request.getContextPath() + "/pagingList.do");
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
