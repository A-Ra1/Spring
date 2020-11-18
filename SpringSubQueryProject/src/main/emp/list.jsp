<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:900px;
}
</style>
<script src="https://unpkg.com/react@15/dist/react.js"></script>
<script src="https://unpkg.com/react-dom@15/dist/react-dom.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.34/browser.js"></script>
</head>
<body>
  <div class="container">
    <div class="row" id="root">
    
    </div>
  </div>
  <!-- 
       ES 5.0   text/javascript
       ES 6.0   text/babel  ===> react (ES6) ==> jsx (javascript+XML)
                                                =====
                                                1. 대소문자 구분 
                                                2. 여는 태그 , 닫는 태그 동일 
                                                3. 태그를 사용할 경우 => 소문자 시작 
             React ==> Redux
                       (MVC)  ==> saga , mobx(배달의 민족)
   -->
  <script type="text/babel">
    class Emp extends React.Component{
       render() {
           return (
              <table className="table table-striped">
               <thead>
                 <tr className="success">
                  <th>사번</th>
                  <th>이름</th>
                  <th>직위</th>
                  <th>입사일</th>
                  <th>부서명</th>
                  <th>근무지</th>
                 </tr>
               </thead>
               <tbody>
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
               </tbody>
              </table>
           )
       }
    }
    ReactDOM.render(<Emp/>,document.getElementById('root'))
  </script>
</body>
</html>