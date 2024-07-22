<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Bill</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

<style>

 @keyframes byeAnimation
 {
   10% {
 
   color:blue;
  
   }
   
   40% {
	
   color:red;
    }
    
    60%
    {
      
       color:violet;
        
      
    }
    
    100% 
    {
   
   color:orange;
    }
 }
</style>

</head>
<body class="container-fluid">
<%@ include file="header2.jsp" %>
<div class="col col-8 float-start">
<section class="container" style="margin-top:50px;background-color: #F6CDC7;height:auto;width:650px;color:purple;">
<p class="fw-bold" style=""> Reg.No :A1234 </p> 
<p class="float-end fw-bold" style="position:absolute; margin-top: -40px;left:650px;"> Bill No : ${billing. bill_no}</p> 
<h1 class="fw-bold " style="position:absolute;top:132px;left:300px;"> GROCERY STORE</h1>
<span class="text-center" style="position:relative;top:7px;"> <h6>23/1234, Saint Rockers road,Banglore -2002125</h6></span>
<hr>
<p class="fw-bold" style="font-size: 16px;position:relative;top:-15px;">This is a computerized generated bill copy for customer,please keep for future use. </p>

<div>

 <table>
 <tr> 
 <td> Name : &nbsp; &nbsp; &nbsp;</td> <td>  ${sessionScope.myUsername} </td>  
 <td> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;</td>

   <td> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;</td>

 <td> Email : </td> <td>${sessionScope.EMAIL}</td>      
</tr>

<tr> 
 <td> Bill Id : </td> 
  <td> ${billing.bill_id} </td>   
  
  <td> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;</td>
 <td> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;</td>
 
 <td> Mobile : </td>
 <td> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; ${sessionScope.MOBILE }</td>
 </tr>
  </table>
</div>

<div> 
<table class="table mt-3 border">
 <thead>
 <tr> 
  <th class=" fw-bold"> S.No </th>
  <th class=""> Items </th>
  <th class=""> Qty </th>
  <th class=""> Price</th>
  <th>  T.Price </th>
 </tr>
 </thead>
 
 <tbody>
  <c:forEach var="myItem" items="${OrderItems }" varStatus="status">
  <tr> 
     <td> ${status.index +1 } </td>
     <td> ${myItem.item_name } </td>
     <td> ${myItem.quantity } </td>
     <td> ${myItem.price }</td> 
     <td> ${myItem.price * myItem.quantity}</td>
      
  </tr>
  </c:forEach>
  
  
  <tr> 
   <td colspan="3" class="text-right fw-bold" style="position:relative;left:400px;"> Total : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${total } </td>  
  </tr>
 
 <tr> 
   <td colspan="3" class="text-right fw-bold" style="position:relative;left:400px;"> Discount  </td>  
   <c:choose> 
    <c:when test="${billing.coupon_code }">
     <td style="position:relative;left:90px;"> -100.0 </td>
     </c:when>
   <c:otherwise>
   <td colspan="2" style="position:relative;left:90px;"> 0 </td>
   </c:otherwise>
   </c:choose>
  </tr>
  
  <tr> 
    <td colspan="3" class="text-right fw-bold" style="position:relative;left:400px;"> G.Total :  </td>
   <c:choose>
    <c:when test="${billing.coupon_code }">
     <td style="position:relative;left:90px;"> ${total -100 } </td>
    </c:when>
    <c:otherwise>
      <td style="position:relative;left:90px;"> ${total } </td>
    </c:otherwise>
   </c:choose>
  </tr>
   
   <tr> 
<td colspan="6">Please note : </td>
</tr>
   
   <tr> 
<td colspan="4"> 
<ul style="font-weight: 400"> 
<li> Items once sold will not be return. </li>
<li> you are allowed to purchase maximum of  3- unit/kg of items at a time.</li>
<li> In case of Items out of stock return,it will not converted to other items. </li>
<li> Fo any query checkout our contact page. <a href="${pageContext.request.contextPath }/myContact">click here</a> </li>
<li> We will dispatch you legal bill with every order refuse if bill not found</li>
<li> Our delivery partners do not ask for money,its your wish u may give tip to them.</li>
<li> You can follow us on our official <a href="#">facebook </a>and <a href="#">instagram</a> page.</li>
 
</ul>
</td>
</tr>
<tr>
<td colspan="9" class="fw-bold" style="position:relative;left:400px;"> Authority Signature </td> 
</tr>
 </tbody>
</table>
</div>

</section>
</div>


<div class="col col-4 float-end ">
 <a href="${pageContext.request.contextPath }/downloadBill?order_id=${billing.order_id}" class="text-decoration-none p-2 bg-primary text-light" style="width:200px;border-radius:7px;height:auto;position:absolute;top:390px;left:1028px;padding:13.5px;font-size:18px;">Download Bill as PDF</a>


<p id="bye-text" style="position: absolute;top:430px;left:1030px;font-size:24px;animation-name:byeAnimation;animation-duration:3s;animation-iteration-count:infinite;"> Thank you For Shopping </p>
</div>
</body>
</html>