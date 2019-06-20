<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>預約完成</title>
<link type="css/text" rel="stylesheet" href="/mylibrary/css/base.css">
</head>
<body>
<div align="center">
	<h2>預約成功</h2>
	<h4>您借閱的書籍資訊如下</h4>
	書名：${rsbook.title}<br>
	作者：${rsbook.author}<br>
	出版社：${rsbook.publisher}<br>
	<p>
	<a href="query.jsp">確定</a>
</div>		

</body>
</html>