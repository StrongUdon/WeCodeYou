<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="${pageContext.request.contextPath}/resources/vendor/js/jquery-3.4.1.js"></script>


</head>
<body>


<form action="<c:url value='/member/join' />" method="post">
      비밀번호 <input type="password" id="userPw" name="userPw" required="required" /> <br>
   비밀번호 확인 <input type="password" id="userPwChk" name="userPwChk" required="required" /> <br>
   <input type="submit" value="회원가입"/>

</form>



<script type="text/javascript">
$('#btn').click(function() {
	  $('#ele').removeClass('hidden');
	});
	$('#ele').focusout(function() {
	  $(this).addClass('hidden');
	});

$("#userPw").focusout(function() {
    
    const pwInput = $(this);
    var extpw = /^.*(?=^.{6,}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
    
    
    if(pwInput.val().length < 6){   // 입력 안했을 때
       $("#pwChk").html("<b style='color:red;'>[6자 이상 비밀번호를 입력해주세요!]</b>")
       pwInput.css("background", "#fad7da");
       $("#signup-btn").prop("disabled", true);
       pwsw = 0;
    }else{
       if(extpw.test(pwInput.val()) == false){
          $("#pwChk").html("<b style='color:red;'>[소문자,숫자,특수문자를 포함시켜야 합니다.] </b>")
          pwInput.css("background", "#fad7da");
          $("#signup-btn").prop("disabled", true);
          pwsw = 0;
       }else{
          $("#pwChk").html("<b style='color:green;'>[비밀번호 확인을 입력해 주세요.]</b>")
          pwInput.css("background","#e8f0fe");
          pwsw = 1;
       }
    }
    
    
}); //pw_check end

//비밀번호 확인란 입력 이벤트
 $("#userPwChk").focusout(function() {

    let pwCheckVal = $(this).val();
    let pwVal = $("#pw").val();

    if (pwCheckVal === "") {
       $(this).css("background", "#fad7da");
       $("#pwChk2").html("<b style='color:red;'>[비밀번호확인은 필수 정보에요!]</b>")
       $("#signup-btn").prop("disabled",true);
       pwsw = 0;
       } else if (pwCheckVal !== pwVal) {
          $(this).css("background", "#fad7da");
          $("#pwChk2").html("<b style='color:red;'>[비밀번호와 똑같이 쓰세요!! ]</b>")
          $("#signup-btn").prop("disabled",true);
          pwsw = 0;
       } else {
          $(this).css("background", "#e8f0fe");
          $("#pwChk2").html("<b style='color:green;'>[사용가능한 비밀번호입니다!]]</b>")
          pwsw = 1;
          console.log(pwsw); 
          
       }
    });//end PwCheck Event
</script>

</body>
</html>