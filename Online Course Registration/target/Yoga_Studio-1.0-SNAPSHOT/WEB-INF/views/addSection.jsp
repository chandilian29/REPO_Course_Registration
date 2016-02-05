<%-- 
    Document   : addSection
    Created on : May 15, 2014, 11:31:02 AM
    Author     : pAlahakoon
--%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
<!--        <meta http-equiv="Content-Type" context="/html; charset=UTF-8">-->
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <title>Add New Section</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Add New Section</h1>
        <form:form commandName="mySection" action="addSection" method="post">
            <form:hidden path="id" />
            <form:errors path="*" cssClass="errorblock" element="div" />

            <table>
                <tr>
                    <td>Section Code</td>
                    <td><form:input path="sectionId" /> </td>
                    <td><form:errors path="sectionId" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Section Name</td>
                    <td><form:input path="sectionName" /> </td>
                    <td><form:errors path="sectionName" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Number of Days</td>
                    <td><form:input path="noOfDays" /> </td>
                    <td><form:errors path="noOfDays" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Section Size</td>
                    <td><form:input path="sectionSize" /> </td>
                    <td><form:errors path="sectionSize" cssClass="error"/> </td>
                </tr>
            </table>
            <input value="Add Section" type="submit"/>

        </form:form>
    </body>
</html>