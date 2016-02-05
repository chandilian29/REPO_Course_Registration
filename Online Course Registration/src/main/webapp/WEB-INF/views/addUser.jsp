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
        <title>Add a User</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form:form commandName="user" action="addUser" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>First Name</td>
                    <td><form:input path="firstName" /> </td>
                    <td><form:errors path="firstName" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><form:input path="lastName" /> </td>
                    <td><form:errors path="lastName" cssClass="error"/> </td>
                </tr>
                <tr>
            </table>
            <input type="submit"/>

        </form:form>
    </body>
</html>