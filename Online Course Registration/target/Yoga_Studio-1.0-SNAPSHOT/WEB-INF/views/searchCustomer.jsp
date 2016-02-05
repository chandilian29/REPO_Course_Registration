<%-- 
    Document   : searchCustomer
    Created on : May 15, 2014, 9:27:16 PM
    Author     : lule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Customer Page</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form action="searchCustomerForm" method="post">
            <table>
                <tr>
                    <td>Customer Name</td>
                    <td><input type="text" name="customerName" /> </td>
                   
                </tr>
            </table>
            <input type="submit"/>
        </form>
    </body>
</html>
