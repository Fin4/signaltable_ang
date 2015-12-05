<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <c:forEach items="${processControlObjects}" var="processControlObject">
        <tr>
            <td>
                <a href="<c:url value='/${processControlObject.id}-object' />">${processControlObject.name}</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
