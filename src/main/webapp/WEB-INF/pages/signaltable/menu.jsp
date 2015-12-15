<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="<c:url value='/'/>">Main</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal == null}">
                    <li>
                        <a href="<c:url value="/login"/>">login</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="<c:url value="/users/${pageContext.request.userPrincipal.name}"/>">You signed as: ${pageContext.request.userPrincipal.name}</a>
                    </li>
                    <li>
                        <a href="<c:url value="/logout"/>">logout</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
</body>
</html>
