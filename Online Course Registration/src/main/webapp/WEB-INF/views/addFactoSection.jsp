<%-- 
    Document   : addFactoSection
    Created on : May 19, 2014, 7:32:09 PM
    Author     : pAlahakoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" context/html; charset=UTF-8">
              <title>Add Sections to Faculty</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Add Sections to Faculty</h1>
        <form:form commandName="myFac" action="addFacultytoSection" method="get">
            <form:errors path="*" cssClass="errorblock" element="div" />

           
    
        Faculty Name:<form:select path="firstName">
           <form:options items="${facList}" itemValue="firstName" itemLabel="firstName"/>
         </form:select>

        <input value="Add Section" type="submit"/>
    </form:form>
</body>
</html>
