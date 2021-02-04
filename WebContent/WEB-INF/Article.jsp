<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-10 col-md-offset-1">
<div class="panel panel-primary">
 
   <div class="panel-heading">Recherche des articles</div>
  <div class="panel-body">
     <form action="chercher.java" method="get">
     
     <label>Mot clé</label>
     <input type="text" name="motCle" value="${model.motCle}"/>
     <button type="submit" class="btn btn-primary">chercher</button>
     </form>
     <table class="table table-striped">
     <tr>
      <th>ID</th><th>Title</th><th>Price</th>
     </tr>
         <td>
     </td>
    <c:forEach items="${model.article}" var="p">
    
    <tr>

     <td>${p.id}</td>
     <td>${p.title}</td>
     <td>${p.price}</td>
     <td> <a onclick="return confirm('Etes vous sure?')" href="Supprimer.java?id=${p.id}">Supprimer</a></td>
     <td> <a href="Edit.java?id=${p.id}">Edit</a></td>
    </tr>
    
    </c:forEach>
     </table>
  </div>
</div>
</div>
</body>
</html>