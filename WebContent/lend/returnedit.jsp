<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>還書</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">
	
	function setaction(){
		alert("是否為預約：${empty records[0].lendtime}");
		if("${empty records[0].lendtime}"=="true"){
			alert("預約");
			getE("returnform").action="lendbooks"
		}else{
			alert("還書");
		}
	}
</script>
</head>
<body>
	<form action="returnbooks" id="returnform" name="returnform" onsubmit="return setaction()">
		<h3 id="lendhead">
		<c:choose>
			<c:when test="${!empty records[0].lendtime}">還書</c:when>
			<c:otherwise>預約</c:otherwise>
		</c:choose>
		</h3>
		<table align="center">
			<tr>
				<th>借書序號</th>
				<th>書名</th>
				<th>作者</th>
				<th>
					<c:choose>
						<c:when test="${!empty records[0].lendtime}">借閱時間</c:when>
						<c:otherwise>預約時間</c:otherwise>
					</c:choose>
				</th>
				<th>
					<c:choose>
						<c:when test="${!empty records[0].lendtime}">歸還</c:when>
						<c:otherwise>借閱</c:otherwise>
					</c:choose>
				</th>
			</tr>
			<c:forEach  items="${records}" var="r">
			<tr>
				<td>${r.id}</td>
				<c:forEach items="${books}" var="b">
					<c:if test="${b.id==r.bookid}">
						<td>${b.title}</td>
						<td>${b.author}</td>		
					</c:if>
				</c:forEach>
				<td>
					<c:choose>
						<c:when test="${!empty records[0].lendtime}">${r.lendtime}</c:when>
						<c:otherwise>${r.reservetime}</c:otherwise>
					</c:choose>
					
				</td>
				<td><input type="checkbox" value="${r.id}" name="ids"></td>
			</tr>
			</c:forEach>
			<tr height="20">　</tr>
			<tfoot align="right"><tr>
				<td></td><td></td><td></td>
				<td>
					<button type="submit" style="margin-right:20px;" >執行</button>
				</td>
			</tr></tfoot>
		</table>
	
	</form>
</body>
</html>