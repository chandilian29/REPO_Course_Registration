<%-- 
    Document   : CoursePrerequisite
    Created on : May 17, 2014, 6:28:08 PM
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
        <title>Available Courses to Add</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Available Courses to add as Prerequisites.</h1>
        <table style="width:400px">
            <tr>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Course Description</th>
                <th>Offerings per Time</th>
                <th>Add as Prerequisite</th>                
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.courseDescription}</td>
                    <td>${course.offeringsPerTime}</td>
                    <td><a href="addPrerequisiteToCourse/${course.id}">Add as Prerequisite</a></td>
                </tr>
            </c:forEach>
        </table>
     </body>
</html>