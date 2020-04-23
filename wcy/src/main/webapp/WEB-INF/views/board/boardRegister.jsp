<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운영자를 위한 게시판 추가</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<style>
    #board-form {
        width: 80%;
        margin: 0 auto;
        margin-top: 10%;
        padding: 5%;
        border: 1px solid;
        text-align: left;
    }    
</style>
</head>
<body>


	<div class="container" id="container">
		<div class="content">
			<!-- 컨텐츠 영역 -->
			<div class="title">
				<ul>
					<li style="text-align: center;"><h2>게시글 작성</h2>
				</ul>
			</div>
			<hr>
			<div class="content_in">	
	<div id="board-form">
	    <h2>게시물 입력창</h2>
	    <form action='<c:url value="/board/register" />' method="POST">
            <hr/>
            <div class="form-group">
                <label for="board-title-input">이름</label>
                <input type="text" class="form-control" id="board-title-input" name="board_title">
            </div>
            <div class="form-group">
                <label for="board-detail-input">설명글</label>
                <input type="text" name="board_detail" class="form-control" id="board-detail-input">
            </div>
            <div class="form-group">
                <label for="board-type-input">게시판 선택</label>
                <select name="board_type" class="form-control" id="board-type-input">
				    <option value="a">비기능 커뮤니티 게시판</option>
				    <option value="b">기능 게시판</option>
				</select>
            </div>
            <button type="submit" class="btn btn-primary">등록</button>
        </form>
    </div>
				</div>
			</div>
		</div>
</body>
</html>