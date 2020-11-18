<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
	margin: 0px auto;
	width:900px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.names').hover(function(){
		$(this).css("cursor", "pointer");
	},function(){
		$(this).css("cursor", "");
	});
	$('.names').click(function(){
		let name=$(this).text();
		$.ajax({
			type:'POST',
			url:'sublist.do',
			data:{"ename":name},
			success:function(result) {
				$('#print').html(result);				
			}
		});
	})
});

</script>
</head>
<body>
 <div class="container">
  <div class="row">
   <h3 class="text-center">사원 목록</h3>
   <table class="table table-striped">
    <tr class="success">
                  <th>사번</th>
                  <th>이름</th>
                  <th>직위</th>
                  <th>입사일</th>
                  <th>부서명</th>
                  <th>근무지</th>
    </tr>
     <c:forEach var="vo" items="${list}">
                  <tr>
                   <td>${vo.empno}</td>
                   <td><span class="names">${vo.ename}</span></td>
                   <td>${vo.job}</td>
                   <td><fmt:formatDate value="${vo.hiredate}" pattern="yyyy-MM-dd"/></td>
                   <td>${vo.dname}</td>
                   <td>${vo.loc}</td>
                  </tr>
     </c:forEach>
   </table>
  </div>
  <div class="row">
   <h3 class="text-center">같은 부서에서 근무하는 사원 목록</h3>
   <div id="print"></div>
  </div>
 </div>
</body>
</html>