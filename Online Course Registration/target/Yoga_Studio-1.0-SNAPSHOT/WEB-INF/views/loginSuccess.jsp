<%-- 
    Document   : loginSuccess
    Created on : Apr 22, 2014, 12:25:28 PM
    Author     : Yonas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menues</title>
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Welcome  ${currentuser.fistName} Success!</h1>   
        <!--        <a href="j_spring_security_logout">logout</a></br>-->

        <sec:authorize access="hasRole('ROLE_ADMIN')" url="/addBook" >
            <a href="addBook.html"> Add a Book</a>
        </sec:authorize></br>

        <sec:authorize access="hasRole('ROLE_ADMIN')" url="/createUser" >
            <a href="createUser.html">Create User</a>
        </sec:authorize></br>

        <sec:authorize access="hasRole('ROLE_USER')" url="/borrowBook" >
            <a href="borrowBook.html"> Borrow book</a>
        </sec:authorize></br>

        <sec:authorize access="hasRole('ROLE_USER')" url="/listBooks" >
            <a href="listBooks.html"> List Books</a>
        </sec:authorize></br>



        <sec:authorize access="hasRole('ROLE_ADMIN')" url="/listUsers" >
            <a href="listUsers.html"> List Users</a>
        </sec:authorize></br>  

        <a href="j_spring_security_logout">logout</a></br>

    </body>
</html>