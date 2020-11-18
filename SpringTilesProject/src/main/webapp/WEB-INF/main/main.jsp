<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:1200px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table" height="900">
	     <tr>
	      <td colspan="2" height="100">
	        <tiles:insertAttribute name="header"/>
	      </td>
	     </tr>
	     <tr>
	       <td width=20% height="700">
	         <tiles:insertAttribute name="menu"/>
	       </td>
	       <td width=80% height="700" name="content">
	         <tiles:insertAttribute name="content"/>
	       </td>
	     </tr>
	     <tr> 
	       <td colspan="2" height="100" name="footer">
	         <tiles:insertAttribute name="footer"/>
	       </td>
	     </tr>
	   </table>
    </div>
  </div>
</body>
</html>