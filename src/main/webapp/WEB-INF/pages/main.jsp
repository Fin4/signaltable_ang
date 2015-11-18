<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>

<%@include file="common/menu.html"%>

<c:forEach items="${directions}" var="direction">
    <table>
        <tr>
            <td><a href="<c:url value='/${direction.name}-objects' />">${direction.name}</a></td>
        </tr>
        <tr>
            <%--<td>
                <c:forEach items="${direction.apcsObjects}" var="apcsObject">
                    ${apcsObject.name} <br/>
                </c:forEach>
            </td>--%>
        </tr>
    </table>
</c:forEach>
</body>
</html>
