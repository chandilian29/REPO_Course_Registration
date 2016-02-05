<%-- 
    Document   : productDetail
    Created on : May 12, 2014, 10:31:36 PM
    Author     : Sandy
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Details</title>
         <link href="../resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <h1>Product Details</h1>
    <body>
        <form:form commandName="product" action="../viewProduct/${product.id}" method="post">
            <form:hidden path="id" /> 
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>Product Name :</td>
                    <td><form:input path="productName" /> </td>
                    <td><form:errors path="productName" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Product Price :</td>
                    <td><form:input path="productPrice" /> </td>
                    <td><form:errors path="productPrice" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Product Description :</td>
                    <td><form:input path="productDescription" /> </td>
                    <td><form:errors path="productDescription" cssClass="error"/> </td>
                </tr>
            </table>
            <input type="submit" value="Update"/>
        </form:form>
    </body>
</html>
