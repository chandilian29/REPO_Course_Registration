<%-- 
    Document   : sectionDetail
    Created on : May 15, 2014, 2:54:16 PM
    Author     : pAlahakoon
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Section Details</title>
         <link href="../resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <h1>Section Details</h1>
    <body>
        <form:form commandName="section" action="../viewSection/${section.id}" method="post">
            <form:hidden path="id" /> 
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>Section Code :</td>
                    <td><form:input path="sectionId" /> </td>
                    <td><form:errors path="sectionId" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Section Name :</td>
                    <td><form:input path="sectionName" /> </td>
                    <td><form:errors path="sectionName" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>No of Days :</td>
                    <td><form:input path="noOfDays" /> </td>
                    <td><form:errors path="noOfDays" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Section Size :</td>
                    <td><form:input path="sectionSize" /> </td>
                    <td><form:errors path="sectionSize" cssClass="error"/> </td>
                </tr>
            </table>
            <input type="submit" value="Update"/>
        </form:form>
    </body>
</html>
