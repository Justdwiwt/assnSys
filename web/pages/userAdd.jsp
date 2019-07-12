<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>添加成员</title>
</head>
<body>
<s:form action="save" method="post">
    <s:hidden name="userData.userId"></s:hidden>
    <table>
        <caption>注册</caption>
        <tr>
            <td>姓名：<s:textfield name="userData.userName" size="20"/></td>
        </tr>
        <tr>
            <td>性别：<s:textfield name="userData.sex" size="20"/></td>
        </tr>
        <tr>
            <td>社团名称：<s:textfield name="userData.assnName" size="20"/></td>
        </tr>
        <tr>
            <td>手机：<s:textfield name="userData.phone" size="20"/></td>
        </tr>
        <tr>
            <td>邮箱：<s:textfield name="userData.email" size="20"/></td>
        </tr>
        <tr>
            <td>地址：<s:textfield name="userData.address" size="20"/></td>
        </tr>
        <tr>
            <td>职务：<s:textfield name="userData.job" size="20"/></td>
        </tr>
    </table>
    <s:submit value="提交"></s:submit>
    <s:reset value="重置"></s:reset>
</s:form>
</body>
</html>