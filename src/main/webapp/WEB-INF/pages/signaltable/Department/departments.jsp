<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<ul>
  <c:forEach items="${departments}" var="department">
    <li ><a href="<c:url value='/${department.name}'/>">${department.name}</a></li>
  </c:forEach>
</ul>
</body>
</html>
