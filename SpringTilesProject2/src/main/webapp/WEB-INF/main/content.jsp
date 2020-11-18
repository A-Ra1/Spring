<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="about" class="container-fluid">
  <div class="row">
    <div class="col-sm-10">
	 <c:forEach var="vo" items="${mList }">
	  <div class="col-md-3">
	    <div class="thumbnail">
	      <a href="#">
	        <img src="${vo.poster }" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p style="font-size: 8pt">${vo.title }</p>
	        </div>
	      </a>
	    </div>
  	  </div>
	 </c:forEach>
	 <div class="text-center">
	  <a href="main.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-success">이전</a>
	   ${curpage } page / ${totalpage } pages
	  <a href="main.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-info">다음</a>
	 </div>
    </div>
    <div class="col-sm-2">
	  <table class="table table-striped">
	   <caption>댓글이 많은 영화</caption>
	   <c:forEach var="vo" items="${tList }">
	    <tr>
	     <td>
	      <img src="${vo.poster }" width=25 height=25>
	     </td>
	     <td style="font-size: 7pt">${vo.title }</td>
	    </tr>
	   </c:forEach>
	  </table>
    </div>
  </div>
</div>

<div class="container-fluid bg-grey">
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-globe logo slideanim"></span>
    </div>
    <div class="col-sm-8">
      <h2>Our Values</h2><br>
      <h4><strong>MISSION:</strong> Our mission lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</h4><br>
      <p><strong>VISION:</strong> Our vision Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
      Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
  </div>
</div>

</body>
</html>