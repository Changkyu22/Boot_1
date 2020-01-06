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
	<div class="container">
	  <h2>Notice Write Page</h2>
	  <form action="./noticeWrite" method="POST" id="frm" onsubmit=true>
	  
	    <div class="form-group">
	      <label for="name">TITLE</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter TITLE" name="title" value="${dto.title}">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">WRITER</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter the Writer" name="writer" value="${dto.writer}">
	    </div>
	    
	    <div class="form-group">
      		<label for="comment">Contents:</label>
      		<textarea class="form-control" rows="5" id="contents" placeholder="Enter contents" name="contents">${dto.contents}</textarea>
   		</div>
	    
	    
	    <button class="btn btn-default" id="submit">SUBMIT</button>
	  </form>
	</div>
</body>
</html>