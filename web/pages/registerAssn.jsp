<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/registerAssn.css"/>
    <link rel="stylesheet" type="text/css" href="../css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="../css/htmleaf-demo.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>社团成员管理系统</title>
    <style type="text/css">
        .drop a {
            text-decoration: none;
            color: #FFFFFF;
        }

        .drop a:hover {
            text-decoration: none;
            color: #000000;
        }

        .main {
            text-decoration: none;
            color: #FFFFFF;
        }

        .main:hover {
            text-decoration: none;
            color: #000000;
        }
    </style>
</head>
<body class="body">
<div class="htmleaf-container">
    <nav>
        <ul id="main">
            <li><a href="main.jsp">主页</a></li>
            <li>成员管理
                <ul class="drop">
                    <div>
                        <li><a href="find">成员审查</a></li>
                        <li><a href="registerUser.jsp">成员改动</a></li>
                        <li><a href="findUser.jsp">成员检索</a></li>
                    </div>
                </ul>
            </li>
            <li>社团管理
                <ul class="drop">
                    <div>
                        <li><a href="find_Assn">社团审查</a></li>
                        <li><a href="registerAssn.jsp">社团改动</a></li>
                        <li><a href="findAssn.jsp">社团检索</a></li>
                    </div>
                </ul>
            </li>
            <li>联系我们
                <ul class="drop">
                    <div>
                        <li><a href="about.jsp">关于</a></li>
                    </div>
                </ul>
            </li>
            <div id="marker"></div>
        </ul>
    </nav>
</div>
<div class="form">
    <s:form action="saveAssn" method="post">
        <!--<s:hidden name="aData.assnId"></s:hidden>-->
        <div class="float">社团名：</div>
        <div class="float">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <s:textfield name="aData.assnName" size="50" class="float_a"/>
        </div>
        <br/>
        <br/>
        <div class="float">注册时间：</div>
        <div class="float">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <s:textfield name="aData.assnTime" size="50" class="float_a"/>
        </div>
        <br/>
        <br/>
        <div class="float">负责人：</div>
        <div class="float">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <s:textfield name="aData.assnChairman" size="50" class="float_a"/>
        </div>
        <br/>
        <br/>
        <div class="float">指导教师：</div>
        <div class="float">
            &nbsp;&nbsp;
            <s:textfield name="aData.assnTeacher" size="50" class="float_a"/>
        </div>
        <br/>
        <br/>
        <span> <s:submit value="提交" class="btn btn-default"></s:submit>
				<s:reset value="重置" class="btn btn-default"></s:reset>
			</span>
    </s:form>
</div>
</body>
</html>