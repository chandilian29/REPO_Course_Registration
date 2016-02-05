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
        <title>Section List</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="header"><h1>Currently available Sections for Course ID: ${section.course.courseId}.</h1></div>
        <table style="width:400px">
            <tr>
                <th>Section ID</th>
                <th>Section Description</th>
                <th>Number of days</th>
                <th>Section Capacity:</th>
            </tr>
            <c:forEach var="section" items="${sections}">
                <tr>
                    <td>${section.sectionId}</td>
                    <td>${section.sectionName}</td>
                    <td>${section.noOfDays}</td>
                    <td>${section.sectionSize}</td>

                    <td><a href="registerForSection/${section.sectionId}">Register for this section</a></td>
                </tr>
            </c:forEach>
        </table>
<!-- <p><a href="customerHome">Customer Home</a>-->
<!--        To see available courses <a href="courseList">Click here</a></br>
        To see available sections <a href="sectionListForRegistration">Click here</a></br>        
        To see already registered sections <a href="listRegisteredSections">Click here</a></br>-->

    </body>
</html>