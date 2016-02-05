<%-- 
    Document   : customerSearchResult
    Created on : May 15, 2014, 9:29:43 PM
    Author     : lule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="container">
            <h1>Customer List</h1>
            <table style="width:400px">
                <tr>
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>Phone No</th>
                </tr>

                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.address}</td>
                    <td>${customer.phoneNo}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
