<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

 h3 {
font-family: 'Ink Free', sans-serif;
}
 

</style>
</head>

<body>
<%@ include file="header2.jsp" %>


 

 <div class="col col-3 float-start mx-5 mt-5" >
   <img src="${pageContext.request.contextPath}/resources/static/images/sidegrocery.png" alt="myimage" width="400" height="350"/> 
 
 </div>
 
 <div class="col col-7 float-end mt-5" >
 <h3 class="p-2 text-light fw-bold text-center" style="background-color: #524C42;width:160px;"> REGISTER</h3>
    <img src="${pageContext.request.contextPath}/resources/static/images/head1.png" alt="myimage" width="470" style="position:absolute;left:895px;" />

    <form:form action="process-registration" method="POST" modelAttribute="myRegister">
     
        <table class="table w-50" style="background-color: #32012F;">
      
            <tr >
               
                <td>
                    <div class="input-group w-75">
                        <span class="input-group-text"><i class="fa fa-user"></i></span>
                        <form:input path="username" cssClass="form-control " placeholder="Username" />
                    </div>
                </td>
            </tr>
            
            <tr>
               
                <td>
                    <div class="input-group w-75">
                        <span class="input-group-text"><i class="fa fa-lock"></i></span>
                        <form:password path="password" cssClass="form-control col-8" placeholder="Password"/>
                    </div>
                </td>
            </tr>
            
            <tr>
                
                <td>
                    <div class="input-group w-75">
                        <span class="input-group-text"><i class="fa fa-check-circle"></i></span>
                        <form:input path="enabled" cssClass="form-control col-8" />
                    </div>
                </td>
            </tr>
            
            <tr>
               
                <td>
                    <div class="input-group w-75">
                        <span class="input-group-text"><i class="fa fa-home"></i></span>
                        <form:input path="address" cssClass="form-control col-8" placeholder="Address" />
                    </div>
                </td>
            </tr>
            
            <tr>
              
                <td>
                    <div class="input-group w-75">
                        <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                        <form:input path="email" cssClass="form-control col-8 w-75" placeholder="Email"/>
                    </div>
                </td>
            </tr>
            
            <tr>
               
                <td>
                    <div class="input-group w-75">
                        <span class="input-group-text"><i class="fa fa-phone"></i></span>
                        <form:input path="mobile" cssClass="form-control col-8" placeholder="Mobile Number"/>
                    </div>
                </td>
            </tr>
            
            <tr>
                <td colspan="2" class="">
                    <input type="submit" value="Register" class="bg-warning text-light p-2 mt-2  h5 btn btn-block" />
                </td> 
            </tr>
        
        </table>
    </form:form>
</div>
 
 
 </body>
</html>