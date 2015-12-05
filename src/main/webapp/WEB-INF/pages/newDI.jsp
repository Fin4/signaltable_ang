<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Adding new DI</title>

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>

<h2>new DI form</h2>

<form:form method="POST" modelAttribute="digitalInput">
    <table>
        <tr>
            <td><label for="symbol">Symbol: </label> </td>
            <td><form:input path="symbol" id="symbol"/></td>
            <td><form:errors path="symbol" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="description">Description: </label> </td>
            <td><form:input path="description" id="description"/></td>
            <td><form:errors path="description" cssClass="error"/></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="add"/></td>
        </tr>
    </table>
</form:form>
<br/>
<br/>
${digitalInput.processControlObject}<br/>
</body>
</html>