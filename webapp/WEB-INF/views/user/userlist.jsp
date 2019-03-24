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
	<h1>用户列表如下：</h1>
	<c:if test="${userList!=null && fn:length(userList)>0 }">
		<table class="user">
			<tr>
				<td class="user">ID</td>
				<td class="user">用户ID</td>
				<td class="user">用户名</td>
			</tr>
			<c:forEach var="user" items="${userList }">
				<tr>
					<td class="user">${user.id }</td>
					<td class="user">${user.userId }</td>
					<td class="user">${user.userName }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<h1>添加用户</h1>
	<form action="addUser" method="post">
		用户ID：<input type="text" name="userName" />
		用户名：<input type="text" name="userId" />
		密码: <input type="password" name="password" />
		<input type="submit" value="提交" />
	</form>
	
	<h1>退出登录</h1>
	<form action="logout" method="post">
		<input type="submit" value="注销" />
	</form>
</body>
</html>