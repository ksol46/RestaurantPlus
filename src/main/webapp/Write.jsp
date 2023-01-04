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
						<td><input class="write_input" type="text" name="r_name" maxlength="50"
							placeholder="상점명 입력"></td>
					</tr>
					<tr>
						<th>작성날짜</th>
						<td><input class="write_input" type="date" name="c_date"></td>
					</tr>

					<tr>
						<th>상점주소</th>
						<td><input class="write_input" type="text" name="r_address" maxlength="100"
							placeholder="가게주소 입력"></td>
					</tr>
					<tr>
						<th>위도</th>
						<td><input class="write_input" type="text" name="r_latitude" maxlength="15"
							placeholder="위도 입력"></td>
					</tr>
					<tr>
						<th>경도</th>
						<td><input class="write_input" type="text" name="r_longitude" maxlength="15"
							placeholder="경도 입력"></td>
					</tr>
					<tr>
						<th>평점</th>
						<td class="select_font">
						 <span>1<input class="select_input" type="radio" name="c_grade" value="1"></span>
						 <span>2<input class="select_input" type="radio" name="c_grade" value="2"></span>
						 <span>3<input class="select_input" type="radio" name="c_grade" value="3"></span>
						 <span>4<input class="select_input" type="radio" name="c_grade" value="4"></span>
						 <span>5<input class="select_input" type="radio" name="c_grade" value="5"></span>
						</td>
					</tr>
					<tr>
						<th>코멘트</th>
						<td><input class="coment_input" type="text" name="c_coment" placeholer="코멘트를 입력해주세요."></td>
					</tr>
					<tr>
						<td class="sub_btn" colspan="2">
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