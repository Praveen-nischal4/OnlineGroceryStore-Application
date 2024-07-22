<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddToCart</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid " >
<%@ include file="header2.jsp" %>
<p class="fw-bold mt-3 p-2 text-light" style="background-color: #6C946F;"> ** Max 3unit- Items sold in drzones or 3Kg-items sold in kg </p>

<form:form  method="POST" action="${pageContext.request.contextPath}/viewCart" modelAttribute="cartdto" >
 <table class="table w-50 m-auto text-center" style="background-color:#E7D4B5;">
 <tr > 
  <td ><form:label path="item_id">Item Id :</form:label> </td>
  <td> <form:input path="item_id" name="item_id" readonly="true" /> </td>
 </tr>
 
 <tr class="text-center"> 
 <td><form:label path="quantity"> Quantity</form:label> </td>
 <td> <form:input path="quantity" type="number" name="quantity" min="1" max="3" /> </td>
 </tr>
 
 <tr> 
 <td colspan="2" class="text-center" ><input type="submit" value="ADD To Cart" class="btn btn-block btn-success p-2 mt-5"/> </td> 
 </tr>
 
 </table>

</form:form>
</body>
</html>