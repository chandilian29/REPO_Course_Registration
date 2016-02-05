<%-- 
    Document   : submitBillingInfo
    Created on : May 18, 2014, 9:20:16 PM
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
        <h1>Please input your mailing and billing information!</h1>

        <form action="submitSuccess" method="GET">

            <table>
                <tr>
                    <td>Mailing Address</td>
                    <td><input path="courseId" /> </td>
                </tr>
                <tr>Credit card</td>
                    <td><input path="cardName" /> </td>
                </tr>
                <tr>
                    <td>Expiration Date</td>
                    <td><input path="expiration date" /> </td>
                </tr>
                <tr>
                    <td>VIN Number</td>
                    <td><input name="VinNumber" /> </td>
                </tr>
            </table>
            <input value="Submit" type="submit"/>
        </form>
</body>
</html>
