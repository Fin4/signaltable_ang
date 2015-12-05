<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${processControlObject.name}</title>
    <style>
        /* Table style */
        table {
            width: 100%;
            height: 50%;
            border: 1px solid #000000;
            border-collapse: collapse;
        }
        .tabs {
            opacity: 0;
            visibility: hidden;
        }
        .tab{
            position:absolute;
            visibility: hidden;
            z-index: 10;    /* z-index */
            color:#478CFB;
            font: bold 12pt "Trebuchet MS", tahoma, verdana, arial narrow, arial;
        }
        .tabs:target+.tab {
            opacity: 1;
            visibility: visible;
        }
        .tabsLink a{
            background-color: #606060;
            padding:5px;
            font: bold 12pt "Trebuchet MS", tahoma, verdana, arial narrow, arial;
            color:#fff;
            text-decoration:none;

            -webkit-border-top-left-radius: 5px;
            -webkit-border-top-right-radius: 5px;
            -moz-border-radius-topleft: 5px;
            -moz-border-radius-topright: 5px;
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
        }
    </style>
</head>
<body>
<h3 align="center">${processControlObject.name}</h3>
<div class="tabsLink">
    <a href="?tab=di">Digital Inputs</a>
    <a href="?tab=do">Digital Outputs</a>
    <a href="?tab=ai">Analog Inputs</a>
    <a href="?tab=ao">Analog Outputs</a>
</div>
<br>
<a class="tabs" id="?tab=di"></a>
<div class="tab">
    <table>
        <tr>
            <td>ID</td><td>Symbol</td><td>Description</td>
        </tr>
        <c:forEach items="${digitalInputs}" var="digitalInput">
            <tr>
                <td>${digitalInput.id}</td>
                <td>${digitalInput.symbol}</td>
                <td>${digitalInput.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<a class="tabs" id="do"></a>
<div class="tab">
    <table>
        <tr>
            <td>ID</td><td>Symbol</td><td>Description</td>
        </tr>
        <c:forEach items="${digitalOutputs}" var="digitalOutput">
            <tr>
                <td>${digitalOutput.id}</td>
                <td>${digitalOutput.symbol}</td>
                <td>${digitalOutput.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<a class="tabs" id="ai"></a>
<div class="tab">
    <table>
        <tr>
            <td>ID</td><td>Symbol</td><td>Description</td>
        </tr>
        <c:forEach items="${analogInputs}" var="analogInput">
            <tr>
                <td>${analogInput.id}</td>
                <td>${analogInput.symbol}</td>
                <td>${analogInput.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<a class="tabs" id="ao"></a>
<div class="tab">
    <table>
        <tr>
            <td>ID</td><td>Symbol</td><td>Description</td>
        </tr>
        <c:forEach items="${analogOutputs}" var="analogOutput">
            <tr>
                <td>${analogOutput.id}</td>
                <td>${analogOutput.symbol}</td>
                <td>${analogOutput.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
