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
	//檢查有無登入(此處為管理員)、讀者及書籍ID不得空白、書籍可以借出(status:inner)
	function lendbook(){
		if("${ac}"==""){
			alert("書籍外借中");
			window.location.replace('/mylibrary/index.jsp');
			return;
		}
		if(getE("readerid").value==""){
			alert("未指定借閱者");
			return;
		}
		if(getE("bookid").value==""){ //bookid
			alert("請輸入書籍id");
			return;
		}
		if("${bk.status}"!="inner"){
			alert("此書無法借出");
			return;
		}
		document.lendform.action="lendbook";
		document.lendform.submit();
	}
	//檢查bookid：不得空白
	function checkBookId(){
		getE("book_id").value=getE("bookid").value;
		if(getE("id").value==""){
			alert("請輸入id");
			getE("id").focus();
			return false;
		}
	}
	//把session book 清除
	function clearbook(){
		document.lendform.action="clearbook";
		document.lendform.submit();
	}
	

</script>
</head>
<body>
	<s:form action="getbook" id="lendform" name="lendform" onsubmit="return checkBookId()">
		<h3 id="lendhead">
			<c:if test="${!empty rid}">借書</c:if>
			<c:if test="${empty rid}">書籍資訊</c:if>
		</h3>
		<input type="hidden" name="readerid" id="readerid" value="${rid}">
		<table align="center">
			<tr>
				<td>
					ID:</td><td><input type="number" name="bookid" value="${bk.id}"  id="bookid" min="1" autofocus/>
					<input type="hidden" name="book.id" value="${bk.id}" id="book_id">
				</td>
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
			<tr height="20"><td class="msg">${msg}</td></tr>
			<tfoot align="right"><tr>
				<td></td><td></td><td></td>
				<td>
					<button type="button" onclick="lendbook()" style="margin-right:20px;">借出</button>
					<button type="button" onclick="clearbook()">取消</button>
				</td>
			</tr></tfoot>
		</table>
	</s:form>

</body>
</html>