<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" 
crossorigin="anonymous"></script>
</head>
<body>
	<div>임시 유저번호: ${userNo}</div>
	<br>
	<%-- <form id="interest-form" action="<c:url value='/interest_list/insertInterest'/>" method="post"  onsubmit="return formCheck()"> --%>
	<!-- 전체 설문조사 리스트에서 타입의 수 (예: 4개) 만큼 반복해서 체크박스 생성  -->
	<c:forEach var="type" items="${typeList}" varStatus="status" >
		<c:set var="t1" value="${type.interestListType}" />
			${type.interestListQuestion}<br>
			<c:forEach var="all" items="${allInterest}" >
				<c:set var="a1" value="${all.interestListType}" />
					<c:if test="${a1 eq t1}">
    					<input type="checkbox" name="${status.index}" value="${all.interestListId}" class="${status.index}" 
    						 >${all.interestListAnswer} 
					</c:if>
			</c:forEach>
			<br><br>
	</c:forEach>
	<input type="button" id="insert-btn" value="완료">
	<!-- </form>-->
	<br><br><br>
	<!-- 설문조사 건너뛰기 버튼 -->
	<button id="btn-skip" onclick="location.href='메인.jsp'">Skip</button>
	
<script>  /* type="text/javascript" */

	/* 전체 타입 목록 개수 */
	const n = 4;
	
	// insert-btn 클릭 이벤트
	$("#insert-btn").click(function() {
	//function formCheck(){
		let map = new Map();
		var option_cnt = 0; 
		for (var i = 0; i < n; i++) {
			var chkbox = $("." + i); //class명 
			for (j = 0; j < chkbox.length; j++) {
				if (chkbox[j].checked == true) {
					map.set(option_cnt, chkbox[j].value);
					console.log("map: " +map + " getting value of map: " + map.get(option_cnt));
					option_cnt++;
				}
			}
		}
		console.log("처리완료");
		
		//Ajax로 값 넘기기 (InterestVO 객체로)
		const interestUserNo = ${userNo};
		const interestIndex0 = map.get(0);
		const interestIndex1 = map.get(1);
		const interestIndex2 = map.get(2);
		const interestIndex3 = map.get(3);
		const interestIndex4 = map.get(4);
		const interestIndex5 = map.get(5);
		
		const ivo = {
				interestUserNo : interestUserNo,
				interestIndex0 : interestIndex0,
				interestIndex1 : interestIndex1,
				interestIndex2 : interestIndex2,
				interestIndex3 : interestIndex3,
				interestIndex4 : interestIndex4,
				interestIndex5 : interestIndex5
		};
		
		$.ajax({
			type: "POST",
			url: "/interest/insertInterest",
			headers: {
                "Content-Type": "application/json"
            },
			data: JSON.stringify(ivo),
			dataType : "text",
			success: function(data) {
				console.log("통신성공 ! result: " + data);
				document.write("통신성공 ! result: " + data);
				if(data === "success") {
			    	console.log("입력성공!");
			    	document.write("입력성공!");
					//self.location="/wecodeyou/WEB-INF/views/interest/interest-result.jsp";
				}else if(data === "already exist") {
					console.log("이미 설문조사를 완료하셨습니다. 입력실패!");
					document.write("이미 설문조사를 완료하셨습니다. 입력실패!");
				}
			},
			error: function(){
				console.log("통신실패!");
				document.write("통신실패!");
			}
		});
	//}
	});
	
</script>
</body>
</html>