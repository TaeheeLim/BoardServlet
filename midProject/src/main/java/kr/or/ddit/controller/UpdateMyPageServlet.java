package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/updateMyPage.do")
public class UpdateMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		MemberVO vo = new MemberVO();
		vo.setMember_mail("lim3617@naver.com");
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
		String value = "";
		if(cmd.equals("intro")) {
			vo.setIntroduction(request.getParameter("value"));
			value = service.updateIntro(vo);
		} else if(cmd.equals("pass")) {
			vo.setPassword(request.getParameter("value"));
			value = service.updatePass(vo);
		} else if(cmd.equals("nickname")) {
			vo.setNickname(request.getParameter("value"));
			value = service.updateNickname(vo);
		}
		
		request.setAttribute("json", value);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/pro/Update-pro.jsp");
		
		rd.forward(request, response);
		
		/*String pass = request.getParameter("pass");
		String nickName = request.getParameter("nickname");
		
		
		
		vo.setIntroduction(intro);
		vo.setPassword(pass);
		vo.setNickname(nickName);
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		boolean updateMember = service.UpdateMember(vo);
		JsonObject json = new JsonObject();
		
		if(updateMember) {
			json.addProperty("result", "성공");
			json.addProperty("introduction", intro);
			json.addProperty("nickName", nickName);
		} else {
			json.addProperty("result", "실패");
		}
		out.print(gson.toJson(json));*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
