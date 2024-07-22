<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">
<%@ include file="header2.jsp" %>
    <h1 class="bg-secondary w-100 h3 text-light" style="float: right;">
        Hello <span class=""> <%= (String) session.getAttribute("myUsername") %> </span>
    </h1>
    <br>
    <p class="fw-bold">Your Order Details are as follows. You can view your order bill by clicking on <mark style="background-color: yellow;">View Bill</mark> button.</p>

    <c:choose>
        <c:when test="${size == 0}">
            <p>You don't have any orders</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="orderItem" items="${orderItems}" varStatus="status">
                <c:if test="${status.first || orderItems[status.index - 1].order_id != orderItem.order_id}">
                    <h2>Order ID: ${orderItem.order_id}</h2>
                    <table class="table bg-success text-light mt-5 container">
                        <thead>
                            <tr class="bg-primary">
                                <th>Item ID</th>
                                <th>Item Name</th>
                                <th>Base Price</th>
                                <th>Quantity</th>
                                <th>Delivery Date</th>
                                <th>Total Price</th>
                            </tr>
                        </thead>
                        <tbody>
                </c:if>
                            <tr>
                                <td>${orderItem.item_id}</td>
                                <td>${orderItem.item_name}</td>
                                <td>${orderItem.price}</td>
                                <td>${orderItem.quantity}</td>
                                <td>${orderItem.delivery_date}</td>
                                <td>${orderItem.price * orderItem.quantity}</td>
                              
                            </tr>
                <c:if test="${status.last || orderItems[status.index + 1].order_id != orderItem.order_id}">
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="5" class="text-right">Total:</td>
                                <td>
                                    <c:set var="Total" value="0" />
                                    <c:forEach var="item" items="${orderItems}">
                                        <c:if test="${item.order_id == orderItem.order_id}">
                                            <c:set var="Total" value="${Total + (item.price * item.quantity)}" />
                                        </c:if>
                                    </c:forEach>
                                    ${Total}
                                </td>
                            </tr>
                            
                            <tr> 
                            
                              <td colspan="5" class="text-right"> Coupon Applied </td>
                              <c:choose>
                              <c:when test="${orderItem.couponApplied }">
                              <td colspan="5" class="text-right"> -100 </td>
                              </c:when>
                                <c:otherwise>
                                
                                 <td>  0 </td>
                                </c:otherwise>
                              </c:choose>
                           
                            </tr>
                            
                            <tr>
                             <td colspan="5" class="text-right text-light border border-right" style="background-color: #131842;"> Grand Total :</td>
                           <c:choose>
                              <c:when test="${orderItem.couponApplied }">
                              
                                  <td colspan="5" class="text-right" style="background-color: #131842;">   ${Total -100 } </td>
                               
                              </c:when> 
                              
                              <c:otherwise>
                              <td colspan="5" class="text-right" style="background-color: #131842;"> 
                                ${Total}
                               </td>
                              
                              </c:otherwise>
                            
                            </c:choose>
                            
                            </td>
                             </tr>
                             
                             <tr> 
                              
                            <form action="${pageContext.request.contextPath}/billing" method="GET">
    <input type="hidden" name="order_id" value="${orderItem.order_id}">
    <button type="submit" class="btn btn-warning p-2" style="width: 125px; border-radius: 10px;">View Bill</button>
</form>
    
                             </tr>
                            
                        </tfoot>
                    </table>
                </c:if>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>
