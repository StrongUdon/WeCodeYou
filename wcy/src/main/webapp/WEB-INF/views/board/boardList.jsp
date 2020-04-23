<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>게시판</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}
    
/* 
---------------------------end css reset------------------------------------
*/    
   
    table {
    	width:90%;
    	margin: 10% auto 10% auto;
    }
    .w30 {
    	width: 30%;
    }
    .w70 {
    	width: 70%;
    }
    .w20 {
    	width: 20%;
    }
    .w50 {
    	width: 50%;
    }
    tr {
    	width: 100%;
    }
    th{
    	background-color: #084B8A;
    }

</style>
</head>
<body>

	<div class="container" id="container">
		<div class="content">
			<!-- 컨텐츠 영역 -->
			<div class="title">
				<ul>
					<li style="text-align: center;"><h2>커뮤니티 </h2>
				</ul>
			</div>
			<hr>
			<div class="content_in">
                <!--게시판 선택 테이블-->

				<button class="btn btn-warning" style="float:right;" onclick="location.href=<c:url value='/board/register' />">게시판 추가하기</button>
                <table>
                <!--테이블 헤더-->
			        <tr class="list-group list-group-horizontal ">
                        <th class="list-group-item w20">게시판명</th>
                        <th class="list-group-item w50" >게시판 설명</th>
                        <th class="list-group-item w30">관리자 메뉴</th>
			        </tr>
					<c:forEach var="b" items="${boardList}">
					<tr class="list-group list-group-horizontal">
						<td class="list-group-item w20">${b.boardTitle}<a href='#'></a>
						<span class="badge badge-pill badge-warning"></span></td>
						<td class="list-group-item w50">${b.boardDetail}</td>
						<td class="list-group-item w30">
		                <div class="form-check">
		                     <button class="btn btn-info" onclick="location.href='#'">수정</button> 
		                </div>
		                <div class="form-check">
							<button class="btn btn-danger" onclick="location.href='#'">삭제</button>				
		                </div>
		                </td>
					</tr>
					</c:forEach>
				</table>

<!--                 <table>
                테이블 헤더
			        <tr class="list-group list-group-horizontal ">
                        <th class="list-group-item w30">게시판명</th>
                        <th class="list-group-item w70">게시판 설명</th>
			        </tr>
					<tr class="list-group list-group-horizontal">
						<td class="list-group-item w30"> <a href='#'></a>
						<span class="badge badge-pill badge-warning"></span></td>
						<td class="list-group-item w70"></td>
					</tr>
				</table> -->
			</div>
		</div>
	</div>
</body>
</html>