<h1 align="center"> GROCERY STORE Web Application</h1>

<p> ➡️ Grocery Store is a web application built using the Spring Framework and MySQL database. It is designed to provide a realistic e-commerce experience for purchasing fruits, vegetables, drinks, and more. The application includes a comprehensive cart and billing module, simulating the 
  entire shopping process from selection to checkout. Additionally, users can download their bill as a PDF, adding to the convenience and realism of the shopping experience.
To ensure security, the application utilizes Spring Security for authentication and authorization.</p>

## Features of Grocery Store

###  User Authentication and Authorization
- Secure login and registration module is written uisng spring security considering authorities as Admin  User

### Menu
- A variety of items including vegetables, fruits, and drinks are listed with their prices.

### Shopping Cart
- Add to Cart: Users can add products to their shopping cart.
- Update Cart: Modify quantities or remove items from the cart.
- Cart Summary: Display a summary of items in the cart with total price.

### Discount Coupons
- Apply Coupons: Enter coupon codes to receive discounts on orders.
- Coupon Validation: Validate coupon codes and apply discounts.

### Checkout and Payment
- Manual Payment Confirmation: Click to confirm payment without actual payment gateway integration (dummy implementation).
-  Order Generation: After payment confirmation, an order is generated and a unique order ID is provided.

### Billing and Invoicing
- Invoice Generation: Generate and download invoices as PDFs.

### Admin Panel
- Product Management: Add, edit, and delete products (Menu items) including vegetables, fruits, and drinks.


## Installation
- Download the Code
  -  Download the project code and unzip it.
    
- Install an IDE
   - Ecllipse <a href="https://www.eclipse.org/downloads/"> Ecllipse </a>
   - IntelliJ <a href="https://www.jetbrains.com/idea/"> IntelliJ </a>
   
- Import the Project into IDE
   - Open your chosen IDE.
   - Import the unzipped project into the IDE.
 
- Update Maven
   - In the IDE, perform a Maven update to ensure all dependencies are correctly configured.

- Create the Database
   - Set up a database using either Workbench or MySQL Server.
   - Follow the schema instructions provided in the Schema section of this document to configure the database.

- Run the Project
   - Deploy and run the project on your local server.
 
## **Technology Used**

| Frontend | Backend | Databse |
| --- | --- | --- |
| Html, css, Boostrap, jsp | Spring-framework, JDBC template | Mysql |


## Database Schema

[![](https://mermaid.ink/img/pako:eNqVld9vmzAQx_8Vy89JRBLyA97aVZGmalqlai9TpOiKr9SSsZkxW1mS_322CUmBLGM8mbsP5_ve2ceeJoohjSnqBw6phmwriX2-FajJvl6759loLlNSWrOEDMnTI9nSJ80z0BV5xGpLe2wORfFLaXZxcGkISngRyHo0MKaxKHp2zIALUpuPW1kvPoE2H7NzgRNr23F2MzPHcYOZ4zaO2yiNPJXXuB8lSMNNdbE-gEGSlHrH7OLvpekH9lhHwmebRldCk9qA4iY2hVTpqudwKVyMG6HAkFzzpJ8wwyLRPDdcyf8R0045g_ddu1JnhV81Q110NSpnHShycBZN7__FDen9aW-PDijmjaNSS20fFu9gKPhP1NX1g3T29q7EvVICQZJElbmSd3ku-JWb5G9Mz5qpFy6w06J7LoRzdnpkSTGwRR6VqiPQW9viWr2_Vf-2SDeduh0wyoDoKPHz6nAYj9W-ng6x3SEDCSkWTXRvd8xhX18_xyRKGuDyDH0MdDrBDssFJFcitSEuE1GyC3ZyncCm2I5MUaK29bEoHdEMte0Zs1PYN2JLzRvag0cdyfAVSmFcyKNFoTTquZIJjY0ucUS1KtM3Gr-CKOxbmbuinwZ5g-Qgabyn7zSOJtEiWIdBNA2C9WIRLke0ovE4moWTcDWbr5bT-dwuZscR_a2UDTCbrBfrxXwWhMFyHU3DaDWiyLhR-kv91_A_D7_Fd_-B2_H4B59-7XM?type=png)](https://mermaid.live/edit#pako:eNqVld9vmzAQx_8Vy89JRBLyA97aVZGmalqlai9TpOiKr9SSsZkxW1mS_322CUmBLGM8mbsP5_ve2ceeJoohjSnqBw6phmwriX2-FajJvl6759loLlNSWrOEDMnTI9nSJ80z0BV5xGpLe2wORfFLaXZxcGkISngRyHo0MKaxKHp2zIALUpuPW1kvPoE2H7NzgRNr23F2MzPHcYOZ4zaO2yiNPJXXuB8lSMNNdbE-gEGSlHrH7OLvpekH9lhHwmebRldCk9qA4iY2hVTpqudwKVyMG6HAkFzzpJ8wwyLRPDdcyf8R0045g_ddu1JnhV81Q110NSpnHShycBZN7__FDen9aW-PDijmjaNSS20fFu9gKPhP1NX1g3T29q7EvVICQZJElbmSd3ku-JWb5G9Mz5qpFy6w06J7LoRzdnpkSTGwRR6VqiPQW9viWr2_Vf-2SDeduh0wyoDoKPHz6nAYj9W-ng6x3SEDCSkWTXRvd8xhX18_xyRKGuDyDH0MdDrBDssFJFcitSEuE1GyC3ZyncCm2I5MUaK29bEoHdEMte0Zs1PYN2JLzRvag0cdyfAVSmFcyKNFoTTquZIJjY0ucUS1KtM3Gr-CKOxbmbuinwZ5g-Qgabyn7zSOJtEiWIdBNA2C9WIRLke0ovE4moWTcDWbr5bT-dwuZscR_a2UDTCbrBfrxXwWhMFyHU3DaDWiyLhR-kv91_A_D7_Fd_-B2_H4B59-7XM)

## Billing Details :
![mybill](myprojectbill.png)

## API Endpoints

### General Endpoints

| End Points | Links |
| --- | --- |
| Login Page | /Myapplication-Default/myLoginPage |
| Home Page | /Myapplication-Default/ |
| Menu | /Myapplication-Default/Menu |
| Add Item to Cart | /Myapplication-Default/addToCart/7 |
| View Cart | /Myapplication-Default/myCart |
| Checkout | /Myapplication-Default/checkout |
| Payment Confirmation | /Myapplication-Default/paymentConfirmation |
| Order Details | /Myapplication-Default/orderdItems |
| View Bill | /Myapplication-Default/billing?order_id=Gro7652 |

 ### Admin Endpoints for Item Management 

 | End Points | Links |
 | --- | --- |
| Create Menu | /Myapplication-Default/createMenu |
| Add Item | /Myapplication-Default/addItems |
| Edit Item | /Myapplication-Default/editItems/1 |
| Delete Item | /Myapplication-Default/deleteItems/32 |
 
