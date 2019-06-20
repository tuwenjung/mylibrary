<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
	import="org.module.Book"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>功能區</title>
<link rel="stylesheet" type="text/css" href="/mylibrary/css/base.css">
<style type="text/css">
	button.submit{border:solid 	2px #55ff88; box-shadow: green 2px 2px 2px; background:#afb955;}
</style>

</head>
<body>
	<h2>館藏查詢</h2>
	<div class="funcmenu">
	<form method="post" action="querybook">	
		<div style="padding:20x;">
			<input type="radio" value="title" name="column">書名
			<input type="radio" value="author" name="column">作者
			<input type="radio" value="isbn" name="column">ISBN
		</div>
		<p style="align-items:left;">
			<input type="text" name="basis">
		</p>
		<p style="margin-left:100px">
			<button type="submit" id=".submit">查詢</button>
		</p>
		

	</form>
	</div>
</body>
</html>