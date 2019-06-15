<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理系統</title>
<link rel="stylesheet" type="text/css" href="/mylibrary/css/base.css">

</head>
<body>
	<div class="wrapper">
		<header><jsp:include page="/header.jsp"></jsp:include></header>
		<aside><jsp:include page="queryfunc.jsp"></jsp:include></aside>
		<section><jsp:include page="queryedit.jsp"></jsp:include></section>
	</div>

</body>
</html>