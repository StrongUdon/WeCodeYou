<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사</title>
</head>
<body>
${userNo }
	<!-- 설문조사 건너뛰기 버튼 -->
	<button id="btn-skip" onclick="location.href='메인화면.jsp'">Skip</button>
	
	<!-- 설문조사 폼 -->
	<form id="interest-form" action="interest_result.jsp" method="post" onsubmit="return formCheck()">
		<div>
			<label for="lang[]">관심있는 분야는? (최대 3개까지 선택)</label>
			<div>
				<!-- 최대 3개까지 선택 -->
				<input type="checkbox" name="lang" value="lang-1" onclick="check(this,check_q1(this),3);" >자바 
				<input type="checkbox" name="lang" value="lang-2" onclick="check(this,check_q1(this),3);" >자바스크립트
				<input type="checkbox" name="lang" value="lang-3" onclick="check(this,check_q1(this),3);" >HTML 
				<input type="checkbox" name="lang" value="lang-4" onclick="check(this,check_q1(this),3);" >CSS
				<input type="checkbox" name="lang" value="lang-5" onclick="check(this,check_q1(this),3);" >JSP
				<input type="checkbox" name="lang" value="lang-6" onclick="check(this,check_q1(this),3);" >Spring
			</div>
		</div>
		<br>
		<div>
			<label for="period">IT 교육을 이수한 기간은?</label>
			<div>
				<!-- 최대 1개까지 선택 -->
				<input type="checkbox" name="period" value="period-1" onclick="check(this,check_q1(this),2);" >3개월 미만
				<input type="checkbox" name="period" value="period-2" onclick="check(this,check_q1(this),2);" >3개월 이상 ~ 6개월 미만
				<input type="checkbox" name="period" value="period-3" onclick="check(this,check_q1(this),2);" >6개월 이상 ~ 1년 미만
				<input type="checkbox" name="period" value="period-4" onclick="check(this,check_q1(this),2);" >1년 이상 ~ 2년 미만
				<input type="checkbox" name="period" value="period-5" onclick="check(this,check_q1(this),2);" >2년 이상 ~ 전공자
			</div>
		</div>
		<br>
		<div>
			<label for="goal">WeCodeYou에 가입한 이유는?</label>
			<div>
				<!-- 최대 1개까지 선택 -->
				<input type="checkbox" name="goal" value="goal-1" onclick="check(this,check_q1(this),2);" >취미
				<input type="checkbox" name="goal" value="goal-2" onclick="check(this,check_q1(this),2);" >취업
				<input type="checkbox" name="goal" value="goal-3" onclick="check(this,check_q1(this),2);" >실무능력 향상
				<input type="checkbox" name="goal" value="goal-4" onclick="check(this,check_q1(this),2);" >자료 참고
			</div>
		</div>
		<br>
		<div>
			<label for="funnel">WeCodeYou 방문 경로? </label>
			<div>
				<!-- 최대 1개까지 선택 -->
				<input type="hidden" name="maxCnt4" value="1" /> 
				<input type="checkbox" name="funnel" value="funnel-1" onclick="check(this,check_q1(this),2);" >지인 추천
				<input type="checkbox" name="funnel" value="funnel-2" onclick="check(this,check_q1(this),2);" >인터넷 검색
				<input type="checkbox" name="funnel" value="funnel-3" onclick="check(this,check_q1(this),2);" >연관검색어
				<input type="checkbox" name="funnel" value="funnel-4" onclick="check(this,check_q1(this),2);" >SNS광고
			</div>
		</div>
		<div><input type=submit value="등록"></div>
	</form>

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
	    if(condition == false){
	        obj.checked = false;
	        alert("최대 "+ n + "개까지 선택할 수 있습니다.");
	    }
	}


	
</script>
</body>
</html>