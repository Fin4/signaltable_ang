<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <style>
        /*----- Tabs -----*/
        .tabs {
            width:100%;
            display:inline-block;
        }

        /*----- Tab Links -----*/
        /* Clearfix */
        .tab-links:after {
            display:block;
            clear:both;
            content:'';
        }

        .tab-links li {
            margin:0px 5px;
            float:left;
            list-style:none;
        }

        .tab-links a {
            padding:9px 15px;
            display:inline-block;
            border-radius:3px 3px 0px 0px;
            background:#7FB5DA;
            font-size:16px;
            font-weight:600;
            color:#4c4c4c;
            transition:all linear 0.15s;
        }

        .tab-links a:hover {
            background:#a7cce5;
            text-decoration:none;
        }

        li.active a, li.active a:hover {
            background:#fff;
            color:#4c4c4c;
        }

        /*----- Content of Tabs -----*/
        .tab-content {
            padding:15px;
            border-radius:3px;
            box-shadow:-1px 1px 1px rgba(0,0,0,0.15);
            background:#fff;
        }

        .tab {
            display:none;
        }

        .tab.active {
            display:block;
        }
    </style>
    <script>
        jQuery(document).ready(function() {
            jQuery('.tabs .tab-links a').on('click', function(e)  {
                var currentAttrValue = jQuery(this).attr('href');

                // Show/Hide Tabs
                jQuery('.tabs ' + currentAttrValue).show().siblings().hide();

                // Change/remove current tab to active
                jQuery(this).parent('li').addClass('active').siblings().removeClass('active');

                e.preventDefault();
            });
        });
    </script>
</head>
<body>
<div class="tabs">
    <ul class="tab-links">
        <li class="active"><a href="#di">DI</a></li>
        <li><a href="#ai">AI</a></li>
        <li><a href="#do">DO</a></li>
        <li><a href="#ao">AO</a></li>
    </ul>

    <div class="tab-content">
        <div id="di" class="tab active">
            <a href="<c:url value='/${apcsObject.id}-object-newDI' />">Add New DI</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Symbol</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${digitalInputs}" var="digitalInput">
                    <tr>
                        <td>${digitalInput.id} <a href="<c:url value='/${apcsObject.id}-object-edit-${digitalInput.id}' />">edit</a>
                            <a href="<c:url value='/${apcsObject.id}-object-del-${digitalInput.id}' />">delete</a></td>
                        <td>${digitalInput.symbol}</td>
                        <td>${digitalInput.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div id="ai" class="tab">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Symbol</th>
                    <th>Description</th>
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

        <div id="do" class="tab">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Symbol</th>
                    <th>Description</th>
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

        <div id="ao" class="tab">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Symbol</th>
                    <th>Description</th>
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
