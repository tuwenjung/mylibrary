<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>借書</title>
<script type="text/javascript">
	function lendbook(){
		alert("lendbook");
		if("${ac}"==""){
			alert("already log out");
			window.location.replace('/mylibrary/index.jsp');
			return;
		}
		if(getE("readerid").value==""){
			alert("未指定借閱者");
			return;
		}
		if(id.value==""){
			alert("未輸入書籍識別碼");
			return;
		}


		console.log("pass");
		document.lendform.action="lendbook";
		document.lendform.submit();
	}
	function checkbookid(){
		alert("ckbkid");
		if(getE("id").value==""){
			alert("請輸入id");
			getE("id").focus();
			return false;
		}
	}
</script>
</head>
<body>
	<s:form action="getbook" id="lendform" name="lendform">
		<h3 id="lendhead">
			<c:if test="${!empty rid}">借書</c:if>
			<c:if test="${empty rid}">書籍資訊</c:if>
		</h3>
		<input type="text" name="readerid" value="${rid}" id="readerid">
		<table align="center">
			<tr>
				<td>ID:</td><td><input type="number" name="book.id" value="${bk.id}" min="1" id="id"/></td>
				<td><input type="submit" value="查詢" onsubmit="return checkbookid()"></td>
			</tr>
			<tr>
				<td>書名:</td><td class="data">${bk.title}</td>
				<td>作者:</td><td class="data">${bk.author}</td>
			</tr>
			<tr>
				<td>出版社:</td><td class="data">${bk.publisher}</td>
				<td>出版年月:</td><td class="data">${bk.publishdate}</td>
			</tr>
			<tr>
				<td>位置:</td><td class="data">${bk.location}</td>
				<td>狀態:</td><td class="data">${bk.status}</td>
			</tr>
			<tr height="20">　</tr>
			<tfoot align="right"><tr>
				<td></td><td></td><td></td>
				<td>
					<button type="button" onclick="lendbook()" style="margin-right:20px;">借出</button>
					<s:reset value="清空" theme="simple"/>
				</td>
			</tr></tfoot>
		</table>
	
	</s:form>
</body>
</html>