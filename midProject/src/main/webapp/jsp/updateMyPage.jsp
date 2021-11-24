<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="basicInfo">
			<ul id="info">
				<li>내 소개: 
					<input type="text" value="<%=vo.getIntroduction() %>">
				</li>
				<li>회원 이메일: 
					<span>
						<%=vo.getMember_mail() %>
					</span>
				</li>
				<li>회원이름: 
					<span>
						<%=vo.getFirstname() %> <%=vo.getLastname() %>
					</span>
				</li>
				<li>닉네임 : 
					<input type="text" value="<%=vo.getNickname() %>">
				</li>
				<li>가입날짜: 
					<span>
						<%=vo.getMember_date() %>
					</span>
				</li>
				<li>주민번호 앞자리: 
					<span>
						<%=vo.getRegedent_num() %>
					</span>
				</li>
			</ul>
		</div>
		
		<button>수정 완료</button>
</body>
</html>