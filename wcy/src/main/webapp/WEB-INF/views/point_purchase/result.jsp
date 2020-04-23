<%@page import="com.it.wecodeyou.member.model.MemberVO"%>
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


<h1 align ="center">결제완료</h1>
<hr>
<br>

<table border = 1 align ="center">

<tr><td>주문번호</td><td>${recent.pointPurchaseId}</td>
<tr><td>결제일시</td><td>${recent.pointPurchasePurchasedAt}</td>
<tr><td>결제금액</td><td>${recent.pointPurchaseAmount}</td>
<tr><td colspan = 2><a href = "<c:url value='/' />">홈으로</a></td></tr>
</table>


</body>
</html>