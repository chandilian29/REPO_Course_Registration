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
        <div id="header"> <h1>Currently available Courses.</h1></div>

        <table style="width:400px">
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Course Description</th>
                <th>Course Prerequisites</th>
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.courseDescription}</td>
                    <td>
                        <table style="width:400px">
                            <tr>
                                <th>Course ID</th>
                                <th>Course Name</th>
                                <th>Course Description</th>

                            </tr>
                            <c:forEach var="preCourse" items="${course.prerequestic}">
                                <tr>
                                    <td>${preCourse.courseId}</td>
                                    <td>${preCourse.courseName}</td>
                                    <td>${preCourse.courseDescription}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                    <td><a href="showSections/${course.courseId}">Show sections</a></td>

                </tr>
            </c:forEach>
        </table>
 <p><a href="customerHome">Customer Home</a>
    </body>
</html>