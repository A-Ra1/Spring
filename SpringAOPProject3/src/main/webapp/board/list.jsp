<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:800px;
}
.btd {
  font-size: 8pt;
}
</style>
</head>
<body>
 <div class="container">
  <div class="row">
    <h3 class="text-center">자유게시판</h3>
    <c:if test="${sessionScope.id!=null }">
    <table class="table">
      <tr>
        <td class="text-left">
          <a href="insert.do" class="btn btn-sm btn-danger">새글</a>
        </td>
      </tr>
    </table>
    </c:if>
    <table class="table table-striped">
      <tr class="warning">
        <th class="text-center" width=10%>번호</th>
        <th class="text-center" width=45%>제목</th>
        <th class="text-center" width=15%>이름</th>
        <th class="text-center" width=20%>작성일</th>
        <th class="text-center" width=10%>조회수</th>
      </tr> 
      <c:forEach var="vo" items="${list }">
        <tr>
	        <td class="text-center btd" width=10%>${vo.no }</td>
	        <td class="text-left btd" width=45%>
	        <c:if test="${vo.getGt()>0 }">
	         <c:forEach var="i" begin="1" end="${vo.getGt() }">
	          &nbsp;&nbsp;&nbsp;
	         </c:forEach>
	          	▶
	        </c:if>
	         <a href="detail.do?no=${vo.no }">${vo.subject }</a>
	        </td>
	        <td class="text-center btd" width=15%>${vo.name }</td>
	        <td class="text-center btd" width=20%>${vo.regdate }</td>
	        <td class="text-center btd" width=10%>${vo.hit }</td>
      </tr> 
      </c:forEach>
    </table>
    <table class="table">
      <tr>
        <td class="text-left"></td>
        <td class="text-right">
          <a href="#" class="btn btn-sm btn-primary">이전</a>
            ${curpage } page / ${totalpage } pages
          <a href="#" class="btn btn-sm btn-primary">다음</a>
        </td>
      </tr>
    </table>
  </div>
 </div> 
</body>
</html>