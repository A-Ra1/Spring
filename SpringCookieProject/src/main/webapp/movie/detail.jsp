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
   width: 800px;
}
</style>
</head>
<body>
 <div style="height:30px"></div>
 <div class="container">
  <div class="row">
   <h3 class="text-center">&lt;${vo.title }&gt;상세보기</h3>
   <table class="table">
    <tr>
     <td>
      <iframe src="http://youtube.com/embed/${vo.key }" width=750 height=350></iframe>
     </td>
    </tr>
   </table>
   <table class="table">
    <tr>
     <td width=30% class="text-center" rowspan="7">
      <img src="${vo.poster }" width=100%>
     </td>
     <td colspan="2">${vo.title }</td>
    </tr>
    <tr>
     <td width=20% class="text-right">감독</td>
     <td width=50% class="text-left">${vo.director }</td>
    </tr>
    <tr>
     <td width=20% class="text-right">출연</td>
     <td width=50% class="text-left">${vo.actor }</td>
    </tr>
    <tr>
     <td width=20% class="text-right">장르</td>
     <td width=50% class="text-left">${vo.genre }</td>
    </tr>
    <tr>
     <td width=20% class="text-right">등급</td>
     <td width=50% class="text-left">${vo.grade }</td>
    </tr>
    <tr>
     <td width=20% class="text-right">평점</td>
     <td width=50% class="text-left">${vo.score }</td>
    </tr>
    <tr>
     <td width=20% class="text-right">개봉일</td>
     <td width=50% class="text-left">${vo.regdate }</td>
    </tr>
    <tr>
     <td colspan="3">${vo.story }</td>
    </tr>
    <tr>
     <td colspan="3" class="text-right">
      <a href="list.do" class="btn btn-sm btn-primary">목록</a>
     </td>
    </tr>
   </table>
  </div>
 </div>
</body>
</html>