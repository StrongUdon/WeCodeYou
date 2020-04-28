<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<meta http-equiv="X-UA-Compatible" content="ie=edge"> 
<title>tag</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.0.min.js" 
integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
</head>
<body>
	<c:forEach var="tag" items="${tagList}" >
		${tag.tagName} <br/>
	</c:forEach>
	
	<input type = "text" id="text" placeholder="검색어를 입력하세요.">
	<button type="button" id="btn_search">Search</button> 
	<ul id="schoolList"></ul>

</body>

<script type="text/javascript">
	
	var oldVal = null;
	
	var selectList = Array();
	
	//var selectedVal = null;
	//$("text").filter("[value='null']").val("");
	
	$("#text").on("propertychange change keyup paste input", function() {
		var currentVal = $(this).val();
		if (currentVal == oldVal) {
			return;
		}
		
		// input이 null값이면
		if(!currentVal){
			$("#schoolList").empty();
			return; //break;
		}
		console.log("search: " + currentVal);
		
		oldVal = currentVal;
		
		
		//start Ajax
		$.ajax({
					type : 'POST',
					url : "/tag/checkTagDetail",
					headers : {
						"Content-Type" : "application/json"
					},
					data : oldVal,
					error : function(err) {
						console.log("ajax checkTagDetail 실행중 오류가 발생하였습니다.");
					},
					success : function(data) {

						console.log("result : " + data.list);
						console.log("size : " + data.list.length);
						
						//자바 배열에 넣기
						selectList = data.list;
						//var testList2 = data;

						
						$("#schoolList").empty();
						var checkWord = $("#text").val(); //검색어 입력값
						
						if (checkWord.length > 0 && data.list.length > 0) {

							for (i = 0; i < data.list.length; i++) {
								
								$("selectList").add(data.list[i]);

								$("#schoolList").append("<li 'class='schoolList' value='"
                                        + data.list[i]
                                        + "' data-input='"
                                        + data.list[i]
                                        + "'>"
										+ "<a href='javascript:void(0);' value='"
										+ data.list[i]
										+ "'"
										+ "onclick='clickLink("
										+ i
										+ ")'>"
										+ data.list[i]
										+ "</a>"
										+ "</li>");
								

							}
							

						}

					}
				});//end Ajax
	});
	
	function clickLink(obj) {
		console.log(selectList[obj]);
	}
	

</script>

</html>