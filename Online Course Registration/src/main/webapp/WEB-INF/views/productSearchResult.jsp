<%-- 
    Document   : productSearchResult
    Created on : May 15, 2014, 9:01:00 PM
    Author     : lule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>product search result(F)</h1>
         <table style="width:400px">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Description</th>
            </tr>

                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.productPrice}</td>
                    <td>${product.productDescription}</td>
<!--                    <td><a href="purchaseProduct/${product.id}">CheckOut</a></td>-->
                </tr>
        </table>
    </body>
</html>
