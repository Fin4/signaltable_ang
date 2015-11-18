<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            /*text-align: right;*/
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
    </style>
</head>
<body>
<div id="menu"><%@include file="../menu.jsp"%></div>
<div id="workspace">
    <table>
        <tr>
            <th><h3>${apcsObject.name}</h3></th>
            <th><a href="<c:url value='/${apcsObject.name}/di'/>">DI</a></th>
            <th><a href="<c:url value='/${apcsObject.name}/ai'/>">AI</a></th>
            <th><a href="<c:url value='/${apcsObject.name}/do'/>">DO</a></th>
            <th><a href="<c:url value='/${apcsObject.name}/ao'/>">AO</a></th>
        </tr>
    </table>
    <table>
        <thead>
        <tr><th colspan="2">Аналоговые выходы</th>
            <th class="tablemenu">
                <a href="<c:url value='/${apcsObject.name}-downloadExcel'/>" class="mbutton">excel</a>
                <a href="<c:url value='/${apcsObject.name}/ao/new'/>" class="mbutton">add new</a>
            </th>
        </tr>
        <tr>
            <th>ID</th>
            <th>Symbol</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${analogOutputs}" var="analogOutput">
            <tr>
                <td>${analogOutput.id} <a href="<c:url value='/${apcsObject.name}/ao/${analogOutput.id}-edit'/>" class="button">edit</a>
                    <c:url var="deleteURL" value='/${apcsObject.name}/ao/${analogOutput.id}-delete'/>
                    <form action="${deleteURL}" method="POST">
                        <input id="analogOutput" name="analogOutput" type="hidden" value="${analogOutput.id}"/>
                        <input class="button" type="submit" value="delete" onClick="return confirm('Удалить элемент?')"/>
                    </form>
                </td>
                <td>${analogOutput.symbol}</td>
                <td>${analogOutput.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>