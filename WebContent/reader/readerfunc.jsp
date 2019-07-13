<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>功能區</title>
<link type="text/css" rel="stylesheet" href="/mylibrary/css/base.css">
<script type="text/javascript">
	function queryrecords(actname){
		if("${ac}"==""){
			window.open("/mylibrary/index.jsp","_parent");
			return;
		}
		document.qrform.action=actname;
		document.qrform.submit();
	}
	function updatereader(){
		var form=document.forms.readerform;
		form.action="modifyreaderinfo";
		document.getElementById('rhead').innerHTML="更新資料";
		//ajax 把資料抓進來好修改
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
			  document.getElementById('rhead').innerHTML="讀者資料更新";
			  var reader=JSON.parse(this.responseText);
			  getE('id').value=reader['id'];
			  getE('id').type="number";
			  getE('id').readonly=true;
			  getE('number').value=reader['number'];
			  getE('name').value=reader['name'];
			  getE('email').value=reader['email'];
			  getE('tel').value=reader['tel'];
			  getE('address').value=reader['address'];
			  var genders=[getE('x'),getE('y'),getE('z')];
			  for(var i=0; i<genders.length; i++){
				  genders[i].checked=false;
			  }
alert(reader.gender);
			  var genders=["x","y","z"];
			  for(i in genders){
				  console.log("***********************    "  +i);
				  console.log("***********************    "  +reader.gender);
				  if(reader.gender==genders[i]){
					  getE(genders[i]).checked=true;
					  break;
				  }
			  }	
			  getE('birthday').value=reader['birthday'];
			  getE('photo').defaultValue=reader['photo'];
			  getE('img').src="/mylibrary/personphoto/"+reader['photo'];
			  getE('remark').value=reader['remark'];
			  getE('createtime').innerHTML=reader['createtime'];
			  getE('updatetime').innerHTML=reader['updatetime'];
		  }
		};
		xhttp.open("POST", "getreader", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
	  	xhttp.send("accountid=${ac.id}");
	}
</script>
	
</head>
<body>
	<h2>讀者專區</h2>
	<div class="funcmenu">
		<form name="qrform">
			<input type="hidden" name="readerid" value="${ac.id}">
			<input type="hidden" name="src" value="reader">
		</form>
		<ul>
			<li style="height:3.6em">
				<table align="center" class="readertable">
					<tr>
						<td colspan="2">查詢書籍</td>
					</tr>
					<tr>
						
						<td><a href="#" onclick="queryrecords('queryreserverecords')">預約中</a></td>
						<td><a href="#" onclick="queryrecords('querylendrecords')">借閱中</a></td>
					</tr>
				</table>
			</li>
			<li><a href="/mylibrary/query/query.jsp" target="_parent">預約書籍</a></li>
			<li><a href="#" onclick="updatereader()">個資更新</a></li>
			<li><a href="suggestandcomplain">建議與申訴</a></li>
			
		</ul>
	</div>
</body>
</html>