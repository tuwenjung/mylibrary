<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<section><jsp:include page="readeredit.jsp"></jsp:include></section>
	</div>

</body>
</html>