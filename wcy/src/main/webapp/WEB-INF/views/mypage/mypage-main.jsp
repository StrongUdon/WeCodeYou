<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>${login.userName}님의 MYPAGE</h1> 	

	<a href="#">내정보 수정</a> <br>
	<a href="<c:url value='/mypage/leclist' />">수강 목록</a> <br>
	<a href="#">또 뭐가 있지</a> <br>
	<a href="#">생각나면 추가함</a> <br>


<c:if test="${login == null}">
	<script>   
	   alert("로그인이 필요한 서비스입니다.");
	   location.href="<c:url value='/' />";
	</script>
</c:if>	


</body>
</html>