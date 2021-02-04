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

<form action="SaveArticle.java" method="post">

<div class="form-group">
<label class="control-label">Title</label>
<input type="text" name="title" class="form-control"/>
<span></span>
</div>

<div class="form-group">
<label class="control-label">Price</label>
<input type="text" name="Price" class="form-control"/>
<span></span>
</div>
<div>
<button type="submit" class="btn btn-primary">Save</button>
</div>
</form>


</div>



</div>




</div>


</body>
</html>