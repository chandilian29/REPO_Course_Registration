<%-- 
    Document   : searchProduct
    Created on : May 18, 2014, 1:54:50 PM
    Author     : cArunagirinathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Product</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
       <form  action="customerSearchProduct" method="post">
            <table>
                <tr>
                    <td>Product Name</td>
                    <td><input type="text" name="productName" /> </td>
                </tr>
                <tr>
            </table>
            <input type="submit"/>
       </form>
    </body>
</html>
