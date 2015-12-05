<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>

<%@include file="common/menu.html"%>

<c:forEach items="${departments}" var="department">
    <table>
        <tr>
            <td><a href="<c:url value='/${department.name}-objects' />">${department.name}</a></td>
        </tr>
        <tr>
            <%--<td>
                <c:forEach items="${department.processControlObjects}" var="processControlObject">
                    ${processControlObject.name} <br/>
                </c:forEach>
            </td>--%>
        </tr>
    </table>
</c:forEach>
</body>
</html>
