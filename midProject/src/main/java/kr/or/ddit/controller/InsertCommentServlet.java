package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kr.or.ddit.service.CommentServiceImpl;
import kr.or.ddit.vo.CommentVO;

@WebServlet("/insertComment.do")
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommentServiceImpl service;
	Gson gson;
	
	public InsertCommentServlet(){
		service = CommentServiceImpl.getInstance();
		gson = new Gson();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String commentWriter = request.getParameter("writer");
		String commentContent = request.getParameter("content");
		String boardIdx = request.getParameter("boardIdx");
		int newIdx = Integer.parseInt(boardIdx);
		CommentVO vo = new CommentVO();
		vo.setComment_writer(commentWriter);
		vo.setComment_content(commentContent);
		vo.setBoard_idx(newIdx);
		
		PrintWriter out = response.getWriter();
		
		JsonObject json = new JsonObject();
		if(service.insertComment(vo)>0) {
			List<CommentVO> list = service.selectComment(newIdx);
			JsonArray array = new JsonArray();
			for (CommentVO commentVO : list) {
				JsonObject sub = new JsonObject();
				sub.addProperty("date", commentVO.getComment_date());
				sub.addProperty("writer", commentVO.getComment_writer());
				sub.addProperty("content", commentVO.getComment_content());
				array.add(sub);
			}
			json.addProperty("result", "성공");
			json.add("comment", array);
		}else {
			json.addProperty("result", "실패");						
		}
		out.print(gson.toJson(json));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
