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
}
</style>
</head>
<body>
 <div style="height: 30px"></div>
 <div class="container-fluid">
  <div class="row">
   <c:forEach var="vo" items="${list }">
     <div class="col-md-3">
	    <div class="thumbnail">
	      <a href="detail_before.do?no=${vo.no }">
	        <img src="${vo.poster }" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p style="font-size: 8pt">${vo.title }</p>
	        </div>
	      </a>
	    </div>
  	  </div>
   </c:forEach>
  </div>
  <hr>
  <div class="row">
   <h3>미리 본 영화목록</h3>
    <c:forEach var="vo" items="${cList }" varStatus="s">
     <c:if test="${s.index<6 }">
      <div class="col-md-2">
	    <div class="thumbnail">
	      <a href="detail_before.do?no=${vo.no }">
	        <img src="${vo.poster }" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p style="font-size: 8pt">${vo.title }</p>
	        </div>
	      </a>
	    </div>
  	  </div>
  	 </c:if> 
    </c:forEach>
  </div>
 </div>
</body>
</html>