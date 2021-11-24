package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.service.SeedServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SeedVO;

@WebServlet("/kakaoPay.do")
public class kakaoPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeedServiceImpl service;
	private MemberServiceImpl memService;
	public kakaoPayServlet(){
		service = SeedServiceImpl.getInstance();
		memService = MemberServiceImpl.getInstance();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("mail","lim3617@naver.com");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String mail = (String) session.getAttribute("mail");
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("ok")) {
			String amount = request.getParameter("amount");
			int newAmount = Integer.parseInt(amount);
			SeedVO svo = new SeedVO();
			svo.setMember_mail(mail);
			svo.setSeed(newAmount / 100);
			svo.setSeed_state("B");
			service.insertSeed(mail, svo);
		} else if(cmd.equals("payment")){
			int price = Integer.parseInt(request.getParameter("cp_item"));
			SeedVO svo = new SeedVO();
			svo.setMember_mail(mail);
			svo.setSeed_state("B");
			MemberVO vo = memService.SelectMember(mail);
			
			request.setAttribute("name", vo.getFirstname() + vo.getLastname());
			request.setAttribute("email", mail);
			request.setAttribute("totalPrice", price);
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/kakaoPay.jsp");
			
			rd.forward(request, response);
			return;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
