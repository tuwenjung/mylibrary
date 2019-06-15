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
<script type="text/javascript" src="/mylibrary/js/base.js"></script>
<script>
	window.onload=function(){
		var id  =getE("id");			var bknam=getE("bookname");
		var isbn=getE("isbn");			var autor=getE("author");
		var puber=getE("publisher");	var pubte=getE("publishdate");
		var sumry=getE("summary");		var price=getE("price");
		var photo=getE("photo");		var locon=getE("location");
		var staus=getE("status");		var img=getE("img");
		var elets=[id,bknam,isbn,autor,puber,pubte,sumry,price,photo,locon,staus];
		var act=getE("act");			var boorm=getE("bookform");
		var bkdit=getE("bookedit"); 		var bkmit=getE("bksubmit");
		booktitle=getE("booktitle")
		
		allDisable(elets);
		staus.value="${bk.status}";//TODO:無效
		
		var getbtn=getE("gbk");		var addbtn=getE("abk");
		var updbtn=getE("ubk");		var delbtn=getE("dbk");
		
		if("${bk}"==""){
			updbtn.style="display:none;";
			delbtn.hidden=true;	
		}
		img.src="data:image/jpeg;base64,"+"${bk.photo}";
		
		photo.onchange=function(){
			var reader = new FileReader();
			reader.onload = function(e) {
		    	img.src=e.target.result;
		    }
			reader.readAsDataURL(photo.files[0]);
		}
		//設定資料是否可以編輯
		//查詢書籍資料
		getbtn.onclick=function(){
			allDisable(elets,new Array(id));
			id.readOnly=false;
			boorm.action="getbook";
			booktitle.innerHTML="查詢";
		};
		//新增書籍資料
		addbtn.onclick=function(){
			allEnable(elets,new Array(id));
			boorm.action="addbook";
			booktitle.innerHTML="新增";
		};
		//修改書籍資料
		updbtn.onclick=function(){
			allEnable(elets);
			id.readOnly=true;
			boorm.action="updatebook";
			booktitle.innerHTML="修改";
		};
		//刪除書籍資料
		delbtn.onclick=function(){
			allDisable(elets,new Array(id));
			id.readOnly=true;
			boorm.action="delbook";
			booktitle.innerHTML="刪除";
		};
	}
	
</script>
</head>
<body>
	<h2>書籍管理</h2>
	<div class="funcmenu">
		
		<ul>
			<li id="gbk"><a>書籍查詢</a></li>
			<li id="abk"><a>新書登錄</a></li>
			<li id="ubk"><a>內容修正</a></li>
			<li id="dbk"><a>資料刪除</a></li>
					
		</ul>
	</div>
</body>
</html>