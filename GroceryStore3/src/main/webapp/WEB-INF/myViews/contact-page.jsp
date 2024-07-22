<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
      <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

<style>
li {
list-style-type: none;
}
</style>
</head>
<body class="container-fluid">
<%@ include file="header2.jsp" %>
<h4 class="text-center text-light mt-3 bg-primary"> Welcome to Fruit-mart contact page</h4>
<hr>
<div class="">
<p class="text-center"> For any query/enquiry you can reach to us on the provided help-line number. </p>
<ul class="text-center">
<li> <b>Mobile Number :  </b> +91-8081562321 </li>
<li> <b> Telephone No :</b>   +011-7427802 </li>
</ul>

<p class="mt-5 text-center bg-warning text-decoration-underline"> You can also reach us on our official email : </p>
 
 <p class="text-center"> <strong> thebestfruitmart@gmail.com</strong> </p>
 <p class="text-center"> <strong> developer@fruitmart.com</strong> </p>

<hr>
<h1> Other Authorities : </h1>
<table class="table border">
<tr>
<td class="text-center fw-bold"> Admin :  </td>
<td> +91-8086521452</td>
</tr>
<tr> 
<td  class="text-center fw-bold"> Site Manager</td>
<td> +91-9452856145 </td> 
</tr>

<tr> 
<td  class="text-center fw-bold"> Customer-care Unit</td>
<td> +91-9198562325 </td> 
</tr>
<tr> 
<td  class="text-center fw-bold"> Toll-free</td>
<td> 1800-235-235-256 </td> 
</tr>

</table>
</div>
</body>
</html>