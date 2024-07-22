<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
       <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Update</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<Style>

h3 {
font-family: 'Ink Free', sans-serif;
}

  .input-group .form-control {
        margin-bottom: 0px;
    }

.mystyle2
{
color:white;
}
</Style>
</head>
<body>
<%@ include file="header2.jsp" %>

<div class="col col-3 m-auto border mt-5" style="background-color: #32012F;">
<h3 class="p-2 text-light" style="background-color: #524C42;"> Change Password</h3>

<form:form method="post" modelAttribute="updatepassword" action="updatePassword" cssClass="mystyle2">
       

        <div class="form-group mx-5">
            <form:label path="password">Current Password</form:label>
            <div class="input-group w-100">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
                <form:password path="password" cssClass="form-control" name="password" placeholder="Current Password"/>
            </div>
        </div>

           <div class="form-group mx-5">
            <form:label path="newPassword">New Password</form:label>
            <div class="input-group w-100">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
                <form:password path="newPassword" cssClass="form-control" name="newPassword" placeholder="New Password"/>
            </div>
            </div>
            
            <div class="form-group mx-5">
            <form:label path="retypePassword">Retype Password</form:label>
            <div class="input-group w-100">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
                <form:password path="retypePassword" cssClass="form-control" name="retypePassword" placeholder="Retype Password" />
            </div>
            </div>
            
            
        <div class="form-group text-center mt-3 mb-3">
            <button type="submit" class="btn fw-bold" style="background-color: #A87C7C;">UPDATE</button>
        </div>
    </form:form>
</div>

</body>
</html>