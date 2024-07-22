<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paymnt Confirmed</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid  mt-5">
<%@ include file="header2.jsp" %>
<h1 style="background-color: darkgreen;width:80%; margin:auto;height:220px;"> <p style="position:absolute;top:130px;left:200px;color:white"> Hello ${user} your payemnt of<span style="color: yellow;font-weight:bold;"> &#8377; ${payment} </span> is confirmed. </p></h1>

<section style="text-align: center;">
<h1 style="font-family: Papyrus;margin-top:100px;"> You have successfully placed your Order .</h1>  <br>
<span style="position:relative;bottom:-24px;color:#008170;text-decoration:underline;">Go to Order</span>  <br> <br>
 <a href="${pageContext.request.contextPath }/orderdItems" class="bg-success text-light p-2 text-decoration-none btn"> Order Details</a>
</section>
</body>
</html>