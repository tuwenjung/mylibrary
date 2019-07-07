<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>功能區</title>
<link rel="stylesheet" type="text/css" href="/mylibrary/css/base.css">

<script type="text/javascript">
	window.onload=function(){
		var id = getE("id");
		if(id!=null){
			id.disabled="${rid}"==""?true:false;
		}
	}
	
	function querylendrecords(){
		document.checkform.action="querylendrecords";
		document.checkform.submit();
	}
	function queryreserverecords(){
		document.checkform.action="queryreserverecords";
		document.checkform.submit();
	}
</script>
</head>
<body>
	<h2>借閱與歸還</h2>
	<div class="funcmenu">
	<form method="post" id="checkform" name="checkform" action="checkreader">	
		<ul>
			<li >
				讀者ID：<input type="text" name="readerid" id="readerid" value="${rid}" >
			</li>
			
			<li><button type="submit" id="lend" >借閱</button></li>
			<li><button type="button" id="back" onclick="querylendrecords()">歸還</button></li>
			<li><button type="button" id="reserve" onclick="queryreserverecords()">預約未取</button></li>
			<li><button type="button" id="reserve" onclick="window.open('/mylibrary/lend/lend.jsp','_parent')">新增讀者</button></li>
			
		</ul>
	</form>
	</div>
</body>
</html>