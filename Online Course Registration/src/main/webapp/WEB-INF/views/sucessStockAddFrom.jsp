<%-- 
    Document   : sucessStockAddFrom
    Created on : May 13, 2014, 8:56:11 PM
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
        <title>Current Products</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Currently available Products..</h1>
        <form:form commandName="mystock" action="addStockTable" method="post">
        <table style="width:400px">
            <tr>
               <td>Product Name</td>
                  <td><form:input path=${proName} /> </td>
            </tr>
            <tr>
                    <td>Quantity</td>
                    <td><form:input path="quantity" /> </td>

            </tr>
        </table>
       <input type="submit"/>
        <p><a href="adminHome">Admin Home</a>
       </form:form>

    </body>
</html>