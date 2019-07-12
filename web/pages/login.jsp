<%@page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel='stylesheet'
          href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
    <link rel="stylesheet" type="text/css" href="../css/login.css"/>
    <title>社团成员管理系统</title>
    <style type="text/css">
        .form-group a {
            text-decoration: none;
            color: #494A5F;
        }

        .form-group a:hover {
            text-decoration: none;
            color: #FFFFFF;
        }
    </style>
</head>
<body class="body">
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <s:form action="login" method="post" class="form-horizontal">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <s:textfield name="user.rootName" class="form-control"
                                 id="inputEmail3" placeholder="用户名或电子邮件"/>
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <s:password name="user.pwd" class="form-control"
                                id="inputPassword3" placeholder="密　码"></s:password>
                    <i class="fa fa-lock"></i> <a href="#"
                                                  class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <s:submit value="登录" class="btn btn-default"></s:submit>
                </div>
            </s:form>
        </div>
    </div>
</div>
</body>
</html>