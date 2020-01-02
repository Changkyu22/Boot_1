<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/boot.jsp" />
</head>
<body>
	<c:import url="../template/nav.jsp" />
	  <h2>Member Mypage</h2>
	  <h1>${member.id}</h1>
	  <h1>${member.name}</h1>
	  <h1>${member.email}</h1>
	  <h1>Image</h1>
	  <img alt="images" src="../upload/${member.fname}">
	  <a class="btn btn-primary" href="./memberFileDown?fnum=${member.fnum}">FileDown</a>
</body>
</html>