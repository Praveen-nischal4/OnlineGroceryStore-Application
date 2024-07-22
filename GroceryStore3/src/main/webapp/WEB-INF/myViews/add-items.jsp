<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Items</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

<style>
tr:nth-child(even) {
background-color: #FFE0B5;	
}

tr:nth-child(odd) {
background-color: #F8C794;	
}
</style>
</head>
<body class="container-fluid">
<%@ include file="header2.jsp" %>
<h1 class="mt-3 text-success w-25 fw-bold"> ADD ITEMS</h1>

<form:form action="${pageContext.request.contextPath}/add" modelAttribute="itemsdto" method="post" enctype="multipart/form-data">
  
    <table class="table w-50 m-auto">
        <tr>
            <td><form:label path="category">Category</form:label></td>
            <td><form:input path="category" name="category" type="text"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" name="name" type="text"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description" name="description" type="text"/></td>
        </tr>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price" name="price" type="text"/></td>
        </tr>
        <tr>
            <td><form:label path="max_quantity">Max Quantity</form:label></td>
            <td><form:input path="max_quantity" name="max_quantity" type="text"/></td>
        </tr>
        <tr>
            <td><form:label path="photo">Items Image</form:label></td>
            <td><form:input path="photo" name="photo" type="file"/></td>
        </tr>
        
      
        
        <tr>
            <td colspan="2" class="text-center"><input type="submit" value="ADD ITEMS" class="btn btn-block btn-success fw-bold mt-2"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>