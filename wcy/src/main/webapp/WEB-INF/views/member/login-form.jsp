<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
<script src="<c:url value = "/vendor/js/kakao.js"/>"></script>


</head>
<body>
<h1> wecodeyou 로그인 </h1>
<p>이메일</p><span id="emailCheck"></span><br>
<input type="text" name="userEmail" id="userEmail" required="required" aria-required="true" placeholder="aaa@google.com">
<br><br>
<p>비밀번호</p><span id="pwCheck"></span><br>
<input type="password" name="userPw" id="userPw" required="required" aria-required="true">
<br><br>
<input type="button" id="login-btn" value="로그인">
<a href="<c:url value='/member/find-form?target=email' />" ><button>이메일 찾기</button></a>
<a href="<c:url value='/member/find-form?target=pw' />" ><button>비밀번호 찾기</button></a>

<a id="kakao-login-btn"></a>
  
  <script type='text/javascript'>
  
 	var form = document.createElement("form"); //form 생성
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post"); 
	form.setAttribute("action", "<c:url value='/member/kakao' />");
	
	var emailField = document.createElement("input");
	emailField.setAttribute("type", "hidden");
	emailField.setAttribute("name", "email");
	form.appendChild(emailField);
  
 	var imageField = document.createElement("input");
	imageField.setAttribute("type", "hidden");
	imageField.setAttribute("name", "image");
	form.appendChild(imageField); 

 	var birthField = document.createElement("input");
	birthField.setAttribute("type", "hidden");
	birthField.setAttribute("name", "birth");
	form.appendChild(birthField); 

	var nickField = document.createElement("input");
	nickField.setAttribute("type", "hidden");
	nickField.setAttribute("name", "nickname");
	form.appendChild(nickField); 
	
	
	document.body.appendChild(form);

    //<![CDATA[
   // 사용할 앱의 JavaScript 키를 설정해 주세요.
   Kakao.init('74411014588edc9828d086e4e4698792');
   
   // 카카오 로그인 버튼을 생성합니다.
   Kakao.Auth.createLoginButton({
    container: '#kakao-login-btn',
    scope: 'account_email,birthday',
 
    success: function(authObj) {
     
     // 로그인 성공시, API를 호출합니다.
     Kakao.API.request({
      url: '/v2/user/me',
      success: function(res) {
       console.log(res);
       
       
       var id = res.id;      //유저의 카카오톡 고유 id
       var email = res.kakao_account.email;   
       var nickname = res.properties.nickname; 
       var image = res.properties.profile_image; 
       var birth = res.kakao_account.birthday; 
       //존재하지 않으면 undefined
       
       emailField.setAttribute("value", email);
       imageField.setAttribute("value", image);
       birthField.setAttribute("value", birth);
       nickField.setAttribute("value", nickname);
	   form.submit();
       
      },
      fail: function(error) {
       alert(JSON.stringify(error));
      }
     });
    },
    fail: function(err) {
     alert(JSON.stringify(err));
    }
   });
    //]]>
  </script>


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






