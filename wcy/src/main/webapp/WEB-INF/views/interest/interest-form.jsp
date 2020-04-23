<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사</title>
</head>
<body>
	<div>임시 유저번호: ${userNo}</div>
	
	<br>
	<form id="interest-form" action="<c:url value='/interest/insertInterest'/>" method="post" onsubmit="return formCheck()">
	<!-- 전체 설문조사 리스트에서 타입의 수 (예: 4개) 만큼 반복해서 체크박스 생성  -->
	<c:forEach var="type" items="${typeList}">
		<c:set var="t1" value="${type.interestListType}" />
<%-- 		<c:set var="o1" value="${type.interestListOption}"/>
		<input type="hidden" name="" value="${type.interestListOption}" id="o1" />
		<c:out value="${o1}"/><br> --%>
		${type.interestListQuestion}<br>
			<c:forEach var="all" items="${allInterest}">
				<c:set var="a1" value="${all.interestListType}" />
					<c:if test="${a1 eq t1}">
    					<input type="checkbox" name="${all.interestListType}" value="${all.interestListId}" 
    						onclick="check(this,check_q1(this),3);" >${all.interestListAnswer} 
					</c:if>
			</c:forEach>
			<br><br>
	</c:forEach>
	<input type=submit value="등록">
	</form>
	

	<br><br><br>
	<!-- 설문조사 건너뛰기 버튼 -->
	<button id="btn-skip" onclick="location.href='메인.jsp'">Skip</button>
	
	
<script type="text/javascript">

	function formCheck(){
		
		var chk1 = document.getElementsByName("lang");
		var chk2 = document.getElementsByName("period");
		   var checked = 0;
		   for (i=0; i < chk1.length; i++) {
		       if (chk1[i].checked == true) {
		           checked += 1;
		       }
		   }
		   if (checked < 1 ) {
		       alert("최소 1개를 선택해주세요.");
		       return false;
		   }
	}
	
	var count = 0;
	function check_q1(chk_obj1) {
	    if(chk1.checked == true) {
	        count++;
	    } else {
	        count--;
	    }
	    if(count <= 3) {
	        return true;
	    } else {
	        count--;
	        return false;
	    }
	}

	function check(obj,condition, n) {
		/* n = getElementById('o1').val(); */
	    if(condition == false){
	        obj.checked = false;
	        alert("최대 "+ n + "개까지 선택할 수 있습니다.");
	    }
	}


	
</script>
</body>
</html>