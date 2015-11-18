<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>${apcsObject.name}</title>
  <style>
    #menu {
      width: 100%;
      height: 100px;
      position: absolute;
      top:0;
    }
    #workspace {
      width: 100%;
      position: absolute;
      top: 102px;
    }

    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    table {
      color: #333;
      font-family: sans-serif;
      font-size: .9em;
      font-weight: 300;
      text-align: left;
      line-height: 40px;
      border-spacing: 0;
      border: 1px solid #428bca;
      width: 1000px;
      margin: 20px auto;
    }

    thead tr:first-child {
      background: #428bca;
      color: #fff;
      border: none;
    }

    th {font-weight: bold;}

    th:first-child, td:first-child {padding: 0 5px 0 15px;}

    thead tr:last-child th {border-bottom: 2px solid #ddd;}

    tbody tr:hover {background-color: #f0fbff;}
    tbody tr:last-child td {border: none;}
    tbody td {border-bottom: 1px solid #ddd; line-height: 25px}

    td:last-child {
      text-align: right;
      padding-right: 10px;
    }

    .button {
      border: none;
      color: #428bca;
      text-align: center;
      text-decoration: none;
      padding-left: 15px;
      background: transparent;
      font-size: .9em;
    }

    .button:hover {
      text-decoration: underline;
      cursor: pointer;
    }
    .mbutton {
      color: white;
      text-align: center;
      text-decoration: none;
      font-weight: normal;
      padding-left: 15px;
    }

    .mbutton:hover {
      text-decoration: underline;
      cursor: pointer;
    }
    .tablemenu {
      text-align: right;
      padding-right: 10px;
    }
    form {
      width: auto;
      margin: 0;
      padding: 0;
      display: inline;
    }

    form {
      display: inline;
    }

    .table td {
      font-size: .9em;
    }

    .btn {
      padding: 3px 3px;
    }

  </style>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
<div id="menu"><%@include file="../menu.jsp"%></div>
<div class="container">
  <div class="table-responsive">
    <table class="table">
        <tr>
            <th><h3>${apcsObject.name}</h3></th>
            <th><a href="<c:url value='/${apcsObject.name}/di'/>">DI</a></th>
            <th><a href="<c:url value='/${apcsObject.name}/ai'/>">AI</a></th>
            <th><a href="<c:url value='/${apcsObject.name}/do'/>">DO</a></th>
            <th><a href="<c:url value='/${apcsObject.name}/ao'/>">AO</a></th>
        </tr>
    </table>
  <table class="table table-striped">
    <thead>
    <tr><th colspan="2">Дискретные входы</th>
    <th class="tablemenu">
      <ul class="breadcrumb">
        <li><a href="<c:url value='/${apcsObject.name}-downloadExcel'/>">excel</a> <span class="divider">/</span></li>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="<c:url value='/${apcsObject.name}/di/new'/>">new</a></li>
        </sec:authorize>
      </ul>
    </th>
    </tr>
  <tr>
    <th>ID</th>
    <th>Symbol</th>
    <th>Description</th>
  </tr>
    </thead>
    <tbody>
  <c:forEach items="${digitalInputs}" var="digitalInput">
    <tr>
      <td>${digitalInput.id} <a href="<c:url value='/${apcsObject.name}/di/${digitalInput.id}-edit'/>" class="btn btn-link btn-xs" role="button">edit</a>
        <c:url var="deleteURL" value='/${apcsObject.name}/di/${digitalInput.id}-delete'/>
        <form action="${deleteURL}" method="POST">
          <input id="digitalInput" name="digitalInput" type="hidden" value="${digitalInput.id}"/>
          <input class="btn btn-link btn-xs" type="submit" value="delete" onClick="return confirm('Удалить элемент?')"/>
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