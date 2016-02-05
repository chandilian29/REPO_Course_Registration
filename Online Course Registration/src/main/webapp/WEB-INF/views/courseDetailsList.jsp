<%-- 
    Document   : courseDetailsList
    Created on : 16/05/2014, 6:23:10 AM
    Author     : Jevin
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
        <title>Currently Available Courses</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Currently Available Courses</h1>
        <table style="width:400px">
            <tr>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Course Description</th>
                <th>Offerings per Time</th>
                <th>Add Sections</th>
                <th>View Sections</th>
                <th>Add Prerequisite Courses</th>
                <th>View Prerequisite Courses</th>
                <th>Edit Option</th>
                <th>Delete Option</th>                
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.courseDescription}</td>
                    <td>${course.offeringsPerTime}</td>
                    <td><a href="addSection/${course.id}">Add Sections</a></td>
                    <td><a href="viewSections/${course.id}">View Sections</a></td>                    
                    <td><a href="viewCourseExcpetCurrent/${course.id}">Add Prerequisites</a></td>                    
                    <td><a href="viewPrerequisiteCourses/${course.id}">View Prerequisites</a></td>                    
                    <td><a href="viewCourse/${course.id}">Edit</a></td>
                    <td><a href="deleteCourse/${course.id}">Delete</a></td>
                </tr>
            </c:forEach>
                 <p><a href="adminHome">Admin Home</a>
        </table>
        
     </body>
</html>


