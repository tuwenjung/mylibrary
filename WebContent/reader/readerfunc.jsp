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
		console.log("查詢記錄");
		console.log("ac:"+"${ac}");
		console.log("hehe");
		if("${ac}"==""){
			window.open("/mylibrary/index.jsp","_parent");
			return;
		}
		document.qrform.action=actname;
		document.qrform.submit();
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
			<li><a href="modifyreaderinfo">個資更新</a></li>
			<li><a href="suggestandcomplain">建議與申訴</a></li>
			
		</ul>
	</div>
</body>
</html>