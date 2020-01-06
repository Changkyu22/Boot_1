<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<body>
	<c:import url="../template/nav.jsp"></c:import>
	<div class="container">
		<div>
			<div>제목: ${vo.title}</div>
			<div>작성일: ${vo.regDate}</div>
			<div>조회수: ${vo.hit}</div>
			<div>작성자: ${vo.writer}</div>
		</div>

		<div>
			<div>내용: ${vo.contents}</div>
		</div>
	</div>
<c:forEach items="${vo.noticeFiles}" var="file">
	<img alt="images" src="../notice/${file.fname}">
</c:forEach>	
</body>
</html>