<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
 	String img = (String)request.getAttribute("img");
 	int sum = (int)request.getAttribute("sum");
 	
 	int myBoard = (int)request.getAttribute("myBoard");
 	int myComment = (int)request.getAttribute("myComment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../css/reset.css">
<style>
.myPage {
	display: flex;
	flex-direction: column;
	justify-content: center;
	gap: 60px;
}

#info li {
	text-decoration: none;
}

.hidden {
	display : none;
}
</style>
</head>
<body>
	
	<section class="myPage">
<%-- 		<img src="/midProject/resimg/<%=vo.getProfileimg() %>"> --%>
<!-- 		<div class="image"> -->
<%-- 			<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath() %>/imageUpload.do"> --%>
<!-- 				<input type="file" name="filename" size=40> -->
<!-- 				<input type="submit" value="업로드" id="imgBtn"> <br><br> -->
<!-- 			</form> -->
<!-- 			<div id="img"> -->
<!-- 				<img class="profile-img"> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
		<div class="basicInfo">
			<ul id="info">
				<li>내 소개: 
					<input type="text" value="<%=vo.getIntroduction() %>" class="intro-info">
					<button type="button" class="intro-updatebtn">수정</button>
				</li>
				<li>회원 이메일: 
					<span>
						<%=vo.getMember_mail() %>
					</span>
				</li>
				<li>비밀번호:  
					<input type="text" class="pass-info">
					<button type="button" class="pass-updatebtn">수정</button>
				</li>
				<li>회원이름: 
					<span>
						<%=vo.getFirstname() %> <%=vo.getLastname() %>
					</span>
				</li>
				<li>닉네임 : 
					<input type="text" value="<%=vo.getNickname() %>" class="nickname-info">	
					<button type="button" class="nickname-updatebtn">수정</button>
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
				<li><button type="button" id="posessingBtn">내가 가진 씨앗:</button>
					<span>
						<%=sum %> 개
					</span>
				</li>
				<li>
                	<div>
                		<span class="page-th">내가 쓴 게시글 수 : </span>
                        <span><%=myBoard %></span>
                    </div>
                </li>
                <li>
                	<div>
                    	<span class="page-th">내가 쓴 댓글 수 : </span>
                        <span><%=myComment %></span>
                   	</div>
                </li>
			</ul>
		</div>
	</section>
	
	<button type="button" id="seedBtn">씨앗 충전하기</button>	
	
		
	
<script>
const introBtn = document.querySelector(".intro-updatebtn");
const introTxt = document.querySelector(".intro-info");

const passBtn = document.querySelector(".pass-updatebtn");
const passTxt = document.querySelector(".pass-info");

const nicknameBtn = document.querySelector(".nickname-updatebtn");
const nicknameTxt = document.querySelector(".nickname-info");

const seed = document.querySelector('#seedBtn');
seed.addEventListener('click',function(){
	window.open('<%=request.getContextPath()%>/jsp/kakaoPayList.jsp',"_blank","width=400,height=500");
});

const possess = document.querySelector('#posessingBtn');
possess.addEventListener('click',function(){
	window.open('<%=request.getContextPath()%>/showSeedList.do',"_blank","width=400,height=500");
});
introBtn.addEventListener("click",function(){
	update('intro',introTxt.value);
});
passBtn.addEventListener("click",function(){
	update('pass',passTxt.value);
});
nicknameBtn.addEventListener("click",function(){
	update('nickname',nicknameTxt.value);
});



function update(cmd,value){
	const param = {
		cmd : cmd,
		value : value
	};
	$.ajax({
		url:"<%=request.getContextPath()%>/updateMyPage.do",
		method:"post",
		data: param,
		success: function(res){
			if(res.sw ==='ok') {
				if(cmd==='pass'){
					passTxt.value="";
				}
				alert("수정성공");
			}else{
				alert("수정실패");
			}
		},
		error: function(xhr){
			alert(xhr.status);
		},
		dataType: 'json'
	});
}

// $(function(){
// 	url: 'imageUpload.do',
// 	method : 'post',
// 	data: '',
// });
	
</script>
</body>
</html>