<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <c:forEach items="${apcsObjects}" var="apcsObject">
        <tr>
            <td>
                <a href="<c:url value='/${apcsObject.id}-object' />">${apcsObject.name}</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
