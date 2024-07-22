<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<style>
#my{
 width:180px;
}
</style>

</head>
<body class="container-fluid ">
<%@ include file="header2.jsp" %>
<h1 class=" bg-success text-light text-center"> MY MENU</h1>
<img src="${pageContext.request.contextPath}/resources/static/images/image5.png" alt="image5" width="1350px" height="205px"/>
<hr>

<sec:authorize access='hasAuthority("Admin")' >
<a id="my"class="btn btn-primary text-light p-2 mt-3 mx-3 text-center" href="${pageContext.request.contextPath}/addItems"> Add Menu Items</a>
</sec:authorize >

</body>
</html>