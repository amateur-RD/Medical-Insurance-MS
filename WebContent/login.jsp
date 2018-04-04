<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<center>

<s:if test="sign==1">
	<font style="font-size:16px;color:red;">密码错误！</font>
</s:if>

<s:form action="login" method="post">
	<s:textfield name="username" label="用户名" cssStyle="width:160px;heigh:26px;" />
	<s:password name="password" label="密    码" cssStyle="width:160px;heigh:26px;" />
	<s:submit value="登录" />
</s:form>

</center>
</body>
</html>