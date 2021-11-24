<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</head>
<body>
	 <form method="post" action="<%=request.getContextPath() %>/insertBoard.do">
		제목 : <input type="text" name="title"><br>
		<textarea id="summernote" rows="40" cols="100" name="editordata"></textarea>
		<button type="submit">등록</button>
	 </form>






<script>
$(document).ready(function(){
	$('#summernote').summernote({
		height: 300,
		minHeight: null,
		maxHeight: null,
		focus: true,
		placeholder: '내용을 입력해주세요',
		tabsize: 2,
		lang: 'ko-KR'
	});
});
</script>
</body>
</html>