<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script src="${pageContext.request.contextPath}/resources/vendor/js/jquery-3.4.1.js"></script> -->
<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>

   
   이메일 <input type="email" id="userEmail" name="userEmail" value="${user_email}" readonly="readonly"/><span id="emailChk"></span><br>
   
   비밀번호 <input type="password" id="userPw" name="userPw" /><span id="pwChk1"></span><br>
   <span id="pwChk"> </span><br>
   비밀번호 확인 <input type="password" id="userPwChk" name="userPwChk" /><span id="pwChk2"></span><br>
   <span id="pwChk2"> </span><br>
   이름 <input type="text" id="userName" name="userName" /><span id="nameChk"></span><br>
   전화번호 <input type="text" id="userTel" name="userTel" placeholder="-을 제외한 11자리 번호 입력"/><span id="telChk"></span><br>
   생일 <input type="date" id="userBirthday" name="userBirthday" /> <br>
   주소
   <input type="text" name="userZipcode" id="userZipCode" placeholder="우편번호 검색하기" readonly="readonly" onclick="openDaumPostcode('userZipCode','userFirstAddr','userSecondAddr'); return false;" />
   <input type="text" name="userAddress" id="userFirstAddr" readonly="readonly">
   <input type="text" name="userDetailAddress" type="text" id="userSecondAddr" placeholder="상세주소를 입력해주세요" required="required">

   <div id="layer" style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
      <img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnCloseLayer"
         style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1" onclick="closeDaumPostcode()" alt="닫기 버튼">
   </div>
   <br>
   
   <input type="button" id="signup-btn" value="회원가입" />


<script type="text/javascript">


   //start JQuery (회원가입)
   const getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
   const getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
   let chk1 = true, chk2 = false, chk3 = false, chk4 = false, chk5 = false;

   // 1. 회원가입 입력 값 검증 ======================================================================================
   
  
   
   // 2) 비밀번호 입력값 keyup 이벤트
   $('#userPw').on('keyup', function() {
         
         // 비밀번호 공백 체크
         if($("#userPw").val() === ""){
             $('#userPw').css("background-color", "pink");
            $('#pwChk1').html('<b style="font-size:14px;color:red;">비밀번호는 필수 정보 입니다.</b>');
            chk2 = false;
         }               
         // 비밀번호 유효성 검증 (특수문자 포함 8자 이상인지 검사)
         else if(!getPwCheck.test($("#userPw").val()) || $("#userPw").val().length < 8){
             $('#userPw').css("background-color", "pink");
            $('#pwChk1').html('<b style="font-size:14px;color:red;">특수문자 포함 8자 이상으로 입력해주세요.</b>');
            chk2 = false;
         } 
         // 비밀번호 제대로 썼을 때
         else {
            $('#userPw').css("background-color", "aqua");
            $('#pwChk1').html('<b style="font-size:14px;color:green;">사용 가능한 비밀번호입니다.</b>');
            chk2 = true;
         }      
   }); //end - 비밀번호 입력값 keyup 이벤트
   
   // 3) 비밀번호 확인 입력값 keyup 이벤트
   $('#userPwChk').on('keyup', function() {
         
         // 비밀번호 확인란 공백 체크
         if($("#userPwChk").val() === ""){
             $('#userPwChk').css("background-color", "pink");
            $('#pwChk2').html('<b style="font-size:14px;color:red;">비밀번호 확인을 입력해주세요.</b>');
            chk3 = false;
         }               
         // 비밀번호 확인 검증 (비밀번호와 같은지 검사)
         else if($("#userPw").val() != $("#userPwChk").val()){
             $('#userPwChk').css("background-color", "pink");
            $('#pwChk2').html('<b style="font-size:14px;color:red;">비밀번호와 동일하게 입력해주세요.</b>');
            chk3 = false;
         } 
         // 비밀번호 확인 제대로 썼을 떄
         else {
            $('#userPwChk').css("background-color", "aqua");
            $('#pwChk2').html('');
            chk3 = true;
         }
   }); // end - 비밀번호 확인 입력값 keyup 이벤트

   // 4) 이름 입력값 keyup 이벤트
   $('#userName').on('keyup', function() {
         
         // 이름 공백 체크
         if($("#userName").val() === ""){
             $('#userName').css("background-color", "pink");
            $('#nameChk').html('<b style="font-size:14px;color:red;"> 이름은 필수 정보 입니다.</b>');
            chk4 = false;
         }               
         // 이름을 썼을 때
         else {
            $('#userName').css("background-color", "aqua");
            $('#nameChk').html('');
            chk4 = true;
         }
   }); // end - 이름 입력값 keyup 이벤트
   
   // 5) 전화번호 입력값 keyup 이벤트 
   $('#userTel').on('focusout',function(){   
         var trans_tel = $(this).val().replace(/-/gi,'');
            var getTelChk = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/;
         
         // 전화번호 공백 체크
            if($("#userTel").val() === ""){
             $('#userTel').css("background-color", "pink");
            $('#telChk').html('<b style="font-size:14px;color:red;">전화번호를 입력해주세요.</b>');
            chk5 = false;
         }
         // 전화번호 입력값 길이가 11자리가 아닐때
            else if($("#userTel").val().length != 11){
                 $("#userTel").css("background-color", "pink");
               $("#telChk").html('<b style="font-size:14px;color:red;">\'-\'을 제외한 11자리 번호를 입력해주세요.</b>');
               chk5 = false;
            }
         // 전화번호 입력값이 11자리 일때
            else if($("#userTel").val().length == 11){
               // 전화번호 입력 형식에 맞지 않을 때
               if(!getTelChk.test($("#userTel").val())){
                  $("#userTel").css("background-color", "pink");
                  $("#telChk").html('<b style="font-size:14px;color:red;">숫자만 입력해주세요.</b>');
                  chk5 = false;
               }
               // 전화번호 맞게 입력했을 때: 중복확인 비동기 통신
               else{ 
                  trans_tel = trans_tel.replace(/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?([0-9]{3,4})-?([0-9]{4})$/, "$1-$2-$3");  
                  $("#userTel").val(trans_tel);
                  const userTel = $(this).val();
                  console.log(userTel);
                  
                  $.ajax({
                     type: "POST",
                     url : "/member/checkTel",   
                     headers:{
                     "Content-Type": "application/json"
                 },
                 dataType: "text",
                 data: userTel,
                     success: function(result){ 
   
                  if(result === 'OK'){
                     $('#telChk').html('<b style="font-size:14px;color:green;">가입 가능한 번호 입니다.</b>');
                     $("#userTel").css("background-color", "aqua");
                     chk5 = true;   
                       } else {
                     $("#telChk").html("<b style='font-size:14px; color:red;'> 이미 가입된 전화번호입니다. </b>");
                     $("#userTel").css("background-color","pink");
                     chk5 = false;
                         }                        
                      }, 
                      error: function(){      
                            console.log("서버 통신 실패");                   
                      } 
                 
                   });
                } // end - 전화번호 맞게 입력했을 때: 중복확인 비동기 통신  
             } // end - 전화번호 입력값이 11자리 일때
   }); // end - 전화번호 입력값 keyup 이벤트 
   
   // 2. 회원가입 버튼 클릭 이벤트 ======================================================================================
   $("#signup-btn").click(function(){
         
      // 위의 검증을 모두 통과한 경우!!!!!!!!!!!!!!!!!!!!!!!!
      if(chk1 && chk2 && chk3 && chk4 && chk5) { 
         //이메일 정보
         const email = $("#userEmail").val();
         console.log("email: "+email);
            
         //패스워드 정보
         const pw = $("#userPw").val();
         console.log("pw: "+pw);
            
         //이름 정보
         const name = $("#userName").val();
         console.log("name: "+name);
         
         //전화번호
         const tel = $("#userTel").val();
         console.log("tel: "+tel);
         
         //생일
         //const birthday = $("userBirthday").val();
         //console.log("birthday: "+birthday);
           var birthday= document.getElementById('userBirthday');
           console.log(birthday.value);
           
         //주소
         const zip = $("#userZipCode").val();
         const addr = $("#userFirstAddr").val();
         const detail = $("#userSecondAddr").val();
         console.log("zip: "+zip+", addr: "+addr+", detail: "+detail);
         
         //자바스크립트 형태의 객체 생성 (키:값) => 키는 VO의 필드명과 맞춘다
         const mvo={
            userEmail:email,
            userPw:pw,
            userName:name,
            userTel:tel,
            userBirthday:birthday.value,
            userZipcode:zip,
            userAddress:addr,
            userDetailAddress:detail
         };
         
         
         //클라이언트에서 서버와 통신하는 ajax 함수 (비동기 통신: 페이지는 그대로 있고(화면이 고정된 상태에서) 통신하는 것 = 화면이 새로고침 되지 않음 )
         //$.ajax({"key":"value"}); 의 형태로 작성하는데, 가로로 작성하면 가독성이 떨어지기 때문에 세로로 작성!
         $.ajax({
            type: "POST",            //서버에 전송하는 HTTP 요청 방식 (POST, GET, PUT, DELETE)
            url: "/member/",            //url이라고 키를 적고 서버에 요청할 uri만 작성해도됨
            headers: {               //요청 헤더 정보 (데이터 타입 등)
               "Content-Type":"application/json"
            },
            dataType: "text",         //응답받을 데이터의 형태 (text , xml, html, json) ==> 지금 text인 이유는 컨트롤러에서 return 값이 문자열(string)이기 때문에 text로!
            data: JSON.stringify(mvo),   //서버로 전송할 데이터  ,  JSON.stringify(user) ==> user라는 자바스크립트 객체를 JSON으로 바꿔서 서버로 보내라.
            success: function(result){   //통신 성공시 처리할 내용들을 함수 내부에 작성 , 함수의 매개변수는 통신 성공시에 서버가 가져다 줄 데이터가 저장될 곳!
                  
               console.log("통신 성공!: "+result);
               if(result === "joinSuccess"){
                  alert("회원가입 성공!");
                  location.href="/";
               }else{
                  alert("회원가입 실패!");                  
               }
               
            },
            error: function(){         //통신 실패시 처리할 내용들을 함수 내부에 작성
               console.log("통신 실패!");
            }
         });
      }
      // 위의 검증 중에서 하나라도 통과하지 못한 경우!!!!
      else{
         alert("입력하신 정보를 다시 확인해주세요.");
      }
      
   }); //end - 회원가입 버튼 클릭 이벤트

</script>


<!-- 이메일 인증 -->
<script type="text/javascript">
   $(function(){
      //이메일인증 - 발송 버튼 클릭시
      $(document).on("click","#emailBtn",function(){
         //이메일 중복 체크 후 메일 발송 비동기 처리
         $.ajax({
            beforeSend: function(){
               loadingBarStart();
            },
            type:"get",
            url:"<c:url value='/member/createEmailCheck' />",
            data:"userEmail=" + $("#userEmail").val() + "&random=" + $("#random").val(),
            success:function(data){
               alert("사용 가능한 이메일입니다. 인증번호가 발송되었습니다.");
            },
            error:function(data){
               alert("에러가 발생했습니다.");
               return false;
            }
         })
      })
      
      //이메일 인증번호 입력 후 인증 버튼 클릭 이벤트
      $(document).on("click","#emailAuthBtn",function(){
         $.ajax({
            beforeSend:function(){
               loadingBarStart();
            },
            type:"get",
            url:"<c:url value='/member/emailAuth' />",
            data:"authCode=" + $("#emailAuth").val() + "&random=" +$("random").val(),
            success:function(data){
               if(data=="complete"){
                  alert("인증이 완료되었습니다.");
               }else if(data=="false"){
                  alert("인증번호를 잘못 입력하셨습니다.");
               }
            },
            complete:function(){
               loadingBarEnd();
            },
            error:function(){
               alert("에러가 발생했습니다.");
            }
         });
      });
   });
</script>


<!-- 주소 -->
<script>
      var element_layer = document.getElementById('layer');
      //주소 검색 닫아주기
      function closeDaumPostcode() {
         //iframe을 넣은 element를 안보이게 한다.
         element_layer.style.display = 'none';
      }
      //주소 검색 열어주기
      function openDaumPostcode(userZipCode, userFirstAddr, userSecondAddr) {
         new daum.Postcode({
                  oncomplete : function(data) {
                     document.getElementById(userZipCode).value = data.zonecode;
                     document.getElementById(userFirstAddr).value = data.address;
                     document.getElementById(userSecondAddr).focus();
                     element_layer.style.display = 'none';
                  },
                  width : '100%',
                  height : '100%'
               }).embed(element_layer);
         element_layer.style.display = 'block';
         initLayerPosition();
      }
      //팝업창 세부 설정
      function initLayerPosition() {
         var width = 300; //우편번호서비스가 들어갈 element의 width
         var height = 460; //우편번호서비스가 들어갈 element의 height
         var borderWidth = 5; //샘플에서 사용하는 border의 두께
         //위에서 선언한 값들을 실제 element에 넣는다.
         element_layer.style.width = width + 'px';
         element_layer.style.height = height + 'px';
         element_layer.style.border = borderWidth + 'px solid';
         //실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
         element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width) / 2 - borderWidth)
               + 'px';
         element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height) / 2 - borderWidth)
               + 'px';
      }
</script>
   
   
</body>
</html>