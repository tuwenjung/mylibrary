<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
<link rel="stylesheet" type="text/css" href="/mylibrary/css/base.css">
<style>
	table{margin:3px;}
	td{border:none;}
	#buttons input{font-size:1.3em; border-radius:6px; font-weight:bold;margin:5px 4px 0 0;}
	#submit{color:green; background-color:yellow; margin-left:5px;}
	#reset{color:brown; background-color:aqua;}
	#button{color:blue; background-color:pink;}
</style>
<script type="text/javascript">
	function addaccount(){
		var num=prompt("您的閱覽證號碼：");
		if(num.match(/^[a-z,A-Z]\d{4}$/)!=null){
			window.open("/mylibrary/index.jsp?num="+num,"_parent");
			
		}else{
			alert("閱覽證號碼錯誤!");
		}
	}
</script>
</head>
<body>
	<h2>開啟智慧之門</h2>
	<c:if test="${empty ac}">
	<s:form action="login" name="myform">
		<table align="center">
			<tr>
				<td><s:textfield name="user" label="帳號"/></td>
			</tr>
			<tr>
				<td><s:textfield name="pass" label="密碼"/></td>
			</tr>
			<tr></tr>
			<tr>
				<td ></td>
				<td id="buttons">
					<p></p>
					<span><input type="submit" value="登入" id="submit"/></span>
					<span><input type="reset"  value="重填" id="reset" /></span>
					<span><input type="button" value="註冊" id="button" onclick="addaccount()"/></span>
				</td>
			</tr>
		</table>
	</s:form>
	</c:if>
	<c:if test="${!empty ac}">
		<table align="center" id="ac_info" >
			<tr><td>帳號：</td><td>${ac.name}</td></tr>
			<tr>
				<td>身份：</td>
				<td>
					<c:if test="${ac.role==0}">管理員</c:if>
					<c:if test="${ac.role==1}">讀者</c:if>
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>