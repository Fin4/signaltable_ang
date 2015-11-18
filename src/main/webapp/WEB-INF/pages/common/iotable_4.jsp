<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${apcsObject.name}</title>
    <script type='text/javascript' src='//code.jquery.com/jquery-1.9.1.js'></script>

    <%--<link rel="stylesheet" type="text/css" href="iotableResources/iotable_css.css">--%>

    <style type='text/css'>
        .tabbable .tabs {list-style: none; margin: 0 10px; padding: 0;}
        .tabbable .tabs li {list-style: none; margin: 0; padding: 0; display: inline-block; position: relative; z-index: 1;}
        .tabbable .tabs li a {text-decoration: none; color: #000; border: 1px solid #ccc; padding: 5px; display: inline-block; border-radius: 5px 5px 0 0; background: #f5f5f5;}
        .tabbable .tabs li a.active, .tabbable .tabs li a:hover {border-bottom-color: #fff; background: #fff;}
        .tabcontent {border: 1px solid #ccc; margin-top: -1px; padding: 10px;}
    </style>

    <script type='text/javascript'>//<![CDATA[
    $(window).load(function(){
        $(document).ready(function(){
            $(".tabbable").find(".tab").hide();
            $(".tabbable").find(".tab").first().show();
            $(".tabbable").find(".tabs li").first().find("a").addClass("active");
            $(".tabbable").find(".tabs").find("a").click(function(){
                tab = $(this).attr("href");
                $(".tabbable").find(".tab").hide();
                $(".tabbable").find(".tabs").find("a").removeClass("active");
                $(tab).show();
                $(this).addClass("active");
                return false;
            });
        });
    });//]]>

    </script>
</head>
<body>
<h3 align="center">${apcsObject.name}</h3>
<div class="tabbable">
    <ul class="tabs">
        <li><a href="?tab=di">Digital Inputs</a></li>
        <li><a href="?tab=do">Digital Outputs</a></li>
        <li><a href="?tab=ai">Analog Inputs</a></li>
        <li><a href="?tab=ao">Analog Outputs</a></li>
    </ul>
    <div class="tabcontent">
        <div id="di" class="tab">
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
        <div id="do" class="tab">
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
        <div id="ai" class="tab">
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
        <div id="ao" class="tab">
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
    </div>
</div>
</body>
</html>
