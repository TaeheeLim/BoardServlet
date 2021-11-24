package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.service.MyBoardServiceImpl;
import kr.or.ddit.service.SeedServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SeedVO;

@WebServlet("/myPageServlet.do")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		SeedServiceImpl seedService = SeedServiceImpl.getInstance();
		
		MemberVO vo = service.SelectMember("lim3617@naver.com");
		
		int selectSumSeed = seedService.selectSumSeed("lim3617@naver.com");
		
		MyBoardServiceImpl myBoardService = MyBoardServiceImpl.getInstance();
		
		int myBoard = myBoardService.getMyBoard("lim3617@naver.com");
		int myComment = myBoardService.getMyComment("lim3617@naver.com");
		
		request.setAttribute("vo", vo);
		request.setAttribute("sum", selectSumSeed);
		request.setAttribute("myBoard", myBoard);
		request.setAttribute("myComment", myComment);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/myPage.jsp");

		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
