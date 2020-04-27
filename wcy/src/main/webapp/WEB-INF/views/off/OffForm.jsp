<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오프라인 강의 추가</title>
<!-- <script src="${pageContext.request.contextPath}/resources/vendor/js/jquery-3.4.1.js"></script> -->
<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
</head>
<body>
	
	
	<div>

		<form action="return chkOff()" method="post">
		<table border="2">	
			<tr>
				# 상품이름: 
				<input type="text" name="productName" id="name"/>
			</tr>
			<tr>
				# 상품가격: 
				<input type="text" name="productPrice"id="price"/>
			</tr>
			<tr>
				# 상품설명: 
				<input type="text" name="productDetail" id="detail"/>
			</tr>
			<tr>
				# 상품수량
			  <input type="number" id="seats" name="seats" min="1" max="300" value="1" readonly >
			</tr>
			<tr>
				<input type="text" id="thumb" name="thumb" value="https://res.cloudinary.com/dl5spujr5/image/upload/v1574920339/samples/animals/kitten-playing.gif" readonly/>
			</tr>
			<tr>
				# 상품등록자: 
				<input type="text" name="productUser" id="user" value="kouri1004@gmail.com" readonly />
			</tr>
			<tr># 상품종류: 
				<select name="productType" id="type">
				<option value="0">강의</option>
				<option value="1">상품</option>				
				</select>
			</tr>
			<tr>#시작일
				<input type="date" name="off_start_at" id="start"/>
			</tr>
			<tr>#종료일
				<input type="date" name="off_end_at" id="end"/>
			</tr>
		</table>		
		</form>

	</div>
<script type="text/javascript">
	function chkOff(){
		var productInfo = {
			"productType" : $("#type").val(),
			"productName" : $("#name").val(),
			"productPrice" : $("#price").val(),
			"productDetail" : $("#detail").val(),
			"productThumb" : $("#thumb").val()
		}
		$.ajax({
			type: "POST",
			url : "/product/register",
			headers:{
				"Content-Type": "application/json"
			},
			dataType: "text",
			data:offInfo,
			success: function(data){
				console.log("received output");
				if(data === "product_success"){
					location.href = "/product"
				}
			},
			error: function(){
				console.log("POST : /off/register 요청에 실패했습니다.")
			}
		}); /* end ajax */
	}
</script>
</body>
</html>