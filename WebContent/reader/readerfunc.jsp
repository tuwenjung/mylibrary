<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>功能區</title>
<link type="text/css" rel="stylesheet" href="/mylibrary/css/base.css">
<script src="/mylibrary/js/base.js"></script>
<script type="text/javascript">
	window.onload=function(){
		var id  =getE("id");			var name=getE("name");
		var gender=getE("gender");		var tel=getE("tel");
		var adess=getE("address");		var biday=getE("birthday");
		var reark=getE("remark");		var work=getE("work");
		var photo=getE("photo");		var locon=getE("location");
		var creme=getE("createtime");	var updme=getE("updatetime");
		var staus=getE("status");		var img=getE("img");
		var elets=[id,title,isbn,autor,puber,pubte,sumry,price,photo,locon,creme,updme,staus];
		var act=getE("act");			var boorm=getE("bookform");
		var bkdit=getE("bkedit"); 		var bkmit=getE("bksubmit");
		work.value="學生";
	}
</script>
	
</head>
<body>
	<h2>讀者專區</h2>
	<h1>功能建構中</h1>
	<div class="funcmenu">
		
		<ul style="font-size: 1.1em">
			<li style="height:7em">查詢：
				<a href="querypreservebooks" target="_parent">預約中書籍</a>
				<a href="querylendbooks" target="_parent">借閱中書籍</a>
			</li>
			<li><a href="/mylibrary/query/query.jsp" target="_parent">預約書籍</a></li>
			<li><a href="modifyreaderinfo" target="_parent">個資更新</a></li>
			<li><a href="suggestandcomplain" target="_parent">建議與申訴</a></li>
			
		</ul>
	</div>
</body>
</html>