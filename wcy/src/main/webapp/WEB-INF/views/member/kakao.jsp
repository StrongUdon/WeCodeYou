<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="<c:url value = "/resources/vendor/js/kakao.js"/>"></script>

<body>

카카오 로그인 샘플<br>


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



</body>
</html>