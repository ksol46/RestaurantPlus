<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
<script type="text/javascript" src="Script.js"></script>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<section>
		<div class="title">맛집 더하기.</div>
		<div class="write_main">
			<form name="frm" method="post" action="insert">
				<table>
					<tr>
						<th>상점명</th>
						<td><input type="text" name="r_name" maxlength="50"
							placeholder="상점명 입력"></td>
					</tr>
					<tr>
						<th>작성날짜</th>
						<td><input type="date" name="c_date"></td>
					</tr>

					<tr>
						<th>상점주소</th>
						<td><input type="text" name="r_address" maxlength="100"
							placeholder="가게주소 입력"></td>
					</tr>
					<tr>
						<th>위도</th>
						<td><input type="text" name="r_longitude" maxlength="15"
							placeholder="위도 입력"></td>
					</tr>
					<tr>
						<th>경도</th>
						<td><input type="text" name="r_latitude" maxlength="15"
							placeholder="경도 입력"></td>
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
						<td><input type="text" name="c_coment" placeholer="코멘트를 입력해주세요."></td>
					</tr>
					<tr>
						<td colspan="2" class="w_btn">
							<button class="view_btn" type="submit"
								onclick="chkForm(); return false;">작성</button>
							<button class="view_btn" href="home">홈으로</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<%@ include file="Footer.jsp"%>
	<script type="text/javascript" src="Script.js"></script>
</body>
</html>