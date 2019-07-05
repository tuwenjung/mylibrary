<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>讀者專區</title>
<link rel="stylesheet" type="text/css" href="/mylibrary/css/base.css">

</head>
<body>
	<div class="wrapper">
		<header><jsp:include page="/header.jsp"></jsp:include></header>
		<aside><jsp:include page="readerfunc.jsp"></jsp:include></aside>
		
		<section>
		${books}
		<c:choose>
			<c:when test="${!empty books}">
				<jsp:include page="/lend/returnedit.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="readeredit.jsp"></jsp:include>	
			</c:otherwise>
		</c:choose>
		
		
		</section>
	</div>

</body>
</html>