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
              <title>Create New Account</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Create New Account</h1>
        <form:form commandName="myuser" action="addMyUser" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>First Name</td>
                    <td><form:input path="firstName" /> </td>
                    <td><form:errors path="firstName" cssClass="error"/> </td>

                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><form:input path="lastName" /> </td>

                </tr>
                <tr>
                    <td>Address</td>
                    <td><form:input path="address" /> </td>

                </tr>
                <tr>
                    <td>TelePhone Number</td>
                    <td><form:input path="phoneNo" /> </td>

                </tr>
                <tr>
                    <td>User Name</td>
                    <td><form:input path="uname" /> </td>

                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:input path="password" /> </td>

                </tr>
                <tr>
                    <td>User Type</td>
                    <td>
                        <form:select path="usertype">  
                            <form:option value="admin">ADMIN</form:option>  
                            <form:option value="faculty">FACULTY</form:option>  
                            <form:option selected="selected" value="customer">CUSTOMER</form:option>
                        </form:select>
                    </td>

                </tr>
                <tr>
            </table>
            <input type="submit"/>

        </form:form>
    </body>
</html>