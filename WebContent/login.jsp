<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1 style="left: 0;">Đăng nhập</h1>
		<form action="<%=request.getContextPath()%>/nhaphocsinh" method="post">
			<table style="with: 100%">
				<tr>
					<td>Tài khoản</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Mật khấu</td>
					<td><input type="password" name="password" /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" style="left: 0;" />
		</form>
	</div>
</body>
</html>