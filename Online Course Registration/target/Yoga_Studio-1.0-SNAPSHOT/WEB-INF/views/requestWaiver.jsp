<%-- 
    Document   : requestWaiver
    Created on : May 20, 2014, 11:28:51 AM
    Author     : Uguudei
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <title>Request a Waiver</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Request a Waiver</h1>
        <h3>Customer Name: ${customer.firstName}</h3>
        <form:form commandName="waiver" action="requestWaiver" method="post">
            <h3> 
                Section Name:<form:select path="status">                                
                                <form:options items="${sections}" itemValue="sectionName" itemLabel="sectionName"/>
                             </form:select>
            </h3>
            <table border="1">
                <tr>
                    <th>Waiver list</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="waiver" items="${waivers}">
                    <tr>
                        <td><h4>${waiver.section.sectionName}</h4></td>        
                        <td><a href="deleteWaiver/${waiver.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Waive"/>
        </form:form>
    </body>
</html>