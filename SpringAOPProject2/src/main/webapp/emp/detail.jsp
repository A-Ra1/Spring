<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	width: 350px;
}
</style>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <h1 class="text-center">&lt;${vo.ename }&gt;사원 정보</h1>
	   <table class="table">
	    <tr>
	     <td width=25% class="text-right">사번</td>
		 <td width=75%>${vo.empno }</td>
	    </tr>
	     <tr>
	     <td width=25% class="text-right">이름</td>
		 <td width=75%>${vo.ename }</td>
	    </tr>
	     <tr>
	     <td width=25% class="text-right">직위</td>
		 <td width=75%>${vo.job }</td>
	    </tr>
	     <tr>
	     <td width=25% class="text-right">입사일</td>
		 <td width=75%><fmt:formatDate value="${vo.hiredate }" pattern="yyyy-MM-dd"/></td>
	    </tr>
	     <tr>
	     <td width=25% class="text-right">급여</td>
		 <td width=75%>${vo.sal }</td>
	    </tr>
	     <tr>
	     <td width=25% class="text-right">부서명</td>
		 <td width=75%>${vo.dname }</td>
	    </tr>
	     <tr>
	     <td width=25% class="text-right">근무지</td>
		 <td width=75%>${vo.loc }</td>
	    </tr>
	   </table>
	 </div>
	</div>
</body>
</html>