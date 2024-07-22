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
</head>
<body class="container-fluid m-auto">
<h1 class="text-left fw-bold text-success"> GROCERY STORE</h1>
<hr>


<sec:authorize access='hasAuthority("Admin")' >
<a style="position: absolute;left:670px;top:13px;padding:7px;" class="btn btn-primary text-light h4 mt-0" href="${pageContext.request.contextPath}/createMenu">Create Menu</a>
</sec:authorize>
<a style="position: absolute;left:790px;top:13px;padding:7px;" class="btn btn-primary text-light h4 mt-0" href="${pageContext.request.contextPath}/about">About us</a>
<a style="position: absolute;left:880px;top:13px;padding:7px;" class="btn btn-primary text-light h4 mt-0" href="${pageContext.request.contextPath}/Menu">My Menu</a>

<a style="position: absolute;left:975px;top:13px;padding:7px;" class="btn btn-primary text-light h4 mt-0" href="${pageContext.request.contextPath}/myCart">My Cart</a>
<a style="position: absolute;left:1060px;top:13px;padding:7px;" class="btn btn-primary text-light h4 mt-0" href="${pageContext.request.contextPath}/orderdItems">My Orders</a>


<a style="position: absolute;left:1158px;top:13px;padding:7px;" class="btn btn-primary text-light h4 mt-0" href="${pageContext.request.contextPath}/myContact">Contact us</a>


<form:form action="logout" method="post" style="position:absolute;left:1260px;top:12px;" class=" btn btn-primary text-light">
 <input type="submit" value="logout" class=" btn btn-primary" style="padding:1px;"/>
</form:form>



 

</body>
</html>