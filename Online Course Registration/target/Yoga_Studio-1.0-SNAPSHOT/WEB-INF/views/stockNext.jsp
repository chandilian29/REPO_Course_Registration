<%-- 
    Document   : addStock
    Created on : May 13, 2014, 4:12:18 PM
    Author     : Sandy
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock Details</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <h1>Stock Details</h1>
    <body>
         <form action="stockNext" method="post">
            <table>
                <tr>
                    <td>Quantity</td>
                    <td><input type="text" name="quantity" /> </td>
                   
                </tr>
                <tr>
            </table>
            <input type="submit"/>
             <p><a href="adminHome">Admin Home</a>
        </form>
    </body>
</html>
