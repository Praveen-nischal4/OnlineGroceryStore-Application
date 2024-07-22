<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

<style>

h3 {
font-family: 'Ink Free', sans-serif;
}

h4 {
  font-family: 'Segoe Print',sans-serif;
  }
</style>


</head>
<body class="container-fluid text-center" >

<%@ include file="header2.jsp" %>


<div class="col col-3 m-auto border mt-5" style="background-color: #32012F;">
<h3 class="p-2 text-light fw-bold" style="background-color: #524C42;"> LOGIN</h3>

<form:form method="post"  action="process-Log" >
        <div class="form-group mx-5">
            <label >Username</label>
            <div class="input-group w-100">
                <span class="input-group-text"><i class="fa fa-user"></i></span>
               <input type="text" name="username" placeholder="Your Username" class="form-control p-2"/> 
            </div>
        </div>

        <div class="form-group mx-5">
            <label >Password</label>
            <div class="input-group w-100">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
              <input type="password" name="password" placeholder="Your Password" class="form-control p-2  "/>
            </div>
        </div>

          
            
        <div class="form-group text-center mt-3 mb-3">
            <button type="submit" class="btn fw-bold" style="background-color: #A87C7C;">LOGIN</button>
        </div>    
        
    </form:form>

</div>


<!-- Error in custom login form  -->

<c:if test="${param.error !=null}">
 <i class="text-danger mt-5"> Invalid login or password</i>
</c:if>

<!-- After successful logout custom message  -->

<c:if test="${param.logout !=null}">
 <i class="text-success"> Successfully Logout!!!!!!! You can sign in again.</i>
</c:if>


<h4 class="text-primary">Have you not registered yet ? </h4> <a href="${pageContext.request.contextPath }/userRegistration">Register Here </a> 
 <br>
</body>
</html>