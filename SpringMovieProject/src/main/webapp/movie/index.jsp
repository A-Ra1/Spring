<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jqury.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:'POST',
		url:'main.do',
		data:{"no":1}
		success:function(result) {
			
			
		}
	})
	
});
</script>
</head>
<body>

</body>
</html>