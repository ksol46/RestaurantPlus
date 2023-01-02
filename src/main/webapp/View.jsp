<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">

</head>
<body>
	<%@ include file="Header.jsp"%>
	<section>
		<div class="title">
			<p>저장한 맛집 보기.</p>
		</div>
		<div class="write_main">
			<table>
				<tr>
					<th>상점명</th>
					<td>${pd.r_name}</td>
				</tr>
				<tr>
					<th>작성날짜</th>
					<td>${pd.c_date}</td>
				</tr>
				<tr>
					<th>상점주소</th>
					<td>${pd.r_address}</td>
				</tr>
				<tr>
					<th>경도</th>
					<td>${pd.r_latitude}</td>
				</tr>
				<tr>
					<th>위도</th>
					<td>${pd.r_longitude}</td>
				</tr>
				<tr>
					<th>평점</th>
					<td>${pd.c_grade}</td>
				</tr>
				<tr>
					<th>코멘트</th>
					<td>${pd.c_text}</td>
				</tr>
				<tr>
					<td colspan="2" class="w_btn">
						<a href="home" class="view_btn">목록</a>
						<a href="edit" class="view_btn">수정</a>
					</td>
				</tr>
			</table>
		</div>
	</section>
	<%@ include file="Footer.jsp"%>
	<script type="text/javascript" src="Script.js"></script>
</body>
</html>