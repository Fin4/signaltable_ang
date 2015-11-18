<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Adding new direction</title>

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>
<body>
<form:form method="POST" modelAttribute="direction">
    <table>
        <tr>
            <td><label for="name">name: </label> </td>
            <td><form:input path="name" id="name"/></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="add direction"/></td>
        </tr>
    </table>
</form:form>
<br/>
<br/>
</body>
</html>
