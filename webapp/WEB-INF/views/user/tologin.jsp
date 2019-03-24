<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css">
	<title>主页</title>
</head>
<body>
	<h1>请登录：</h1>
	<form action="login" method="post">
		用户ID：<input type="text" name="userName" />
		密码: <input type="password" name="password" />
		<input type="submit" value="提交" />
	</form>
</body>
</html>