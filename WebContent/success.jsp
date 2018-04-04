<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
<center>
<h2>该用户信息如下：</h2>
<font color="red">登录成功!</font><br>
<s:bean name="com.cy.domain.User" id="user"></s:bean>
用户名：<s:property value="username"/><br>

<!-- 利用LoginAction.java页面中保存的user对象，使用userInfo获取对象的属性值 -->
医保卡号：${userInfo.pcnumber}<br>
医保状态：${userInfo.state}

</center>
</body>
</html>