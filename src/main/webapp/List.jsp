<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
	<header>
		<%@ include file="Header.jsp"%>
	</header>
	<main>
		<div class="title">더하기 목록</div>
		<div class="list_wrap">
			<table>
				<thead>
					<tr>
						<th>글번호</th>
						<th>상점명</th>
						<th>평점</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
				<%-- <c:forEach>
				<tr>
				<td>1</td>
				<td>장원김밥</td>
				<td>3</td>
				<td>2022-12-29</td>
				</tr>
				</c:forEach> --%>
				</tbody>
			</table>
		</div>
	</main>
	<footer>
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>