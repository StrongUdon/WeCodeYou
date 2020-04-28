<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>

</head>
<body>
  
   <span>이메일 인증을 받아야 다음단계로 넘어갈 수 있습니다.</span><br>
   <form action="<c:url value='/member/auth' />" method="post">
      <table border="1">
         <tr>
            <td>이메일 : <input type="email" name="userEmail" id="userEmail" placeholder="이메일 주소를 입력하세요."></td>
            <td><button type="button" id="check_btn"  onclick="isOverRap()">중복 체크</button></td>
         </tr>
      </table>
      <button type="submit" name="submit" id="submit_btn">이메일로 인증번호 발송</button>
   </form>
   <span id="emailChk"></span>
<script type="text/javascript">

   let chk1 = true
   const getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
    
   $('#userEmail').on('focusout',function(){  
        if(!getMail.test($("#userEmail").val())){
               $('#userEmail').css("background-color","pink");
               $("#emailChk").html("<b style='font-size:14px; color:red;'> 이메일 형식이 잘못 되었습니다. </b>");
               $("#submit_btn").prop("disabled",true);
            }
   });
   
// 1) 이메일 중복확인 onclick 이벤트
function isOverRap(){
   
   var email = document.getElementById('userEmail');  
   
    // 이메일 공백 체크
      if($(email).val()===""){
         $('#userEmail').css("background-color","pink");
         $("#emailChk").html("<b style='font-size:14px; color:red;'> 이메일은 필수 정보입니다. </b>");
         $("#submit_btn").prop("disabled",true);
      }
      // 이메일 유효성 검증 (형식에 맞는지 검사)
      else if(!getMail.test($("#userEmail").val())){
         $('#userEmail').css("background-color","pink");
         $("#emailChk").html("<b style='font-size:14px; color:red;'> 이메일 형식이 잘못 되었습니다. </b>");
         $("#submit_btn").prop("disabled",true);
      }
      // 이메일 제대로 썼을 때: 중복확인 비동기 통신
      else{
      
         $.ajax({
            type:"POST",
            url:"/member/checkEmail",
            headers:{
               "Content-Type":"application/json"
            },
            dataType:"text",
            data:$(email).val(),
            success:function(result){
               if(result==="OK"){
                  $("#userEmail").css("background-color","aqua");
                  $("#emailChk").html("<b style='font-size:14px; color:green;'> 사용가능한 이메일입니다. </b>");
               } else{
                  $("#userEmail").css("background-color","pink");
                  $("#emailChk").html("<b style='font-size:14px; color:red;'> 이미 가입된 이메일입니다. </b>");
               }
               $("#submit_btn").prop("disabled",false);
            },
            error:function(){
               console.log("서버와 통신 실패");
            }
         });
      }   
}
   


</script>

</body>
</html>