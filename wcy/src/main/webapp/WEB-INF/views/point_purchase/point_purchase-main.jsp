<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%


%>

<h1>�������� �׽�Ʈ ������</h1>
<form action = "<c:url value = "/pay/"/>" method = "post">

<input type = "hidden">
<input type = "submit" value = "login">
</form>

<form action = "<c:url value = "/pay/gopay"/>" method = "post">

������ ����Ʈ<input type = "text" value = "50000" name = "point"> 

</form>




</body>
</html>