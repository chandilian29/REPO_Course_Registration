<%-- 
    Document   : sectionList
    Created on : May 15, 2014, 3:04:44 PM
    Author     : pAlahakoon
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table,th,td
            {
                border:1px solid black;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of already registered sections</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>List of already registered sections</h1>
        <table style="width:400px">
            <tr>
                <th>Section Code</th>
                <th>Section Name</th>
                <th>No of Days</th>
                <th>Section Size</th>
                <th>Options</th>
            </tr>
            <c:forEach var="section" items="${sections}">
                <tr>
                    <td>${section.sectionId}</td>
                    <td>${section.sectionName}</td>
                    <td>${section.noOfDays}</td>
                    <td>${section.sectionSize}</td>
                    <td><a href="dropSection/${section.sectionId}">Drop section</a></td>
<!--                    <td><a href="deleteSection/${section.id}">Delete</a></td>-->
                </tr>
            </c:forEach>
        </table>
<p><a href="customerHome">Customer Home</a>
    </body>
</html>
