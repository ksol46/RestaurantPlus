<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
<script type="text/javascript" src="Script.js"></script>
</head>
<body>
	<header>
		<%@ include file="Header.jsp"%>
	</header>
	<main>
		<div class="title">맛집 수정하기</div>
		<form name="frm" action="edit">
			<div class="write_main">
				<table>
					<tr>
						<th>작성날짜</th>
						<td><input type="date" name="c_date"></td>
					</tr>
					<tr>
						<th>상점명</th>
						<td><input type="text" name="r_name"></td>
					</tr>
					<tr>
						<th>상점주소</th>
						<td><input type="text" name="r_address"></td>
					</tr>
					<tr>
						<th>경도</th>
						<td><input type="text" name="r_longitude"></td>
					</tr>
					<tr>
						<th>위도</th>
						<td><input type="text" name="r_latitude"></td>
					</tr>
					<tr>
						<th>코멘트</th>
						<td><input type="text" name="c_coment"></td>
					</tr>
					<tr>
						<th>평점</th>
						<td>1<input type="radio" name="c_grade" value="1"> 2<input
							type="radio" name="c_grade" value="2"> 3<input
							type="radio" name="c_grade" value="3"> 4<input
							type="radio" name="c_grade" value="4"> 5<input
							type="radio" name="c_grade" value="5">
						</td>
					</tr>
					<tr>
						<td colspan="3" class="w_btn">
							<button type="submit" onclick="fn_edit(); return false;">수정</button>
							<button type="" onclick="fn_reset()">삭제</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</main>
	<footer>
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>