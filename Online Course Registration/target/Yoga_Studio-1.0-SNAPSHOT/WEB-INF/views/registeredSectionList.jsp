<%-- 
    Document   : courseList
    Created on : May 14, 2014, 2:19:47 PM
    Author     : Yonas
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
        <title>Course List</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Registered Sections List</h1>
        <table style="width:400px">
            <tr>
                <th>Course Number</th>
                <th>Course Name</th>
                <th>Section ID</th>
                <th>Section Name</th>
                <th>Instructor</th>
                <th>Delivery Time:</th>
            </tr>
            <c:forEach var="section" items="${sections}">
                <tr>
                    <td>${section.course.courseId}</td>
                    <td>${section.course.courseName}</td>
                    <td>${section.sectionId}</td>
                    <td>${section.sectionName}</td>
                    <td>${section.faculty}</td>
                    <td>${section.sectionTime}</td>
                    <td><a href="dropSection/${section.sectionId}">Drop section</a></td>                   
                </tr>
            </c:forEach>
        </table>

    </body>
</html>