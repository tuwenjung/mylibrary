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

<script type="text/javascript">
	// 取得Element：
	function getE(id){
		ele=document.getElementById(id);
		return ele;
	}
	// 全部設成disabled：
	function allDisable(elets){
		elets.forEach(function(elemt){
			console.log(elemt);
			elemt.disabled=true;
		});
	}
	// 全部設成enabled：
	function allEnable(elets){
		elets.forEach(function(elemt){
			elemt.disabled=false;
		});
	}
	// 顯示input的內容
	
	window.onload=function(){
		var id  =getE("id");			var title=getE("title");
		var isbn=getE("isbn");			var autor=getE("author");
		var puber=getE("publisher");	var pubte=getE("publishdate");
		var sumry=getE("summary");		var price=getE("price");
		var photo=getE("photo");		var locon=getE("location");
		var creme=getE("createtime");	var updme=getE("updatetime");
		var staus=getE("status");		var img=getE("img");
		var elets=[id,title,isbn,autor,puber,pubte,sumry,price,photo,locon,creme,updme,staus];
		var act=getE("act");			var boorm=getE("bookform");
		var bkdit=getE("bkedit"); 		var bkmit=getE("bksubmit");

		allDisable(elets);
		staus.value="${sessionScope.book.status}";
		
		
		var getbtn=getE("gbk");		var addbtn=getE("abk");
		var updbtn=getE("ubk");		var delbtn=getE("dbk");
		if("${sessionScope.book}"==""){
			updbtn.style="display:none;";
			delbtn.hidden=true;	
		}
		alert("${sessionScope.book.photo}")
		img.src="data:image/jpeg;base64,"+"${sessionScope.book.photo}";
		
		photo.onchange=function(){
			var reader = new FileReader();
			reader.onload = function(e) {
		    	img.src=e.target.result;
		    }
			reader.readAsDataURL(photo.files[0]);
		}
		
		getbtn.onclick=function(){
			allDisable(elets);
			id.disabled=false;
			id.readOnly=false;
			boorm.action="getbook";
			bkdit.caption.innerHTML="查詢";
		};
		addbtn.onclick=function(){
			allEnable(elets);
			id.disabled=true;
			creme.disabled=true;
			updme.disabled=true;
			boorm.action="addbook";
			bkdit.caption.innerHTML="新增";
		};	
		updbtn.onclick=function(){
			allEnable(elets);
			id.readOnly=true;
			creme.disabled=true;
			updme.disabled=true;
			boorm.action="updatebook";
			bkdit.caption.innerHTML="修改";
		};
		delbtn.onclick=function(){
			allDisable(elets);
			boorm.action="delbook";
			bkdit.caption.innerHTML="刪除";
		};
		

	
	}
	
</script>
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
			<button type="submit" >查詢</button>
		</p>
		

	</form>
	</div>
</body>
</html>