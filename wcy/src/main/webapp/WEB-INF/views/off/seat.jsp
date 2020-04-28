<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js"
   integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ="
   crossorigin="anonymous"></script>
</head>
<body>
<!-- 일단 30에서만 작업해야지  -->
<input type="hidden" id="seatOffNo" value=10 >
   <c:choose>
      <c:when test="${seat eq 30}">
         <span>좌석 갯수 30 강의실</span><br>
         <form action="<c:url value='/off/chooseSeat' />" method="post">
         <input type="hidden" name="off" value="1"/>
         <c:forEach var="y" begin="1" end="5">
            <c:forEach var="x" begin="1" end="6">
            <c:if test="${x==4}">
               &nbsp;&nbsp;
            </c:if>
               <input type="checkbox" name="Chk_name" id="Chk_id${x}${y}" 
               onclick=showpicks(this) value="${x}${y}">
            </c:forEach>
            <br>
         </c:forEach>
         <button>결제</button>
         </form>
      </c:when>
      <c:when test="${seat eq 24}">
         <span>좌석 갯수 24 강의실</span><br>
         <form action="" name="exf1">
         <c:forEach var="y" begin="1" end="4">
            <c:forEach var="x" begin="1" end="6">
            <c:if test="${x==3 || x==5}">
               &nbsp;&nbsp;
            </c:if>
               <input type="checkbox" name="Chk_name" id="Chk_id${x}${y}" 
               onclick=showpicks(this) value="${x}${y}">
            </c:forEach>
            <br>
         </c:forEach>
         </form>
      </c:when>
      <c:when test="${seat eq 15}">
         <span>좌석 갯수 15 자습실</span><br>
         <form action="" name="exf1">
         <c:forEach var="y" begin="1" end="2">
            <c:forEach var="x" begin="1" end="8">
            <c:if test="${x==1 and y==2}">
               <span style="visibility: hidden;"><input type="checkbox"></span>
            </c:if>   
            <c:if test="${x!=1 or y!=2}">
               <input type="checkbox" name="Chk_name" id="Chk_id${x}${y}" 
               onclick=showpicks(this) value="${x}${y}">
            </c:if>   
            </c:forEach>
            <br>
         </c:forEach>
         </form>
      </c:when>
      <c:when test="${seat eq 8}">
         <span>좌석 갯수 8 시험실</span><br>
         <form action="" name="exf1">
         <c:forEach var="y" begin="1" end="1">
            <c:forEach var="x" begin="1" end="8">
               <input type="checkbox" name="Chk_name" id="Chk_id${x}${y}" 
               onclick=showpicks(this) value="${x}${y}">
            </c:forEach>
            <br>
         </c:forEach>
         </form>
      </c:when>
      <c:otherwise>
           예외페이지
         </c:otherwise>
   </c:choose>
<script type="text/javascript">
$(document).ready(function() {// 페이지가 켜지자마자 
   // ajax로 seat table의 index 정보를 가져와서 
   // 정보가 있는건 checked 와 disable 넣어주기
   var input = document.getElementById('seatOffNo');
   $.ajax({
        type: "POST",
        url : "/off/selectChecked",   
        headers:{
            "Content-Type":"application/json"
        },
      data: document.getElementById('seatOffNo').value,
        success: function(result){ 
           console.log(result.list);
           var id;
           for (var i = 0; i < result.list.length; i++) {
            id = "Chk_id"+result.list[i];
            document.getElementById(id).disabled = true;
         }
             
      },   
      error: function(){      
         console.log("서버 통신 실패");                   
      } 
    
   });
});

</script>   
   
   
<script type="text/javascript">
$(document).ready(function() {
    //라디오 요소처럼 동작시킬 체크박스 그룹 셀렉터
    $('input[type="checkbox"][name="Chk_name"]').click(function(){
        //클릭 이벤트 발생한 요소가 체크 상태인 경우
        if ($(this).prop('checked')) {
            //체크박스 그룹의 요소 전체를 체크 해제후 클릭한 요소 체크 상태지정
            $('input[type="checkbox"][name="Chk_name"]').prop('checked', false);
            $(this).prop('checked', true);
        }
    });
});
</script>

<script type="text/javascript">

function showpicks(obj) {
   var click_id = $(obj).attr('id');
   var sub_id = click_id.substr(7,1);
   var id = 'Chk_id'+click_id.substr(6,2);
   if(document.getElementById(id).checked){
      console.log(click_id);
      console.log(sub_id+"번줄 선택")
   }
}
   
   
</script>

</body>
</html>