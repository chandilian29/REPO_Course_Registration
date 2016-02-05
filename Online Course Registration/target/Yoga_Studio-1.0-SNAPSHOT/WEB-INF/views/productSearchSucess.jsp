<%-- 
    Document   : productSearchSucess
    Created on : May 18, 2014, 2:16:07 PM
    Author     : cArunagirinathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Products..</h1>
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
                    <td><a href="addProductToCart/${product.id}">Add to Cart</a></td>
                </tr>
        </table>
    </body>
</html>
