<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <table border=1 cellpadding=0 cellspacing=0>
    <tr>
      <th>no</th>
      <th>name</th>
      <th>content</th>
      <th>reg_date</th>
      <th>삭제</th>
    </tr>
    
    <c:forEach items="${guestbookList}" var="guestbook">
    <tr>
      <td>${guestbook.no}</td>
      <td>${guestbook.name}</td>
      <td>${guestbook.content}</td>
      <td>${guestbook.regDate}</td>
      <td>
       <a href="/hellospring/deleteform?no=${guestbook.no }&password=${guestbook.password}">삭제</a>      
      </td>      
    </tr>
    </c:forEach>      
  </table>
  	<div>
    	<button type="button" onclick="location.href='/hellospring/guestform' ">등록</button>
    </div>
</body>
</html>