<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SignalTable</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #a5b5c9;
        }
    </style>

</head>

<body>
<h2 >List of DIs</h2>
<table>
    <tr>
        <td>ID</td><td>Symbol</td><td>Description</td>
    </tr>
    <c:forEach items="${digitalInputs}" var="digitalInput">
        <tr>
            <td>${digitalInput.id}</td>
            <td>${digitalInput.symbol}</td>
            <td>${digitalInput.description}</td>
            <td><a href="<c:url value='/delete-${digitalInput.id}-digitalInput' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/newDI' />">Add New DI</a>
</body>
</html>