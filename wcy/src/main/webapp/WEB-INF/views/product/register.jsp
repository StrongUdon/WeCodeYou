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
<form action="/off/register" method="POST">
		<table border="2">	
			<tr>
				<td>
				# 상품이름: 
				<input type="text" name="productName" id="name"/>
				</td>
			</tr>
			<tr>
				<td>
				# 상품가격: 
				<input type="text" name="productPrice"id="price"/>
				</td>
			</tr>
			<tr>
			<td>
				# 상품설명: 
				<input type="text" name="productDetail" id="detail"/>
				</td>
			</tr>
			<tr>
			<td>
				# 상품수량
			  <input type="number" id="seats" name="off_seats" min="1" max="300" value="1" readonly >
			</td>
			</tr>
			<tr>
			<td>
				<input type="text" id="thumb" name="productThumb" value="https://res.cloudinary.com/dl5spujr5/image/upload/v1574920339/samples/animals/kitten-playing.gif" readonly/>
				</td>
			</tr>
			<tr>
			<td>
				# 상품등록자: 
				<input type="text" name="productUser" id="user" value="kouri1004@gmail.com" readonly />
			</td>
			</tr>
			<tr>
			<td>
				# 상품종류: 
				<select name="productType" id="type">
				<option value="0">강의</option>
				<option value="1">상품</option>				
				</select>
				</td>
			</tr>
			<tr>
				<td>
				#시작일
				<input type="date" name="off_start_at" id="start"/>
				</td>
			</tr>
			<tr>
				<td>
				#종료일
				<input type="date" name="off_end_at" id="end"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" id="product_register_btn" value="등록"/>
				</td>
			</tr>
		</table>		
</form>
	</div>
<script type="text/javascript">
$(function(){
	$("#product_register_btn").click(function(){
		
		const type = $("#type").val();
		console.log(type);
		
		const name = $("#name").val();
		console.log(name);

		const price = $("#price").val();
		console.log(price);

		const detail = $("#detail").val();
		console.log(detail);

		const thumb = $("#thumb").val();
		console.log(thumb);
		
		const place = $("#place").val();
		console.log(place);

		const seats = $("#seats").val();
		console.log(seats);

		const start = $("#start").val();
		console.log(start);
		
		const end = $("#end").val();
		console.log(end);
		
		var productInfo = {
				productType : type,
				productName : name,
				productPrice : price,
				productDetail : detail,
				productThumb : thumb,
				productUser : user,
				offPlace : place,
				offSeats : seats,
				offStartAt : start,
				offEndAt : end
			}
			$.ajax({
				type: "POST",
				url : "/product/register",
				headers:{
					"Content-Type": "application/json"
				},
				dataType: "text",
				data:JSON.stringify(productInfo),
				success: function(data){
					console.log("received output : " + data);
					if(data === "product_success"){
						if(registerOff()){
							location.href = "/product"
						}
					}
				},
				error: function(){
					console.log("POST : /off/register 요청에 실패했습니다.")
				}
			}); /* end ajax */
	});
});

function registerOff(){
	
}
</script>
</body>
</html>