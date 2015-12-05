<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<ul>
    <h1>Objects</h1>
    <c:forEach items="${processControlObjects}" var="processControlObject">
        <li ><a href="<c:url value='/${processControlObject.name}/di'/>">${processControlObject.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>
