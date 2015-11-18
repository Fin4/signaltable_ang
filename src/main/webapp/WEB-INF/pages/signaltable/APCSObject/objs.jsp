<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<ul>
    <c:forEach items="${apcsObjects}" var="apcsObject">
        <li ><a href="<c:url value='/${apcsObject.name}/di'/>">${apcsObject.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>
