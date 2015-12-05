<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignalTable - ${processControlObject.name} - DIs</title>
    <style>
        tr {
            width: 100%;
            display: inline-table;
        }
        table {
            width: 100%;
            display:block;
        }
        thead {
            display: inline-block;
            width: 100%;
        }
        tbody {
            height: auto;
            display: inline-block;
            width: 100%;
            overflow: auto;
        }
        #menu {
            width: 100%;
            height: 100px;
            position: absolute;
            top:0px;
            left:0px;
            font-size: 16px;
        }
        #iotable {
            width: 100%;
            height: 100%;
            position: absolute;
            top:102px;
            margin: auto;
        }
        #tablemenu {
            width: 100%;
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
    <ul id="tablemenu" class="nav nav-pills">
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
    <div class="table-responsive">
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
                    <td>
                        ${digitalInput.id}
                        <a href="<c:url value='/${processControlObject.name}/di/${digitalInput.id}-edit'/>"
                                             class="btn btn-link btn-xs" role="button">edit</a>
                        <c:url var="deleteURL" value='/${processControlObject.name}/di/${digitalInput.id}-delete'/>
                        <form action="${deleteURL}" method="POST">
                            <input id="digitalInput" name="digitalInput" type="hidden" value="${digitalInput.id}"/>
                            <input class="btn btn-link btn-xs" type="submit" value="delete" onClick="return confirm('Delete Element?')"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </form>
                    </td>
                    <td>${digitalInput.symbol}</td>
                    <td>${digitalInput.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>