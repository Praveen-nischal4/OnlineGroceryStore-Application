<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
       <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

<style>

li {
  
 border-right:1px solid white;
 height:15px;
}

a{
margin-top:-15px;
width:100px;
text-align:right;
}

#title{
margin-top:3px;
font-size:25px;
font-weight:bolder;
}

#menulink {
width:150px;
}

#menulink:hover
{
color:red;
}

li #mystyle:hover {
color:red;
padding:auto;
}

input[type="submit"]:hover {
    background-color:white;
   
}
</style>

</head>
<body >
<nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark navbar-dark">
  <div class="container-fluid">
    <a id="title" class="navbar-brand" href="${pageContext.request.contextPath }/">GROCERY STORE</a>
   
    
   
      <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="position:absolute;left:360px;margin-right:5px;">
        <li class="nav-item" >
          <a id="mystyle" class="nav-link active   " aria-current="page" href="${pageContext.request.contextPath }/">Home</a>
        </li>
        <li class="nav-item">
          <a id="mystyle" class="nav-link" href="${pageContext.request.contextPath }/about">About</a>
        </li>
       
         <li class="nav-item">
          <a id="mystyle" class="nav-link" href="${pageContext.request.contextPath }/myContact">Contact</a>
        </li>
       
        <li class="nav-item">
          <a id="mystyle" class="nav-link" href="${pageContext.request.contextPath }/Menu">Menu</a>
        </li>
        <sec:authorize access='hasAuthority("Admin")' >
         <li class="nav-item">
          <a id="mystyle" class="nav-link" href="${pageContext.request.contextPath }/addItems">Add Item</a>
        </li>
        </sec:authorize>
        <li class="nav-item">
          <a id="mystyle" class="nav-link" href="${pageContext.request.contextPath }/myCart"> My Cart</a>
        </li>
        
        <li class="nav-item">
          <a id="mystyle" class="nav-link" href="${pageContext.request.contextPath }/orderdItems"> My Order</a>
        </li>
        
         <li class="nav-item">
          <a id="menulink" class="nav-link" href="${pageContext.request.contextPath }/changepassword"> Update Password</a>
        </li>
      </ul>
    <form:form action="logout" method="post" style="position:absolute;left:1230px;top:22px;" class=" btn  text-light">
 <input type="submit" value="LOGOUT" class=" btn  fw-bold " style="padding:0px;margin-top:-17px;color:Blue"/>
</form:form>
    </div>

</nav>
</body>
</html>