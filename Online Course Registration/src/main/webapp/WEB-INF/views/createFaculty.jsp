<%-- 
    Document   : createCustomer
    Created on : May 16, 2014, 11:28:51 AM
    Author     : Sandy
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a New Faculty</title>
       <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Create a New Faculty</h1>
        <form:form commandName="faculty" action="createFaculty" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="firstName" /> </td>
                    <td><form:errors path="firstName" cssClass="error"/> </td>

                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="lastName" /> </td>

                </tr>
                <tr>
                    <td>Address:</td>
                    <td><form:input path="address" /> </td>

                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><form:input path="phoneNo" /> </td>

                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="username" /> </td>
                    <td><form:errors path="username" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input path="password" type="password"/> </td>
                    <td><form:errors path="password" cssClass="error"/> </td>
                </tr>           

            </table>
            <input type="submit"/>

        </form:form>
        <p><a href="adminHome">Admin Home</a>
    </body>
</html>