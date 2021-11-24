<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
 List<BoardVO> list = (List<BoardVO>)request.getAttribute("searchList");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<%
			if(list != null && list.size() > 0){
		%>
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
				<td><a href="/midProject/selectBoard.do?boardIdx=<%=list.get(i).getBoard_idx()%>"><%=list.get(i).getBoard_title() %></a></td>
				<td><span><%=list.get(i).getBoard_wrtier() %></span></td>
				<td><span><%=list.get(i).getBoard_cnt() %></span></td>
				<td><span><%=list.get(i).getBoard_date() %></span></td>
			</tr>
			<% 
			}
			%>
		</table>
		<% 
			} else {
		%>
		<h2>검색결과가 없습니다</h2>
		<%} %>
</body>
</html>