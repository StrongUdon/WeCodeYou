<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
<style>
        .modal {
            display: none; 
            position: fixed; /* 위치 고정 */
            z-index: 1; /* 맨 위로 띄우기 */
            left: 0;
            top: 0;
            max-width: 100%;
            width: 100%;
            height: 100%; 
            overflow: auto; /* 내용이 길어지면 스크롤 */
        }
      
      .modal button {
         display:inline-block;
         width:100px;
         margin-left:calc(100% - 100px - 10px);
      }
      
      .modal .modal_content {
            /*border: 1px solid transparent;*/
            border: 10px solid transparent;
            border-radius: 10px; /* 테두리를 살짝 둥글게 */
            width: 40%; /* Could be more or less, depending on screen size */ 
            height: 450px;
            margin: 5% auto; /* 위와 중앙에서 5% 떨어지게 */
            padding: 10px;  /*모달과 모달 컨텐츠가 20px 떨어지게 */
            background-color: #fefefe; /* 모달 컨텐츠 컬러 */
            animation-name: animatetop;/* 에니메이션 */
            animation-duration: 0.6s
         
      }
        /* Add Animation */
            @keyframes animatetop {
            from {top: -300px; opacity: 0}
            to {top: 0; opacity: 1}
        }
    
        .modal .modal_layer {
         position:fixed;
         top:0;
         left:0;
         width:100%;
         height:100%;
         background-color: rgb(0,0,0); /* 투명도가 적용 안 될 때의 fallback color */
         background-color: rgba(0,0,0,0.3); /* 검정 투명도 */
         z-index:-1; /*가장 앞에 나오도록 제일 낮은 값 부여*/
      }
        
        .modal .modal_title_large {
            display: inline-block;
            font-size: 30px;
            font-weight: bold;
            max-width: 180%;
            color:black;
            overflow: hidden;
            padding-bottom: 20px;
            text-overflow: ellipsis;
            vertical-align: middle;
        }
        
        .modal .modal_title_small {
            display: inline-block;
            font-size: 15px;
            color:brown;
            vertical-align: middle;
        }
        
        /* Modal Header */
        .modal-header {
            color: white;
            /*background-color: #EFF0F1;*/
        }

        /* Modal Body */
        .modal-body {padding: 2px 16px;}

        /* Modal Footer */
        .modal-footer {
            padding: 2px 16px;
            background-color: #5cb85c;
            color: white;
        }
    
        /* 상단 닫기 버튼 */
        .modal .close {
            color:black;
            float: right;
            height: 30px;
            font-size: 30px;
            font-weight: bold;
            border-radius: 6px 6px 6px 6px;
        }
    
        .modal .close:hover,
        .modal .close:focus {
            color: crimson;
            text-decoration: none;
            cursor: pointer;
        }
 
    #content{
        padding:7px;
        width:90%;
        min-width: 30%;
        min-height: 200px;
        max-height: 200px;
        resize: none;
        overflow-y:auto;
    }
    .star_rating {font-size:0; letter-spacing:-4px; margin-bottom: 8px;}
    
	.star_rating a {
	    font-size:22px;
	    letter-spacing:0;
	    display:inline-block;
	    margin-left:5px;
	    color:#ccc;
	    text-decoration:none;
	}
	
	.star_rating a:first-child {margin-left:0;}
	
	.star_rating a.on {color:#777;}

   </style>
</head>
<body>

<h1>${login.userName}님의 수강 리스트</h1> 	

<br><br><hr><br><br>


<a href="#">[온라인]</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#">[오프라인]</a> 

<div class="list" id="list">
	<h4>온라인 - 강의 구매 리스트</h4>
	<br>
	어쩌구저쩌구 강의명이랑 강사명이랑 수강기간?이나 그런정보 뿌려준다음   <button id="btn1" value="1" onclick="Modal(this)">수강후기</button> <br>
	어쩌구저쩌구 강의명이랑 강사명이랑 수강기간?이나 그런정보 뿌려준다음   <button id="btn2" value="2" onclick="Modal(this)">수강후기</button> <br>
	어쩌구저쩌구 강의명이랑 강사명이랑 수강기간?이나 그런정보 뿌려준다음   <button id="btn3" value="3" onclick="Modal(this)">수강후기</button> <br>
	어쩌구저쩌구 강의명이랑 강사명이랑 수강기간?이나 그런정보 뿌려준다음   <button id="btn4" value="4" onclick="Modal(this)">수강후기</button> <br>
	어쩌구저쩌구 강의명이랑 강사명이랑 수강기간?이나 그런정보 뿌려준다음   <button id="btn5" value="5" onclick="Modal(this)">수강후기</button> <br>
</div>
        <!-- 모달 창 시작 -->
      <div id="myModal" class="modal">  
          <!-- 모달 내용 -->  
         <div class="modal_content">
			<form action="<c:url value='/review/write' />" method="POST">
                <div class="modal-header">
                    <span class="close" id="modal_close_btn" onclick="ModalClose()">&times;</span>
                    <div class="modal_title_large">수강 후기</div><br>
                    <div class="modal_title_small">클릭한 해당 강의명 출력</div>
                </div>
                <br>
                <div class="modal_body">
					<p class="star_rating">
					    <a href="#">★</a>
					    <a href="#">★</a>
					    <a href="#">★</a>
					    <a href="#">★</a>
					    <a href="#">★</a>
					</p>
                    <textarea name="content" id="content" placeholder="수강후기를 자유롭게 입력해주세요." required="required"></textarea><br><br>
                    <input type="hidden" name="reviewUser" value="${login.userEmail}">
                </div>
                <div class="modal_footer">
                <input type="button" class="cancel" value="cancel" onclick="ModalClose()">
				<input type="submit" id="submit" value="send" onclick="return confirm('수강후기는 한번 작성한 후 수정이 불가합니다. 작성하시겠습니까?')">
             </div>
           </form>
         </div>
         <div class="modal_layer"></div>
      </div>
        <!-- 모달 창 끝 -->



<script>

	//별점
	$( ".star_rating a" ).click(function() {
	    $(this).parent().children("a").removeClass("on");
	    $(this).addClass("on").prevAll("a").addClass("on");
	    return false;
	});


	//모달 띄우기
	const rmodal=document.getElementsByClassName("modal");

	

	function Modal(obj){
		var click_id = $(obj).attr('id');        
		console.log(click_id);
		rmodal[0].style.display="block";
		
	};

	function ModalClose(){
		rmodal[0].style.display="none";
	};	

	
/* 	window.onclick=function(event){
		if(event.target.className=="modal"){
			event.target.style.display="none";
		};
	}; */
</script>




</body>
</html>