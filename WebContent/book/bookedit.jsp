<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>圖書編輯</title>
<style type="text/css">
	tr{padding-left:0;}
	td{text-align:left;}
	#bkedit{
		font-weight:bold; font-size:1.2em;padding:5px;
		color:#ff45fe;
	}
	input[type='submit']{margin-right:20px;}
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<script>
	 function check(){
		 if(getE("booktitle").innerHTML=="新增"){
			 if(getE("photo").value==""){
				 alert("未選擇圖片");
				 return false;
			 }
		 }
	 }
	 function cleartext(except){
		 var inputs=$("input");
		for(i in inputs){
			if(parseInt(i)!=NaN && parseInt(i)!=except){
				inputs[i].value="";	
			}
		}
		
	 }
</script>
</head>
<body>
	<form method="post" id="bookform" action="" onsubmit="return check()">
		<h3 id="booktitle">編輯區</h3>
		<table align="center" id="booktedit">
			<tr>
				<td>ID:</td><td><input type="number" name="book.id" min="1" id="id" value="${bk.id}" autofocus="autofocus"/></td>
				<td>　書名:</td><td><input type="text" name="book.title"  id="bookname" value="${bk.title}"/></td>

			</tr>
			<tr>
				<td>ISBN:</td><td><input type="text" name="book.isbn" id="isbn" value="${bk.isbn}"/></td>
				<td>　作者:</td><td><input type="text" name="book.author"  id="author" value="${bk.author}"/></td>
			</tr>
			<tr>
				<td>出版社:</td><td><input type="text" name="book.publisher"  id="publisher" value="${bk.publisher}"/></td>
				<td>　出版年月:</td><td><input type="date"  name="book.publishdate" id="publishdate" value="${bk.publishdate}"/></td>
			</tr>
			<tr>
				<td>定價:</td><td><input type="number" name="book.price" min="0.0" id="price" value="${bk.price}"/></td>
				<td>　收藏地點:</td><td><input type="text" name="book.location"  id="location" value="${bk.location}"/></td>
			</tr>
			<tr>
				<td>照片:</td>
				<td>
					<input type="file" name="photo" id="photo" accept="image/*"/>
					<div><img src="data:image/jpeg;base64,${bk.photo}" width="150" height="120" id="img"/></div>	
				</td>
				<td>　摘要:</td><td><textarea name="book.summary" id="summary" rows="6">${bk.summary}</textarea></td>
				
			</tr>
			<tr>
				<td>建立時間:</td><td><span>${bk.createtime}</span></td>
				<td>　近期更新時間:</td><td><span>${bk.updatetime}</span></td>
			</tr>
			<tr>
				<td>狀態:</td><td><s:select list="{'inner','display','reserve','collect','obsolete','discard'}" name="book.status" theme="simple" id="status"  /></td>
				<td></td><td></td>
			</tr>
			<tr height="2">　</tr>
			<tfoot align="right"><tr>
				<td><span id="msg">${msg}</span></td><td></td><td></td>
				<td>
					<button type="submit" >執行</button>
					<button type="button" id="clrtxt" onclick="cleartext(0)">重填</button>
				</td>
			</tr></tfoot>
		</table>
		
	</form>
	${book}
</body>
</html>