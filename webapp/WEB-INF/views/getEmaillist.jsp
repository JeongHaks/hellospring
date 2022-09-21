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
      <th>lastName</th>
      <th>firstName</th>
      <th>email</th>      
    </tr>
    
    <c:forEach items="${emaillist}" var="emaillist1">
    <tr>
      <td>${emaillist1.no}</td>
      <td>${emaillist1.lastName}</td>
      <td>${emaillist1.firstName}</td>
      <td>${emaillist1.email}</td>   
      <td>
      <a href="/hellospring/delete/${emaillist1.no }">삭제</a>   
      </td>
    </tr>
    </c:forEach>
     
  </table>
</body>
</html>