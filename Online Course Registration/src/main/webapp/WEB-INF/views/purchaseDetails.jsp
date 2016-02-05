<%-- 
    Document   : purchaseDetails
    Created on : May 18, 2014, 2:39:07 PM
    Author     : cArunagirinathan
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
         <form  action="" method="post">
            <table>
                <tr>
                    <td>Card Type</td>
                    <td>
                        <select name="cardtype">  
                            <option selected="selected" value="visa">VISA</option>  
                            <option value="credit">CREDIT</option>
                        </select>
                    </td>

                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><input type="text" name="quantity" /> </td>
                   
                </tr>
                
            </table>
            <input type="submit"/>
        </form>
    </body>
</html>
