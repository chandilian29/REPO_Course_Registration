<%-- 
    Document   : addUser
    Created on : May 4, 2014, 2:26:51 PM
    Author     : Sandy
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1> User Login</h1>
        <form  action="myLogin" method="post">
            <table>
                <tr>
                    <td>User Name</td>
                    <td><input type="text" name="uname" /> </td>
                   
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pwd" /> </td>
                    
                </tr>
                <tr>
                    <td>User Type</td>
                    <td>
                        <select name="usertype">  
                            <option value="admin">ADMIN</option>  
                            <option value="faculty">FACULTY</option>  
                            <option selected="selected" value="customer">CUSTOMER</option>
                        </select>
                    </td>

                </tr>
                <tr>
            </table>
            <input type="submit"/>
        </form>
    </body>
</html>