<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="js/jquery-1.3.2.js" ></script>
<script type="text/javascript" src="js/jquery.quickflip.js" ></script>

<html>
<head>
    <title></title>
    <style>
        #flip-tabs{
            width:300px;
            margin:20px auto; position:relative;
        }
        #flip-navigation{
            margin:0 0 10px; padding:0;
            list-style:none;
        }
        #flip-navigation li{
            display:inline;
        }
        #flip-navigation li a{
            text-decoration:none; padding:10px;
            margin-right:0px;
            background:#f9f9f9;
            color:#333; outline:none;
            font-family:Arial; font-size:12px; text-transform:uppercase;
        }
        #flip-navigation li a:hover{
            background:#999;
            color:#f0f0f0;
        }
        #flip-navigation li.selected a{
            background:#999;
            color:#f0f0f0;
        }
        #flip-container{
            width:100%;
            font-family:Arial; font-size:13px;
        }
        #flip-container div{
            background:#fff;
        }
    </style>
    <script type="text/javascript" >
        $('document').ready(function(){
            //initialize quickflip
            $('#flip-container').quickFlip();

            $('#flip-navigation').find('li a').each(function(){
                $(this).click(function(){
                    $('#flip-navigation').find('li').each(function(){
                        $(this).removeClass('selected');
                    });
                    $(this).parent().addClass('selected');
                    //extract index of tab from id of the navigation item
                    var flipid=$(this).attr('id').substr(4);
                    //Flip to that content tab
                    $('#flip-container').quickFlipper({ }, flipid, 1);

                    return false;
                });
            });
        });
    </script>
</head>
<body>
<div id="flip-tabs" >
    <ul id="flip-navigation" >
        <li class="selected"><a href="?tab=di" id="tabDi">DI</a></li>
        <li><a href="?tab=do" id="tabDo" >DO</a></li>
        <li><a href="?tab=ai" id="tabAi" >AI</a></li>
        <li><a href="?tab=ao" id="tabAo" >AO</a></li>
    </ul>
    <div id="flip-container" >
        <div>
            <a href="<c:url value='/${processControlObject.id}-object-newDI' />">Add New DI</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Symbol</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${digitalInputs}" var="digitalInput">
                    <tr>
                        <td>${digitalInput.id} <a href="<c:url value='/${processControlObject.id}-object-edit-${digitalInput.id}' />">edit</a>
                            <a href="<c:url value='/${processControlObject.id}-object-del-${digitalInput.id}' />">delete</a></td>
                        <td>${digitalInput.symbol}</td>
                        <td>${digitalInput.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div>
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
        <div>
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
        <div>
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
