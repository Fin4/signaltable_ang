<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignalTable - ${processControlObject.name} - DIs</title>

    <spring:url value="/resources/css/iotable.css" var="iotableCss" />

    <link href="${iotableCss}" rel="stylesheet" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
<div><%@include file="../menu.jsp"%></div>
<div id="iotable" class="container">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="nav nav-pills navbar-left">
                    <li>
                        <a>${processControlObject.name}</a>
                    </li>
                    <li class="active">
                        <a href="<c:url value='/${processControlObject.name}/di'/>">DI</a>
                    </li>
                    <li>
                        <a href="<c:url value='/${processControlObject.name}/ai'/>">AI</a>
                    </li>
                    <li>
                        <a href="<c:url value='/${processControlObject.name}/do'/>">DO</a>
                    </li>
                    <li>
                        <a href="<c:url value='/${processControlObject.name}/ao'/>">AO</a>
                    </li>
                </ul>
                <ul class="nav nav-pills navbar-right">
                    <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
                        <li><a href="<c:url value='/${processControlObject.name}/di/new'/>">new</a></li>
                    <%--</sec:authorize>--%>
                    <li>
                        <a href="<c:url value='/${processControlObject.name}_signals.xls'/>">excel</a>
                    </li>
                </ul>
                </div>
            </div>
            <table class="table table-fixed">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Symbol</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${digitalInputs}" var="digitalInput">
                    <tr>
                        <td>${digitalInput.id}
<%--                            <sec:authorize access="hasRole('ROLE_ADMIN')">--%>
                                <a href="<c:url value='/${processControlObject.name}/di/${digitalInput.id}-edit'/>"
                                   class="btn btn-link btn-xs" role="button">edit</a>
                                <c:url var="deleteURL" value='/${processControlObject.name}/di/${digitalInput.id}-delete'/>
                                <form action="${deleteURL}" method="POST">
                                    <input id="digitalInput" name="digitalInput" type="hidden" value="${digitalInput.id}"/>
                                    <input class="btn btn-link btn-xs" type="submit" value="delete" onClick="return confirm('Delete ${digitalInput.symbol} Element?')"/>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                </form>
<%--                            </sec:authorize>--%>
                        </td>
                        <td>${digitalInput.symbol}</td>
                        <td>${digitalInput.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>