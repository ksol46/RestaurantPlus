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
					<td><span>${pd.r_name}</span></td>
				</tr>
				<tr>
					<th>작성날짜</th>
					<td><span>${pd.c_date}</span></td>
				</tr>
				<tr>
					<th>상점주소</th>
					<td><span>${pd.r_address}</span></td>
				</tr>
				<tr>
					<th>위도</th>
					<td><span>${pd.r_latitude}</span></td>
				</tr>
				<tr>
					<th>경도</th>
					<td><span>${pd.r_longitude}</span></td>
				</tr>
				<tr>
					<th>평점</th>
					<td><span>${pd.c_grade}</span></td>
				</tr>
				<tr>
					<th>코멘트</th>
					<td><span>${pd.c_text}</span></td>
				</tr>
				<tr>
					<td class="sub_btn" colspan="2">
						<button class="view_btn">
							<a  class="btn_a" href="edit?c_id=${pd.c_id}">수정하기</a>
						</button>
						<button href="home" class="view_btn">목록</button>
					</td>
				</tr>
			</table>
		</div>
	</section>
	<%@ include file="Footer.jsp"%>
	<script type="text/javascript" src="Script.js"></script>
</body>
</html>