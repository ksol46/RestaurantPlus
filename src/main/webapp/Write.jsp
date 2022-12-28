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
<%@ include file="Header.jsp" %>
</header>
<main>
<div class="write_wrap">
<form name="frm" method="post" action="insert">
<div class="write_main">
<div class="title">
<dl>
	<dt>이미지 업로드</dt>
	<dd><input class="real-upload" type="file" accept="image/*" required multiole style="display:none;"></dd>
</dl>
</div>
</div>
</form>
</div>
<footer>
<%@ include file="Footer.jsp" %>
</footer>
</main>
</body>
</html>