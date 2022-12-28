<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
<header>
<%@ include file="Header.jsp" %>
</header>
<div class="bt_wrap">
<a href="list" class="on" onclick="">게시판으로 보기</a>
</div>
<main>
<%@ include file="Map.jsp" %>
</main>
<footer>
<%@ include file="Footer.jsp" %>
</footer>
</body>
</html>