<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignalTable - ${processControlObject.name} - DIs</title>
    <style>

        .table-fixed {
            height: 80%;
        }

        .table-fixed thead {
            width: 97%;
        }
        .table-fixed tbody {
            height: 80%;
            overflow-y: auto;
            width: 100%;
        }
        .table-fixed thead, .table-fixed tbody, .table-fixed tr, .table-fixed td, .table-fixed th {
            display: block;
        }
        .table-fixed tbody td, .table-fixed thead > tr> th {
            float: left;
            border-bottom-width: 0;
        }

        #menu {
            width: 100%;
            height: auto;
            position: inherit;
            top: 0;
            left: 0;
            font-size: 16px;
        }
        #iotable {
            width: 100%;
            height: auto;
            position: inherit;
            margin: 0;
        }

    </style>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
<div id="menu"><%@include file="../menu.jsp"%></div>
<div id="iotable" class="container">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <ul class="nav nav-pills">
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
                    <li role="presentation" class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                            Action <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value='/${processControlObject.name}-downloadExcel'/>">excel</a> <span class="divider">/</span></li>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="<c:url value='/${processControlObject.name}/di/new'/>">new</a></li>
                            </sec:authorize>
                        </ul>
                    </li>
                </ul>
            </div>
            <table class="table table-fixed table-condensed">
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
                        <td>
                            ${digitalInput.id}
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="<c:url value='/${processControlObject.name}/di/${digitalInput.id}-edit'/>"
                                   class="btn btn-link btn-xs" role="button">edit</a>
                                <c:url var="deleteURL" value='/${processControlObject.name}/di/${digitalInput.id}-delete'/>
                                <form action="${deleteURL}" method="POST">
                                    <input id="digitalInput" name="digitalInput" type="hidden" value="${digitalInput.id}"/>
                                    <input class="btn btn-link btn-xs" type="submit" value="delete" onClick="return confirm('Delete Element?')"/>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                </form>
                            </sec:authorize>
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