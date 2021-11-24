<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="card-body bg-white mt-0 shadow">
		<form method="post" action="<%=request.getContextPath() %>/kakaoPay.do?cmd=payment">
                <p style="font-weight: bold">카카오페이 충전 금액</p>
                <label class="box-radio-input"><input type="radio" name="cp_item" value="100"><span>100원</span></label> <br>
                <label class="box-radio-input"><input type="radio" name="cp_item" value="5000"><span>5,000원</span></label> <br>
                <label class="box-radio-input"><input type="radio" name="cp_item" value="10000"><span>10,000원</span></label><br>
                <label class="box-radio-input"><input type="radio" name="cp_item" value="20000"><span>20,000원</span></label><br>
                <label class="box-radio-input"><input type="radio" name="cp_item" value="30000"><span>30,000원</span></label><br>
                <label class="box-radio-input"><input type="radio" name="cp_item" value="40000"><span>40,000원</span></label><br>
                <label class="box-radio-input"><input type="radio" name="cp_item" value="50000"><span>50,000원</span></label>
                <p  style="color: #ac2925; margin-top: 30px">카카오페이의 최소 충전금액은 5,000원이며 <br/>최대 충전금액은 50,000원 입니다.</p>
                <button type="submit" class="btn btn-lg btn-block  btn-custom" id="charge_kakao">충 전 하 기</button>
		</form>
 </div>
 
 
 
 
 
</body>
<!--  
<script>
const kakao = document.querySelector('#charge_kakao');

kakao.addEventListener('click',function(){
	
});

</script>
-->
</html>