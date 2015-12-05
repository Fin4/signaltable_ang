<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<!doctype html>--%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        /* Базовые стили демо-страницы */
        *, *:before, *:after {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        html, body {
            height: 100%;
        }
        body {
            font: 12px/1 "Open Sans", sans-serif;
            color: #555;
            background: #fafafa;
        }
        #container {
            /*max-width: 980px;*/
            margin: 0 auto;
            padding: 0px 5px 0;
        }
        h1 {
            padding: 5px 0;
            font-weight: 400;
            text-align: center;
        }
        p {
            margin: 0 0 5px;
            line-height: 1.5;
        }
        /* Table style */
        table {
            width: 100%;
            height: 50%;
            border: 1px solid #000000;
            border-collapse: collapse;
        }
        tr {

        }
        td, th {
            min-width: 5%;
            padding: 1px;
        }
        td {
            font-family: 'Courier New';
            font-size: 10pt;
        }
        th {
            background-color: darkkhaki;
        }



        .tabs {
            min-width: 50%;
            max-width: 100%;
            padding: 0px;
            margin: 0 auto;

        }

        section {
            display: none;
            padding: 15px;
            background: #fff;
            border: 1px solid #ddd;
        }
        .tabs input {
            display: none;
        }

        .tabs label {
            display: inline-block;
            margin: 0 0 -1px;
            padding: 5px 15px;
            font-weight: 600;
            text-align: center;
            color: #aaa;
            border: 1px solid #ddd;
            background: #f1f1f1;
            border-radius: 3px 3px 0 0;
        }

        .tabs label:before {
            font-family: fontawesome;
            font-weight: normal;
            margin-right: 10px;
        }
        .tabs label[for*="1"]:before {
            content: "\f19a";
        }
        .tabs label[for*="2"]:before {
            content: "\f17a";
        }
        .tabs label[for*="3"]:before {
            content: "\f13b";
        }
        .tabs label[for*="4"]:before {
            content: "\f13c";
        }

        .tabs label:hover {
            color: #888;
            cursor: pointer;
        }

        .tabs input:checked + label {
            color: #555;
            border: 1px solid #ddd;
            border-top: 1px solid #009933;
            border-bottom: 1px solid #fff;
            background: #fff;
        }

        #di:checked ~ #diContent,
        #ai:checked ~ #aiContent,
        #do:checked ~ #doContent,
        #ao:checked ~ #aoContent {
            display: block;
        }


        @media screen and (max-width: 680px) {
            .tabs label {
                font-size: 0;
            }

            .tabs label:before {
                margin: 0;
                font-size: 18px;
            }
        }
        @media screen and (max-width: 400px) {
            .tabs label {
                padding: 15px;
            }
        }
    </style>
</head>
<body>
<div id="container">
    <h1>${processControlObject.name}</h1>
    <a href="<c:url value='/${processControlObject.id}-object-downloadExcel' />">download excel</a>
    <div class="tabs">
        <input id="di" type="radio" name="tabs" checked>
        <label for="di" title="DI">DI</label>

        <input id="ai" type="radio" name="tabs">
        <label for="ai" title="AI">AI</label>

        <input id="do" type="radio" name="tabs">
        <label for="do" title="DO">DO</label>

        <input id="ao" type="radio" name="tabs">
        <label for="ao" title="AO">AO</label>

        <section id="diContent">
            <a href="<c:url value='/${processControlObject.id}-object-newDI' />">Add New DI</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Symbol</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${processControlObject.digitalInputList}" var="digitalInput">
                    <tr>
                        <td>${digitalInput.id} <a href="<c:url value='/${processControlObject.id}-object-edit-${digitalInput.id}' />">edit</a>
                            <a href="<c:url value='/${processControlObject.id}-object-del-${digitalInput.id}' />">delete</a></td>
                        <td>${digitalInput.symbol}</td>
                        <td>${digitalInput.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>

        <section id="aiContent">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Symbol</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${processControlObject.analogInputList}" var="analogInput">
                    <tr>
                        <td>${analogInput.id}</td>
                        <td>${analogInput.symbol}</td>
                        <td>${analogInput.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>

        <section id="doContent">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Symbol</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${processControlObject.digitalOutputList}" var="digitalOutput">
                    <tr>
                        <td>${digitalOutput.id}</td>
                        <td>${digitalOutput.symbol}</td>
                        <td>${digitalOutput.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>

        <section id="aoContent">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Symbol</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${processControlObject.analogOutputList}" var="analogOutput">
                    <tr>
                        <td>${analogOutput.id}</td>
                        <td>${analogOutput.symbol}</td>
                        <td>${analogOutput.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </div>
</div>
</body>
</html>
