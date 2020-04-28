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

<a href="<c:url value='/off/seat?seat=30' />" ><button>30자리 강의실</button></a>
<a href="<c:url value='/off/seat?seat=24' />" ><button>24자리 강의실</button></a>
<a href="<c:url value='/off/seat?seat=15' />" ><button>15자리 자습실</button></a>
<a href="<c:url value='/off/seat?seat=8' />" ><button>8자리 시험실</button></a>
<a href="<c:url value='/off/test' />" ><button>테스트</button></a>

</body>
</html>