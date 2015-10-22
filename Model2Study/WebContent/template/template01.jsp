﻿<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>레이아웃</title>
    <meta charset=utf-8"/>
    <style type="text/css">

        hr {
            display: none;
        }

        ul, ol {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        a {
            text-decoration: none;
        }

        fieldset legend {
            display: none;
        }

        fieldset {
            border: 0;
        }

        header,
        section,
        nav,
        footer,
        aside {
            display: block;
        }

        div.wrapper {
            margin: 0 auto;
            width: 950px;
            overflow: hidden;
        }

        div.wrapper header {
            height: 107px;
        }

        div.wrapper header h1 {
            width: 250px;
            height: 27px;
            float: left;
            text-indent: -5000px;
            background: url(${pageContext.request.contextPath}/img/logo.gif) no-repeat 0 0;
        }

        div.wrapper ul {
            float: right;
        }

        div.wrapper ul li {
            float: left;
        }

        div.wrapper ul li a {
            padding: 0 10px;
            border-right: 1px solid #C5C5C5;
            color: #444444;
        }

        div.wrapper ul li.home a {
            padding-left: 28px;
            background: url(${pageContext.request.contextPath}/img/home.gif) 10px 0 no-repeat;
        }

        div.wrapper ul li.cart a {
            padding-left: 28px;
            background: url(${pageContext.request.contextPath}/img/cart.gif) 10px 0 no-repeat;
        }

        div.wrapper nav {
            height: 37px;
            clear: both;
            background: url(${pageContext.request.contextPath}/img/nav.gif) no-repeat;
        }

        div.wrapper nav ol {
            margin-left: 298px;
        }

        div.wrapper nav li {
            float: left;
        }

        div.wrapper nav li a {
            text-indent: -5000px;
            display: block;
            height: 37px;
            width: 100px;
            background: url(${pageContext.request.contextPath}/img/nav.gif) no-repeat;
        }

        div.wrapper nav li.html a {
            background-position: -298px 0;
        }

        div.wrapper nav li.css a {
            background-position: -398px 0;
        }

        div.wrapper nav li.script a {
            background-position: -498px 0;
        }

        div.wrapper nav li.dom a {
            background-position: -598px 0;
        }

        div.wrapper nav li.html a:hover {
            background-position: -298px -37px;
        }

        div.wrapper nav li.css a:hover {
            background-position: -398px -37px;
        }

        div.wrapper nav li.script a:hover {
            background-position: -498px -37px;
        }

        div.wrapper nav li.dom a:hover {
            background-position: -598px -37px;
        }

        div.wrapper nav fieldset form * {
            vertical-align: middle
        }

        div.wrapper nav fieldset form {
            margin-top: 4 px\9;
        }

        div.wrapper nav fieldset input {
            border: 0;
            width: 180px;
        }

        div.wrapper nav fieldset button {
            margin-top: 5px;
            text-indent: -5000px;
            border: 0;
            width: 15px;
            height: 15px;
            background: url(${pageContext.request.contextPath}/img/search.gif) 0 0 no-repeat;
        }

        div.wrapper aside {
            width: 250px;
            float: left;
            min-height: 500px;
            background: silver;
        }

        div.wrapper section {
            width: 700px;
            float: right;
            min-height: 500px;
            background: gold;
        }

        div.wrapper footer {
            height: 50px;
            clear: both;
            background: gray;
        }

    </style>
    <!--[if IE]>
    <script type="text/javascript">

        (function () {
            if (!/*@cc_on!@*/0) return;
            var e = "abbr,article,aside,audio,bb,canvas,datagrid,datalist,details,dialog,eventsource,figure,footer,hgroup,header,mark,menu,meter,nav,output,progress,section,time,video".split(','), i = 0, length = e.length;
            while (i < length) {
                document.createElement(e[i++])
            }
        })();
    </script>
    <![endif]-->
</head>
<body>

<div class="wrapper">
	<%--header include --%>
	<jsp:include page="../menus/header.jsp"></jsp:include>
	
    <hr/>
    
    <%-- aside inclue --%>
    <jsp:include page="../menus/aside.jsp"></jsp:include>
    <hr/>

    <section>
    	<jsp:include page="${contentFile }"/>
    </section>

    <hr/>
    <%-- footer inclue --%>
    <jsp:include page="../menus/footer.jsp"></jsp:include>

</div>

</body>
</html>