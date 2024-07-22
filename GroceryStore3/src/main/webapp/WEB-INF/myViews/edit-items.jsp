<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Items</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid border">
<%@ include file="header2.jsp" %>
 <h1 class="bg-success text-light"> Edit Item Record</h1>
 
 <form:form action="${pageContext.request.contextPath}/updateItems" method="POST" modelAttribute="itemsdto">
   <table class="table table-primary table-striped table-hover table-active w-50 m-auto">
   <tr>
   <td> <form:hidden path="item_id" name="item_id"/> </td>
   </tr>
   
   <tr> 
   <td> <form:label path="category">Category</form:label> </td>
   <td> <form:input path="category" name="category" type="text"/> </td>
   </tr>
   
   <tr>
   <td> <form:label path="name"> Name </form:label> </td>
   <td> <form:input path="name" name="name" type="text"/> </td>
   </tr>
   
   <tr> 
   <td> <form:label path="description">Description</form:label> </td>
   <td> <form:input path="description" name="description" type="text"/> </td>
   </tr>
   
   <tr> 
   <td> <form:label path="price">Price</form:label> </td>
   <td> <form:input path="price" name="price" type="text"/> </td>
   </tr>
   
   <tr>
   <td> <form:label path="max_quantity">MaxQuantity</form:label> </td>
   <td> <form:input path="max_quantity" name="max_quantity" type="text"/> </td>
   </tr>
   
    <tr> 
    <td colspan="2" class="text-center"> <input type="submit" value="UPDATE" class="btn btn-block btn-success"/> </td>
    </tr>
   </table> 
 </form:form>
 

</body>
</html>