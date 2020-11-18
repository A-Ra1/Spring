<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
	margin: 0px auto;
	width: 400px;
}
</style>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <h3 class="text-center">성적등록</h3>
	  <form method=post action="insert_ok.do">
	  <table class="table">
	   <tr>
	    <td width=20% class="text-right success">이름</td>
	    <td width=80%>
	     <input type=text name=name size=15 required>
	    </td>
	   </tr>
	   <tr>
	    <td width=20% class="text-right success">국어</td>
	    <td width=80%>
	     <input type=text name=kor size=15 required>
	    </td>
	   </tr>
	   <tr>
	    <td width=20% class="text-right success">영어</td>
	    <td width=80%>
	     <input type=text name=eng size=15 required>
	    </td>
	   </tr>
	   <tr>
	    <td width=20% class="text-right success">수학</td>
	    <td width=80%>
	     <input type=text name=math size=15 required>
	    </td>
	   </tr>
	   <tr>
	    <td class="text-center" colspan="2">
	     <button class="btn btn-sm btn-danger">등록</button>
	     <input type=button class="btn btn-sm btn-danger" value="취소"
	      onclick="javascript:history.back()"
	     >
	    </td>
	   </tr>
	  </table>
	  </form>
	 </div>
	</div>
</body>
</html>