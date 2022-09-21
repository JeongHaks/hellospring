<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.EmaillistVo" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="/hellospring/addd" method="post">
		name (이름):<input type="text" name="name" ><br>
		password (비밀번호): <input type="password" name="password" ><br>
		content (내용) : <input type="text" name="content" ><br>	
		<input type="submit" value="등록">
	</form>
	<br>
	<p>
		<a href="/hellospring/getGuestbookList">리스트 바로가기</a>
	</p>
</body>
</html>