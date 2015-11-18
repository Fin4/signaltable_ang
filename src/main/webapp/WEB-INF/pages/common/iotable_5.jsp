<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>${apcsObject.name}</title>

  <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
  <script>
    $(document).ready(function() {
      $('.nav-tabs > li > a').click(function(event){
        event.preventDefault();//stop browser to take action for clicked anchor

        //get displaying tab content jQuery selector
        var active_tab_selector = $('.nav-tabs > li.active > a').attr('href');

        //find actived navigation and remove 'active' css
        var actived_nav = $('.nav-tabs > li.active');
        actived_nav.removeClass('active');

        //add 'active' css into clicked navigation
        $(this).parents('li').addClass('active');

        //hide displaying tab content
        $(active_tab_selector).removeClass('active');
        $(active_tab_selector).addClass('hide');

        //show target tab content
        var target_tab_selector = $(this).attr('href');
        $(target_tab_selector).removeClass('hide');
        $(target_tab_selector).addClass('active');
      });
    });
  </script>
  <style>
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
    /** Start: to style navigation tab **/
    .nav {
      margin-bottom: 18px;
      margin-left: 0;
      list-style: none;
    }

    .nav > li > a {
      display: block;
    }

    .nav-tabs{
      *zoom: 1;
    }

    .nav-tabs:before,
    .nav-tabs:after {
      display: table;
      content: "";
    }

    .nav-tabs:after {
      clear: both;
    }

    .nav-tabs > li {
      float: left;
    }

    .nav-tabs > li > a {
      padding-right: 12px;
      padding-left: 12px;
      margin-right: 2px;
      line-height: 14px;
    }

    .nav-tabs {
      border-bottom: 1px solid #ddd;
    }

    .nav-tabs > li {
      margin-bottom: -1px;
    }

    .nav-tabs > li > a {
      padding-top: 8px;
      padding-bottom: 8px;
      line-height: 18px;
      border: 1px solid transparent;
      -webkit-border-radius: 4px 4px 0 0;
      -moz-border-radius: 4px 4px 0 0;
      border-radius: 4px 4px 0 0;
    }

    .nav-tabs > li > a:hover {
      border-color: #eeeeee #eeeeee #dddddd;
    }

    .nav-tabs > .active > a,
    .nav-tabs > .active > a:hover {
      color: #555555;
      cursor: default;
      background-color: #ffffff;
      border: 1px solid #ddd;
      border-bottom-color: transparent;
    }

    li {
      line-height: 18px;
    }

    .tab-content.active{
      display: block;
    }

    .tab-content.hide{
      display: none;
    }


    /** End: to style navigation tab **/
  </style>
</head>
<body>
<h3 align="center">${apcsObject.name}</h3>
<div>
  <ul class="nav nav-tabs">
    <li><a href="?tab=di">Digital Inputs</a></li>
    <li><a href="?tab=do">Digital Outputs</a></li>
    <li><a href="?tab=ai">Analog Inputs</a></li>
    <li><a href="?tab=ao">Analog Outputs</a></li>
    <li><a href="#test">TestTab</a></li>
  </ul>
</div>

<section id="di" class="tab-content active">
  <div>
    <table>
      <tr>
        <th>ID</th>
        <th>Symbol</th>
        <th>Description</th>
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
</section>
<section id="do" class="tab-content hide">
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
</section>
<section id="ai" class="tab-content hide">
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
</section>
<section id="ao" class="tab-content hide">
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
</section>
<section id="test" class="tab-content hide">
  <table>
    <tr>
      <th>ID</th>
      <th>Symbol</th>
      <th>Description</th>
    </tr>
    <tr>
      <td>TEST ID</td>
      <td>TEST SYMBOL</td>
      <td>TEST DESCRIPTION</td>
    </tr>
  </table>
</section>
</body>
</html>
