<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
    <style>
        #menu {
            width: 100%;
            height: 100px;
            position: absolute;
            top:0px;
            left:0px;
            font-size: 20px;
        }
        #objs_tree {
            width: 20%;
            height: auto;
            position: absolute;
            top:102px;
            left:0px;
        }
        #iotable {
            width: 75%;
            height: auto;
            position: absolute;
            top:102px;
            left:20%;
        }
    </style>
</head>
<body>
<div id="menu"><%@include file="common/menu.html"%></div>
<div id="objs_tree"><%@include file="common/objs_tree.jsp"%></div>
<div id="iotable"><%@include file="common/iotable_1.jsp"%></div>
</body>
</html>
