
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

<style>



</style>

<script>
$(document).ready(function (){
	$("#cart_message").fadeOut(2000);
	$("#cart_error").fadeOut(2000);
}
);
</script>

</head>
<body >
<%@ include file="header2.jsp" %>
   
   
     <c:choose>
     <c:when test="${param.success != null }">
     <i id="cart_message" class="text-success fw-bold  mt-5"> ${param.success} </i>
     </c:when>  
     <c:otherwise>  <i id="cart_error" class="text-danger fw-bold mt-5"> ${param.error }</i>   </c:otherwise>
    
     </c:choose>    
    
    
     
     <div style="position: absolute;left:80px;top:70px;">
       <c:forEach var="items" items="${itemsList}">
       
       <div  style="border:1px solid black;display:inline-block;margin:auto;width:290px;background-color:" class=" col col-3">
       
              <table class="table border" style="">
                  <tr>       
                 <td >   
                 <img style="border:1px solid lightgreen;" src="${pageContext.request.contextPath}${items.photo_path}" alt="myimage" width="100" height="100"/>     
                     <b class="text-danger">  ${items.name}  </b>   
             
                 </td>
         
                <td style="background-color:#F0DBAF;color:black;">  ${items.description}    </td>             
                  
                  </tr>  
             
             <tr>
           <td>
          <a  style="color:#49243E;font-weight:bold;text-decoration:none;" href="${pageContext.request.contextPath}/addToCart/${items.item_id}" >Add To Cart </a>
             </td>
              <sec:authorize access='hasAuthority("Admin")'>
             <td style="text-align:center;">  <a  href="${pageContext.request.contextPath }/editItems/${items.item_id}" class="text-decoration-none fw-bold" style="color:#216911;">Edit </a> </td>
          </sec:authorize>
           </tr>  
             
               
           <tr>
           <td style="background-color:#481E14;color:white;">          
            Price : ${items.price}
             </td>
               <sec:authorize access='hasAuthority("Admin")'>
             <td style="text-align:center;">  <a  href="${pageContext.request.contextPath }/deleteItems/${items.item_id}" class="text-decoration-none fw-bold" style="color:#216911;">Delete </a></td>
             </sec:authorize>
           </tr>     
                
        <tr> 
        
             <sec:authorize access='hasAuthority("Admin")'> 
              <td style="background-color:#750E21;color:white;">                    
             Quantity : ${items.max_quantity}                
                      </sec:authorize>
                      
         </td>  
            
        </tr>
        </table>
        
        
       
       </div>      
       
       </c:forEach>
     
     </div>
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
  
</body>
</html>






