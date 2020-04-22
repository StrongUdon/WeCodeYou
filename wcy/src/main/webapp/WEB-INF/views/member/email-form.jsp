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
	<span>이메일 인증을 받아야 다음단계로 넘어갈 수 있습니다.</span><br>
	<form action="<c:url value='/member/auth' />" method="post">
		<table border="1">
			<tr>
				<td>이메일 : <input type="email" name="userEmail" id="userEmail" placeholder="이메일 주소를 입력하세요."></td>
			</tr>
		</table>
		<button type="submit" name="submit">이메일로 인증번호 발송</button>
	</form>


<script>



</script>



</body>
</html>