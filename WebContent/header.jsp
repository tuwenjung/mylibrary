<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<script type="text/javascript" src="/mylibrary/js/base.js"></script>
<script type="text/javascript">
	window.onload=function(){
		getE("")
		//判斷是否登入
			//若登入：
	}
</script>
</head>
<body>
	
	<h1 id="title">清泉春心紀念圖書館</h1>
	<div class="headmenu">
		<ul>
			<li><a href="/mylibrary/index.jsp" target="_parent" >本館首頁</a></li>
			
			<c:if test="${!empty ac}">
			<c:choose>
				<c:when test="${ac.role>0}">
					<li><a href="/mylibrary/reader/reader.jsp" target="_parent">讀者專區</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/mylibrary/book/book.jsp" target="_parent">圖書管理</a></li>
					<li><a href="/mylibrary/lend/lend.jsp" target="_parent">書籍借閱</a></li>
				</c:otherwise>
			</c:choose>
			</c:if>
			<li><a href="/mylibrary/query/query.jsp" target="_parent">館藏查詢</a></li>
			<c:if test="${!empty ac}">
				<li><a href="logout" id="logout">登出</a></li>
			</c:if>
			
		</ul>
	</div>
</body>
</html>