<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理系統</title>
<link rel="stylesheet" type="text/css" href="/mylibrary/css/base.css">

</head>
<body>
	<div class="wrapper">
		<header><jsp:include page="header.jsp"></jsp:include></header>
		<aside><jsp:include page="login.jsp"></jsp:include></aside>
		<section>
			<c:choose>
				<c:when test="${empty param.num}">
					<jsp:include page="introduce.jsp"></jsp:include>
				</c:when>
				<c:when test="${!empty param.num}">
					<jsp:include page="addaccount.jsp"></jsp:include>
				</c:when>
			</c:choose>
		</section>
	</div>

</body>
</html>