<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout ItemList</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

 <script type="text/javascript">
    function myFunction() {
        var myCoupValue = document.getElementById("txtCode").value;
        document.getElementById("hiddenCoupon").value =myCoupValue;
        var totalPriceElement = document.getElementById("totalPrice");
        var originalPrice = parseFloat(totalPriceElement.innerText);

        if ((myCoupValue == 'GROCERY100')||(myCoupValue =='AB100')) {
            var newPrice = originalPrice - 100;
            totalPriceElement.innerText = newPrice.toFixed(2);
            
            document.getElementById("discountMessage").innerText = "Coupon applied! Rs100 discount.";
            
            document.getElementById("txtCode").value = "";
            document.getElementById("applyButton").disabled = true;
            
            document.getElementById("hiddenTotalPrice").value = newPrice.toFixed(2);
         
            
        } else {
            document.getElementById("discountMessage").innerText = "Invalid coupon code.";
        }
    }
</script>


<style>

 @keyframes animation1
 {
   10% {
    transform:scale(2,2);
   }
   
   40% {
	background-color:#C80036;
	transform:scale(1,1);
    }
    
    60%
    {
      transform :rotate(-35deg);
        transform :scale(0.2,0.2);
        transform :scale(0.5,0.5);
        
      
    }
    
    100% 
    {
    transform:rotate(35deg);
     transform :scale(0.4,0.8);
        transform :scale(0.7,0.8);
    }
 }

 #myHeading {
  animation-name :animation1;
  animation-duration :1s;
  animation-delay :0.5s;
  animation-iteration-count:infinite;
 }


#payButton:hover {
	background-color: 
}
</style>







</head>
<body class="container-fluid" >
<%@ include file="header2.jsp" %>
<b class="float-end text-light bg-success w-100 m-auto" style="position:relative;height:100px;background-color:red;"><span class="h2" style="float:right;margin-right:15px;color:yellow;font-family: lucidahandwritting;"> Hello ${myUsername }</span> </b>
<h1 id="myHeading" style="position: absolute;top:90px;left:500px;color:#E7D37F;" class="fw-bold"> Happy Shopping</h1>
<div style="position: relative;top:10px;"> 

<c:choose> 
  <c:when test="${length == 0 }">
  <i style="position: absolute;left:530px;top:150px;" class="text-primary fw-bold h1"> your cart is empty</i>

 <img src="${pageContext.request.contextPath}/resources/static/images/addtocart.png" alt="My Image" id="img1" width="400" style="position: absolute;left:500px;top:240px;overflow:hidden;" />

  </c:when>
  
  <c:otherwise >
  
  <p class="text-center text-success fw-bold "> You have <span style="color:blue;font-size:20px;"> ${length}   </span> items in your cart. </p>

  
    
   <table class="table  m-auto" style="position:absolute;top:140px;">
    <thead>
   <tr class="bg-primary"> 
    <th> Item Id </th>
    <th> Name  </th>
    <th> Base Price</th>
    <th> Cart Id </th>
    <th> Quantity</th>
    <th> Date </th>
    <th> Net Price </th>    
    <th> Remove</th>
   </tr>
    </thead>
    
    <tbody>
    
    <c:forEach var="listItems" items="${myCartItem }">
    <tr>
    <td> ${listItems.item_id } </td>
    <td> ${listItems.name } </td>
    <td> ${listItems.price }</td>
    <td> ${listItems.cart_id }</td>
    <td> ${listItems.quantity }</td>
    <td> ${listItems.cur_date }</td>
    <td> ${listItems.netprice }</td>
    
   
    <td> <a href="${pageContext.request.contextPath}/deleteCartItems/${listItems.cart_id}"> Remove From Cart</a></td>
    </tr>  
      </c:forEach>
    
    <tr>
    
    <td colspan="8">     
    <hr>
    </td>
    </tr>
    
    <tr> 
   <td> <input type="text" name="code" id="txtCode"/> <span class="text-primary"> Have coupon Code ?</span> </td>
     <td><input id="applyButton" type="submit" onclick="myFunction()" value="Apply" />      
     </td>
    </tr>
    
     <tr>
                            <td colspan="8">
                                <span id="discountMessage" class="text-success"></span>
                            </td>
                        </tr>
     
     
     
    <tr> 
     <td colspan="" class="text-light text-center bg-primary fw-bold h3 pl-0 pb-4" style="position:relative;left:950px;width:170px;border-radius:5px;"> Amount  <span style="color:yellow;font-size:22px;position:absolute;top:35px;left:0px;width:150px;">(in Rs)</span>  </td>
      <td class="text-success fw-bold h1" style="position: absolute;left:1150px;"><span id="totalPrice">${TotalPrice}</span></td>
    </tr>
    
    <tr> 
    <td colspan="8" class="text-center">
    <form:form method="POST" action="${pageContext.request.contextPath }/proceedToPayment" > 
       <input type="hidden" id="hiddenTotalPrice" name="totalPrice" value="${TotalPrice}" />
       
       <input type="hidden" id="hiddenCoupon" name="hiddenCoupon" value="${hiddenCoupon}"/>
       
    <input id="payButton" type="submit" value="Proceed to Payment" style="border: none;border-radius:10px;font-size:22px;" class="p-2 m-1 text-light fst-italic  btn btn-success border-none "/>
    </form:form>
    </td>
    </tr> 
   
    </tbody>
    
   </table>
   
   
   
   
  
  </c:otherwise>

</c:choose>




</div>

 
     

</body>
</html>