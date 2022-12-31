<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
<script type="text/javascript" src="Script.js"></script>
</head>
<body>
<%@ include file="Header.jsp"%>
	<section>
		<div class="title">맛집 더하기</div>
		<div class="write_main">
		<form name="frm" action="add">
				<table>
					<tr>
						<th>작성날짜</th>
						<td><input type="date" name="c_date"></td>
					</tr>
					<tr>
						<th>글제목(상점명으로 불러올 것)</th>
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
						<th>평점</th>
						<td>1<input type="radio" name="c_grade" value="1"> 2<input
							type="radio" name="c_grade" value="2"> 3<input
							type="radio" name="c_grade" value="3"> 4<input
							type="radio" name="c_grade" value="4"> 5<input
							type="radio" name="c_grade" value="5">
						</td>
					</tr>
					<tr>
						<th>코멘트</th>
						<td><input type="text" name="c_coment"></td>
					</tr>
					<tr>
						<td colspan="2" class="w_btn">
							<button type="submit" onclick="fn_submit(); return false;">작성</button>
							<button type="reset" onclick="fn_reset()"">다시 작성</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</section>
	<%@ include file="Footer.jsp"%>
</body>
</html>