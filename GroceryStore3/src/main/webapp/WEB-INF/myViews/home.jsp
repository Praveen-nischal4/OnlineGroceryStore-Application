<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
       <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyApp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid m-auto">
<%@ include file="header2.jsp" %>

 <sec:authorize access="hasAuthority('Admin') and !hasAuthority('User')">
<img src="${pageContext.request.contextPath}/resources/static/images/image4.jpg" alt="My Image" id="img1" 
 style="width:1338px;height:550px;overflow: hidden;"/>
</sec:authorize>
 
 <sec:authorize access="hasAuthority('User') and !hasAuthority('Admin')">
<img src="${pageContext.request.contextPath}/resources/static/images/userhome.png" alt="My Image" id="img1" 
 style="width:1338px;height:550px;overflow: hidden;"/>
</sec:authorize>
 
<sec:authorize access="hasAuthority('Admin') and hasAuthority('User')">
<img src="${pageContext.request.contextPath}/resources/static/images/homeimage.png" alt="My Image" id="img1" 
 style="width:1338px;height:550px;overflow: hidden;"/>
 </sec:authorize>

</body>
</html>