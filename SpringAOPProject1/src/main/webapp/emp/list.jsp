<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
	margin: 0px auto;
	width: 800px;
}
</style>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <h1 class="text-center">사원목록</h1>
	   <table class="table table-striped">
	    <tr class="success">
	     <th>사번</th>
	     <th>이름</th>
	     <th>직위</th>
	     <th>입사일</th>
	     <th>급여</th>
	     <th>부서명</th>
	     <th>근무지</th>
	    </tr>
	    <c:forEach var="vo" items="${list }">
	     <tr>
	      <td>${vo.empno }</td>
	   	  <td><a href="detail.do?empno=${vo.empno }">${vo.ename }</a></td>
	   	  <%--
	   	  	@GetMapping : 메소드방식(데이터전송) : GET <a> sendRedirect(), location.href
	   	  	@PostMapping
	   	  	@RequestMapping (@GetMapping+@PostMapping)
	   	   --%>
	      <td>${vo.job }</td>
	      <td><fmt:formatDate value="${vo.hiredate }" pattern="yyyy-MM-dd"/></td>
	      <td>${vo.sal }</td>
	      <td>${vo.dname }</td>
	      <td>${vo.loc }</td>
	     </tr>
	    </c:forEach>
	   </table>
	 </div>
	</div>
</body>
</html>