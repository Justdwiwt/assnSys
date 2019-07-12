<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/user.css"/>
    <link rel="stylesheet" type="text/css" href="../css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="../css/htmleaf-demo.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>成员信息</title>
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
<table class="table">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>所属社团</th>
        <th>手机</th>
        <th>邮箱</th>
        <th>地址</th>
        <th>职务</th>
        <th>修改</th>
    </tr>
    <s:iterator value="result" var="uData" status="st">
        <tr>
            <td>${st.count}</td>
            <td><s:property value="userName"/></td>
            <td><s:property value="sex"/></td>
            <td><s:property value="assnName"/></td>
            <td><s:property value="phone"/></td>
            <td><s:property value="email"/></td>
            <td><s:property value="address"/></td>
            <td><s:property value="job"/></td>
            <td>
                <s:a action="update">
                    <s:param name="uData.userId" value="userId"></s:param>
                    修改</s:a>&nbsp;|&nbsp;
                <s:a action="delete">
                    <s:param name="uData.userId" value="userId"></s:param>
                    删除</s:a></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>