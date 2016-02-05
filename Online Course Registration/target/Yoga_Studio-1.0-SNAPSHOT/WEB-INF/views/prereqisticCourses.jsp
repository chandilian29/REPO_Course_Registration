<%-- 
    Document   : prereqisticCourses
    Created on : May 18, 2014, 4:23:06 PM
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
        <title>Prerequisite Courses</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Prerequisite Courses.</h1>
        <table style="width:400px">
            <tr>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Course Description</th>
                <th>Offerings per Time</th>            
            </tr>
            <c:forEach var="course" items="${prereqisite}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.courseDescription}</td>
                    <td>${course.offeringsPerTime}</td>
                </tr>
            </c:forEach>
        </table>
        
     </body>
</html>