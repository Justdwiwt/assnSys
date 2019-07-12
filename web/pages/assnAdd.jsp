<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>添加社团</title>
</head>
<body>
<s:form action="save" method="post">
    <s:hidden name="assnData.assnId"></s:hidden>
    <table>
        <caption>注册</caption>
        <tr>
            <td>社团名：<s:textfield name="assnData.assnName" size="20"/></td>
        </tr>
        <tr>
            <td>社团负责人：<s:textfield name="assnData.assnChairman" size="20"/></td>
        </tr>
        <tr>
            <td>指导教师：<s:textfield name="assnData.assnTeacher" size="20"/></td>
        </tr>
    </table>
    <s:submit value="提交"></s:submit>
    <s:reset value="重置"></s:reset>
</s:form>
</body>
</html>