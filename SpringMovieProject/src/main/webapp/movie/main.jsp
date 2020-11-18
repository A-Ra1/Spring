<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
	margin: 0px auto;
	width: 900px
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jqury.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:'POST',
		url:'main.do',
		data:{"no":1},
		success:function(result) {
			
			location.href="main.do?no=1";
		}
	})
	
});
</script>
</head>
<body>
<div style="height:30px"></div>
 <div class="container">
  <div class="row">
   <span class="btn btn-sm btn-primary links" value="1">박스오피스</span>
   <span class="btn btn-sm btn-danger links" value="2">실시간 예매율</span>
   <span class="btn btn-sm btn-warning links" value="3">예매율 좌석 점유율</span>
   <span class="btn btn-sm btn-success links" value="4">온라인 예매 순위</span>
  </div>
 </div>
</body>
</html>