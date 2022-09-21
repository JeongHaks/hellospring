<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function check(){
    var pass = document.getElementById("pass");
    if(${boardVo.password}!=pass.value){
  	  alert("비밀번호가 틀렸습니다. 다시 입력해 주세요(숫자만 가능합니다.)");
       password.focus();
       return false;
    }
 }


</script>
	<form action="/hellospring/deletee" method="GET">
		<input type='hidden' name="no" value="${param.no }">
		<input type='hidden' name="password" value="${param.password }"> 
 		password (비번) : <input type="password" id="pass" name="pass"><br>
		<input type="submit" onClick="return check()" value="확인">		
	</form>
	<br>
	<p>
		<a href="/hellospring/getGuestbookList">리스트 바로가기</a>

</body>
</html>