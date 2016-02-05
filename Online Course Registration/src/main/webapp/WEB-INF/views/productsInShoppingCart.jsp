<%-- 
    Document   : productList
    Created on : May 12, 2014, 9:09:39 PM
    Author     : Sandy
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table,th,td
            {
                border:1px solid black;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products in shopping cart</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="container">
        <h1>Products in shopping cart.</h1>
        <table style="width:400px">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Description</th>
            </tr>
            <c:forEach var="product" items="${productsInShoppingCart}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.productPrice}</td>
                    <td>${product.productDescription}</td>
<!--                    <td><a href="viewProduct/${product.id}">Edit</a></td>
                    <td><a href="deleteProduct/${product.id}">Delete</a></td>                    
                    <td><a href="addStockTable/${product.id}">Add Stock</a></td>-->
                </tr>
            </c:forEach>
        </table>
      </div>
    </body>
</html>
