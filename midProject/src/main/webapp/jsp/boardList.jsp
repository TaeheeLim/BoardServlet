																																		<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 목록 전체 조회</h1>
	<hr>
	<form method="post" action="<%=request.getContextPath()%>/searchBoard.do">
		<div class="search_board">
			<label for="search">제목검색: </label>
			<input type="text" id="search" name="search" placeholder="내용을 입력해주세요">	
			<button type="submit">검색</button>
		</div>
	</form>
	
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<%
			for(int i = 0; i < list.size(); i++){
		%>
			<tr>
				<td><span><%=list.get(i).getBoard_idx() %></span></td>
				<ta href="/midProject/selectBoard.do?boardIdx=<%=list.get(i).getBoard_idx()%>"><%=list.get(i).getBoard_title() %></a></td>
				<td><span><%=list.get(i).getBoard_wrtier() %></span></td>
				<td><span><%=list.get(i).getBoard_cnt() %></span></td>
				<td><span><%=list.get(i).getBoard_date() %></span></td>
			</tr>
			<% } %>
	</table>
	<br>
	<button type="submit" onclick="location.href='<%=request.getContextPath()%>/jsp/board.jsp'">글 등록하기</button>
</body>

</html>