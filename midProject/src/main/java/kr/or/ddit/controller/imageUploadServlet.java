package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oreilly.servlet.MultipartRequest;

import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.util.RandImgValueUtil;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.UploadFileVO;



@WebServlet("/imageUpload.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024
		* 100)
public class imageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RandImgValueUtil randUtil = RandImgValueUtil.getInstance();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로 설정
		// Strimg mail = session.getasdgasd("mail");
		// if(mail==null)
				String uploadPath = "D:\\Ateachingmaterial\\3.Highjava\\Workspace\\midProject\\src\\main\\webapp\\resimg"; 
				
				
				// 저장될 폴더가 없으면 새로 생성한다.
				File fileUploadDir = new File(uploadPath);
				if(!fileUploadDir.exists()) {
					fileUploadDir.mkdirs();
				}
				//-------------------------------------------------
				// 파일이 아닌 일반 Form Data들은 getParameter()메소드나
				// getParameterValues()메소드를 이용해서 구한다.
				//String memId = request.getParameter("memid");
				//System.out.println("일반 Form Data : " + memId);
				
				//-------------------------------------------------------
				String fileName = ""; // 파일명이 저장될 변수 선언
				
				// 업로드한 파일의 정보를 저장할 List 생성
				List<UploadFileVO> list = new ArrayList<>();
				
				/*
					- Servlet 3.0이상에서 파일 정보를 관리하는 객체는 Part객체이다.
					- 전체 Part객체 구하기 ==> request.getParts();
					 - 개별적인 Part객체 구하기 ==> request.getPart("part이름");
					 
					 - part객체에서 제공하는 메소드들...
					 1) getInputStream() : Part의 내용을 읽는데 사용하는 InputStream객체를 반환한다.
					 
					 2) getSize() : 업로드된 파일의 크기를 byte단위로 반환한다.
					 3) getHeader(String name) : Part로 부터 지정한 name을 갖는 헤더값을 반환한다. 
					 4) wrtie(String fileName) : 임시 저장되어 있는 파일 데이터를
					 				fileNmae에 지정한 경로로 저장한다.
					 
				 */
				
				MemberServiceImpl service = MemberServiceImpl.getInstance();
				MemberVO mvo = new MemberVO();
				mvo.setMember_mail("lim3617@naver.com");
				
				for(Part part : request.getParts()) {
					fileName = extractFileName(part);
					
					// 구해온 파일명이 공백("")이면 이것은 파일이 아닌 일반 Form data라는 의미이다.
					if(!"".equals(fileName)) {
						// 1개의 업로드 파일 정보를 저장할 VO객체 생성
						//file이름을 재생성
						UploadFileVO vo = new UploadFileVO();
						
						fileName = randUtil.makeRand();
						
						mvo.setProfileimg(fileName);
						vo.setFileSize((long)Math.ceil(part.getSize()/1024.0)); // 파일 크기는 KB단위로 저장
						
						service.insertImg(mvo);
						
						try {

							 part.write(uploadPath + File.separator + fileName); // 파일 저장
							 vo.setUploadStatus("Success");
							 
						} catch (IOException e) {
							vo.setUploadStatus("Fail : " + e.getMessage());
						}
						
						list.add(vo);
					} // if문
				} // for문
				
//				request.setAttribute("memId", memId);
				request.setAttribute("uploadFileList", list);
				PrintWriter out = response.getWriter();
				System.out.println("멈춰!");
				out.println("<script>");
				out.println("console.log('aaa');");
				out.println("alert('aa');");
				out.println("location.href='/midProject/myPageServlet.do'");
				out.println("</script>");
				
				//response.sendRedirect(request.getContextPath()+"/myPageServlet.do");
				
	}
	
	private String extractFileName(Part part) {
		String fileName = "";
		String contentDisposition = part.getHeader("Content-Disposition");
		String[] items = contentDisposition.split(";");
		
		for(String item : items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length()-1);
			}
		}
		return fileName;
		
	}
}
