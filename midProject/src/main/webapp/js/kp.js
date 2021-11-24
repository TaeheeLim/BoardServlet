$(function(){
	$('#apibtn').click(function(){
		$.ajax({
			url: '/',
			dataType: 'json',
			success:function(data){
				alert(data);
			},
			error:function(error){
				alert(error);
			}
		});
	});
});