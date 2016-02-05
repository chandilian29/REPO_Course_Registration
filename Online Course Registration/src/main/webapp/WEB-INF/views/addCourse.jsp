<%-- 
    Document   : addCourse
    Created on : 16/05/2014, 5:51:12 AM
    Author     : Jevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" context/html; charset=UTF-8">
              <title>Add New Course</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Add New Course</h1>
        <form:form commandName="course" action="addCourse" method="post">
            
            <table>
                <tr>
                    <td>Course Code</td>
                    <td><form:input path="courseId" /> </td>
                    <td><form:errors path="courseId" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Course Name</td>
                    <td><form:input path="courseName" /> </td>
                    <td><form:errors path="courseName" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Course Description</td>
                    <td><form:input path="courseDescription" /> </td>
                    <td><form:errors path="courseDescription" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Offerings per Time</td>
                    <td><form:input path="offeringsPerTime" /> </td>
                    <td><form:errors path="offeringsPerTime" cssClass="error" /> </td>
                </tr>
            </table>
            <input value="Add Course" type="submit"/>

        </form:form>
             <p><a href="adminHome">Admin Home</a>
    </body>
</html>
