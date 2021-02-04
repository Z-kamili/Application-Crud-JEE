<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="header.jsp"  %>

<div class="container col-md-8 col-md-offset-2 col-xs-12">

<div class="panel panel-primary">

<div class="panel-heading"> Saisie d'un produit </div>

<div class="panel-body">


 
  <div class="form-group">
 <label>Title:</label>
 <label>${article.title}</label>
 
 </div>
  <div class="form-group">
 <label>Price:</label>
 <label>${article.price}</label>
 
 </div>


</div>



</div>


</div>


</body>
</html>