<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
	margin: 0px auto;
	width: 600px;
}
</style>
</head>
<body>
 <div class="container">
  <div class="row">
   <h3 class="text-center">학생정보</h3>
   <table class="table">
    <tr>
     <td>
      <a href="insert.do" class="btn btn-sm btn-danger">등록</a>
     </td>
    </tr>
   </table>
   <table class="table table-striped">
    <tr class="success">
     <th>학번</th>
     <th>이름</th>
     <th>국어</th>
     <th>영어</th>
     <th>수학</th>
     <th>총점</th>
     <th>평균</th>
     <th></th>
    </tr>
    <c:forEach var="vo" items="${list }">
     <tr>
      <td>${vo.hakbun }</td>
      <td>${vo.name }</td>
      <td${vo.kor }></td>
      <td>${vo.eng }</td>
      <td>${vo.math }</td>
      <td>${vo.total }</td>
      <td>${vo.avg }</td>
      <td>
       <a href="update.do?hakbun=${vo.hakbun }" class="btn btn-sm btn-success">수정</a>
       <a href="delete.do?hakbun=${vo.hakbun }" class="btn btn-sm btn-info">삭제</a>
      </td>
     </tr>
    </c:forEach>
   </table>
  </div>
 </div>
</body>
</html>