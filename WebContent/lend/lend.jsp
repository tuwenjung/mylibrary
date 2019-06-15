<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>借閱</title>
<link rel="stylesheet" type="text/css" href="/mylibrary/css/base.css" />
<script type="text/javascript">

</script>
<style type="text/css">

</style>

</head>
<body>
	<div class="wrapper">
		<header><jsp:include page="/header.jsp"></jsp:include></header>
		<aside><jsp:include page="lendfunc.jsp"></jsp:include></aside>
		<section>
			<c:choose>
				<c:when test="${!empty books}">
					<jsp:include page="returnedit.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="lendedit.jsp"/>
				</c:otherwise>
			</c:choose>
			
		</section>
	</div>

</body>
</html>