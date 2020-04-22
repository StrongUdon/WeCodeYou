<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
</head>
<body>
<h1> wecodeyou 로그인</h1>
<p>이메일</p><span id="emailCheck"></span><br>
<input type="text" name="userEmail" id="userEmail" required="required" aria-required="true" placeholder="aaa@google.com">
<br><br>
<p>비밀번호</p><span id="pwCheck"></span><br>
<input type="password" name="userPw" id="userPw" required="required" aria-required="true">
<br><br>
<input type="button" id="login-btn" value="로그인">




<script>
$(function(){
	
	const getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
	const getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	let chk1 = false, chk2 = false;

	// 1. 로그인 입력값 검증 =======================================================================
	// 1) 이메일 입력값 keyup 검증
	$("#userEmail").on("keyup",function(){
		// 이메일 공백
		if($("#userEmail").val() == ""){
			$('#userEmail').css("background-color", "pink");
			$('#emailCheck').html('<b style="font-size:14px;color:red;">이메일을 입력해주세요.</b>');
			chk1 = false;
		}
		// 이메일 유효성 검증
		else if(!getMail.test($("#userEmail").val())){
			$('#userEmail').css("background-color", "pink");
			$('#emailCheck').html('<b style="font-size:14px;color:red;">이메일 형식에 맞게 입력해주세요.</b>');
			chk1 = false;
		}
		// 이메일 통과한 경우
		else{
			$('#userEmail').css("background-color", "aqua");
			$('#emailCheck').html('');
			chk1 = true;
		}
	}); // end - 이메일 입력값 검증
	
	// 2) 패스워드 입력값 keyup 검증
	$("#userPw").on("keyup",function(){
		// 패스워드 공백
		if($("#userPw").val() == ""){
			$('#userPw').css("background-color", "pink");
			$('#pwCheck').html('<b style="font-size:14px;color:red;">비밀번호를 입력해주세요.</b>');
			chk2 = false;
		}
		// 패스워드 유효성 검증
		else if(!getPwCheck.test($("#userPw").val())){
			$('#userPw').css("background-color", "pink");
			$('#pwCheck').html('<b style="font-size:14px;color:red;">특수문자 포함 8자 이상으로 입력해주세요.</b>');
			chk2 = false;
		}
		// 패스워드 통과한 경우
		else{
			$('#userPw').css("background-color", "aqua");
			$('#pwCheck').html('');
			chk2 = true;
		}
	});
	
	// 2. 로그인 버튼 click 이벤트 =================================================================
	$("#login-btn").click(function() {
		// 위의 검증을 모두 통과한 경우!!!!!!!!!!!!!
		if(chk1 && chk2) {
			//ajax통신으로 서버에서 값 받아오기
			const email = $('#userEmail').val();
			const pw = $('#userPw').val();
			
			console.log("id: " + email);
			console.log("pw: " + pw);
			
			const mvo = {
					userEmail : email,
					userPw : pw
			};
			
			$.ajax({
				type: "POST",
				url: "/member/loginCheck",
				headers: {
	                "Content-Type": "application/json"
	            },
				data: JSON.stringify(mvo),
				dataType : "text",
				success: function(data) {
					console.log("통신성공 ! result: " + data);	
					
					if(data === "emailFail") {
						$('#userEmail').css("background-color", "pink");
						$('#emailCheck').html('<b style="font-size:14px;color:red;">존재하지 않는 이메일입니다. 회원가입 해주세요.</b>');
						$('#userPw').val("");
						$('#userEmail').focus();
						chk2 = false;
				    } else if(data === "pwFail") {
						$('#userPw').css("background-color", "pink");
						$('#pwCheck').html('<b style="font-size:14px;color:red;">비밀번호가 틀렸습니다.</b>');
						$('#userPw').val("");
						$('#userPw').focus();
						chk2 = false;
					} else if(data === "loginSuccess") {
						self.location="/";
					}
				},
				error: function(){
					console.log("통신실패!");
				}
			});
			
		}
		// 위의 검증 중에 하나라도 통과하지 못한 경우!!!!!!!!!!!!!
		else {
			alert("입력정보를 다시 확인하세요!");
		}
	});
		
		
	
}); //end - jquery
</script>

</body>
</html>






