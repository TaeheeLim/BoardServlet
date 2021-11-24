<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.CommentVO"%>
<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVO vo = (BoardVO)request.getAttribute("board");
 	List<CommentVO> list = (List<CommentVO>)request.getAttribute("comment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="../resources/js/summernote/lang/summernote-ko-KR.js"></script>
<style>
.hidden{
	display: none;
}
.article_header {
position: relative;
margin-bottom: 20px;
padding-bottom: 20px;
border-bottom: 1px solid #ebecef;
}

.body_container {
	padding: 29px 29px 0;
	border: 1px solid #ebecef;
	border-radius: 6px;
}
.footer{
	display: flex;
	gap : 20px;
}

.href {
	text-decoration: none;
	font-weight: bold;
	color: black;
	
}

.comment_area {
	display: flex;
	justify-content: space-around;
}

</style>
</head>
<body>
	<section>
		<div class="body_container">
			<form action="<%=request.getContextPath() %>/updateBoard.do?boardIdx=<%=vo.getBoard_idx() %>" method="post" id="modify">
				<div class="article_header">
					<div class="article_title">
						<h3><%=vo.getBoard_title() %></h3>
					</div>
					<div class="writer_info">
						<h5><%=vo.getBoard_wrtier() %></h5>
					</div>
					<div class="article_info">
						<span class="date"><%=vo.getBoard_date() %></span>
						<span class="count">조회수: <%=vo.getBoard_cnt() %></span>
					</div>
				</div>
				
				<div class="main_container">
					<div class="content">
						<%=vo.getBoard_content() %>
					</div>
				</div>
			</form>
		</div>
	</section>
	
	<section>
		<div class="footer">
				<button type="button" class="update">수정</button>
				<button type="button" class="complete hidden">수정 완료</button>
				<a href="<%=request.getContextPath() %>/deleteBoard.do?boardIdx=<%=vo.getBoard_idx() %>" class="href delete">삭제</a>
		</div>
	</section>
	
	<section>
		<div class="comment_container">
			<ul id="comment-ul">
			<%
			for(int i = 0; i < list.size(); i ++){
			%>
				<li>
					<div>
						<%=list.get(i).getComment_idx() %>,<%=list.get(i).getComment_writer() %>,<%=list.get(i).getComment_date() %>
					</div>
					<div>
						<%=list.get(i).getComment_content() %>
					</div>
				</li>
			
			<%
			}
			%>
			</ul>
			<form class="comment_form">
				<input type="text" placeholder="작성자이름" name="comment_writer" id="comment_writer">
				<textarea rows="7" cols="100" class="comment_area" placeholder="댓글을 입력하세요" name="comment_content"></textarea>
				<br>
				<button type="button" class="comment_button">댓글등록</button>
			</form>
		</div>
	</section>

<script>
const deleteBoard = document.querySelector('.delete');
deleteBoard.addEventListener('click',function() {
	alert('삭제가 완료되었습니다.');
});

const update = document.querySelector('.update');

update.addEventListener('click',function(){
	
	const titleDiv = document.querySelector(".article_title");
	const title = document.querySelector(".article_title h3");
	const titleBox = document.createElement("input");
	titleBox.type = "text";
	titleBox.name = "title";
	titleBox.setAttribute("value", title.innerText);
	titleDiv.append(titleBox);
	title.remove();
	
	const contentBox = document.createElement("textarea");
	contentBox.id = "summernote";
	contentBox.rows="40";
	contentBox.cols="100";
	contentBox.name="editordata"

	const content = document.querySelector(".content");
	const container = document.querySelector(".main_container");
	contentBox.innerHTML = content.innerHTML;
	container.append(contentBox);
	content.remove();
	
	$('#summernote').summernote({
		height: 300,
		minHeight: null,
		maxHeight: null,
		focus: true,
		placeholder: '내용을 입력해주세요',
		tabsize: 2,
		lang: 'ko-KR'
	});
	
	const hideDelete =document.querySelector(".delete")
	hideDelete.classList.add("hidden");
	const hideUpdate = document.querySelector(".update")
	hideUpdate.classList.add("hidden");
	const complete = document.querySelector(".complete")
	complete.classList.remove("hidden");
	
	const writer = document.querySelector("#comment_writer");
	const contentArea = document.querySelector(".comment_area");
	const button = document.querySelector(".comment_button");
	
	writer.classList.add("hidden");
	contentArea.classList.add("hidden");
	button.classList.add("hidden");
});
z

const newComplete = document.querySelector(".complete");

newComplete.addEventListener('click',function(){
	const modify = document.querySelector("#modify");
	
	modify.submit();
	
	alert("수정이 완료되었습니다.")
	
});

$(function(){
	$('.comment_button').on('click',function(){
		const param = {
			writer: $('#comment_writer').val(),
			content: $('.comment_area').val(),
			boardIdx: <%=vo.getBoard_idx() %>
		};
		$.ajax({
			url : '<%=request.getContextPath()%>/insertComment.do',
			type: 'post',
			data: param,
			success: function(res){
				if(res.result === '성공') {
					var code = "" ;
					const commentList = res.comment;
					for (var i = 0; i < commentList.length; i++) {
						code += "<li>";
						code += "<div>" + commentList[i].date + "</div>";
						code += "<div>" + commentList[i].writer + "</div>";
						code += "<div>" + commentList[i].content + "</div>";						
						code += "</li>";
					}
					const commentul = document.querySelector("#comment-ul");
					commentul.innerHTML = code;
				} else {
					alert('댓글 등록 실패')
				}
			},
			error  : function(xhr){
				console.log(xhr);
			},
			dataType: 'json'
		});
	});
});


</script>
</body>
</html>