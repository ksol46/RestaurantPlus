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
		<div class="title">맛집 수정하기.</div>
		<div class="write_main">
			<form name="frm" method="post" action="update?r_id=${pd.r_id}">
				<table>
					<tr>
						<th>상점명</th>
						<td><input type="text" name="r_name" maxlength="50" value="${pd.r_name}"/></td>
					</tr>
					<tr>
						<th>작성날짜</th>
						<td><input type="date" name="c_date" value="${pd.c_date}"/></td>
					</tr>

					<tr>
						<th>상점주소</th>
						<td><input type="text" name="r_address" maxlength="100" value="${pd.r_address}"/></td>
					</tr>
					<tr>
						<th>위도</th>
						<td><input type="text" name="r_longitude" maxlength="15" value="${pd.r_longitude}"/></td>
					</tr>
					<tr>
						<th>경도</th>
						<td><input type="text" name="r_latitude" maxlength="15" value="${pd.r_latitude}"/></td>
					</tr> 
					<tr>
						<th>평점</th>
						<td>1<input type="radio" name="c_grade" value="1" <c:if test="${pd.c_grade eq '1'}">checked</c:if>/>
							2<input type="radio" name="c_grade" value="2"<c:if test="${pd.c_grade eq '2'}">checked</c:if>/>
							3<input type="radio" name="c_grade" value="3"<c:if test="${pd.c_grade eq '3'}">checked</c:if>/>
							4<input type="radio" name="c_grade" value="4"<c:if test="${pd.c_grade eq '4'}">checked</c:if>/>
							5<input type="radio" name="c_grade" value="5"<c:if test="${pd.c_grade eq '5'}">checked</c:if>/>
						</td>
					</tr>
					<tr>
						<th>코멘트</th>
						<td><input type="text" name="c_coment" value="${pd.c_text}"/></td>
					</tr>
					<tr>
						<td colspan="2" class="w_btn">
							<button  class="view_btn" type="submit" onclick="chkForm(); return false;">수정</button>
							<button  class="view_btn"><a href="delete?r_id=${pd.r_id}">삭제</a></button>
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