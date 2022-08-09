<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="net.javaguides.login.database.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div align="center">
	    <p>Thông tin học sinh</p>
	    <form action="<%=request.getContextPath()%>/themhocsinh" method="post">
		<table style="with: 100%">
				<tr>
					<td>Tên</td>
					<td><input type="text" name="ten" /></td>
				</tr>
				<tr>
					<td>Họ và tên đệm</td>
					<td><input type="password" name="hovatendem" /></td>
				</tr>
				<tr>
					<td>Lớp</td>
					<td><input type="password" name="lop" /></td>
				</tr>
		</table>
		<input type="submit" value="Nhập" style="left: 0;" />
		</form>
		
		<p>Thông tin học sinh</p>
		<table>
			  <c:forEach items="${lst}" var="item">
			    <tr>
			      <td><c:out value="${item.hovaten}" /></td>
			    </tr>
			  </c:forEach>
		</table>

	</div>
</body>
</html>