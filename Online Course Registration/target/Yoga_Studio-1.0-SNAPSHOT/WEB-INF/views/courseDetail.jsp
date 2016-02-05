<%-- 
    Document   : courseDetail
    Created on : 16/05/2014, 6:11:47 AM
    Author     : Jevin
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Details</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <h1>Course Details</h1>
    <body>
        <form:form commandName="course" action="../viewCourse/${course.id}" method="post">
            <form:hidden path="id" /> 
             <table>
                <tr>
                    <td>Course Code :</td>
                    <td><form:input path="courseId" /> </td>
                    <td><form:errors path="courseId" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Course Name :</td>
                    <td><form:input path="courseName" /> </td>
                    <td><form:errors path="courseName" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Course Description :</td>
                    <td><form:input path="courseDescription" /> </td>
                    <td><form:errors path="courseDescription" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Offerings per Time :</td>
                    <td><form:input path="offeringsPerTime" /> </td>
                    <td><form:errors path="offeringsPerTime" cssClass="error"/> </td>
                </tr>
            </table>
            <input type="submit" value="Update"/>
        </form:form>
    </body>
</html>

