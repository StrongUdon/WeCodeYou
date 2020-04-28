<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span>입력한 이메일에서 인증번호 확인 후 아래에 입력해주세요.</span><br>
	
	<form action="<c:url value='/member/join_auth' />" method="post">
		<table border="1">
			<tr>
				<td>인증번호 입력: <input type="number" name="email_auth" placeholder="인증번호를 입력해주세요"> </td>
			</tr>
		</table>
		<button type="submit" name="submit"> 이메일 인증하기</button>
		<input type="hidden" name="dice" value="${dice}" />
	</form>
</body>
</html>