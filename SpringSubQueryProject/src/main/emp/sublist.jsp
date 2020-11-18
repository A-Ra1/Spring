<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
	margin: 0px auto;
	width:900px;
}
</style>
</head>
<body>
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
                   <td>${vo.ename}</td>
                   <td>${vo.job}</td>
                   <td><fmt:formatDate value="${vo.hiredate}" pattern="yyyy-MM-dd"/></td>
                   <td>${vo.dname}</td>
                   <td>${vo.loc}</td>
                  </tr>
     </c:forEach>
   </table>
</body>
</html>