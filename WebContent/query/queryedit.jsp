<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ page import="org.module.Book" import="java.util.List"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>館藏查詢</title>
</head>
<body>
	
		<table align="center" id="qryedit">
			<caption>查詢結果</caption>
			<tr>
				<th>書名</th>
				<th>作者</th>
				<th>內容</th>
				<th>出版年月</th>
				<th>索引編號</th>
				<th>預約</th>
			</tr>
			<% 
				if(session.getAttribute("books")==null){return;}
				for(Book b:(List<Book>)session.getAttribute("books")){ 
			%>
			<tr>
				<td><%=b.getTitle() %></td>
				<td><%=b.getAuthor() %></td>
				<td><%=b.getSummary() %></td>
				<td><%=b.getPublishdate() %></td>
				<td><%=b.getLocation()%></td>
				<td>
					<form method="post" action="reservebook">
						<button name="id" value="<%=b.getId()%>">預約</button>
					</form>
				</td>
			</tr>
			<%} %>
			<tr height="20">　</tr>
			<tfoot align="right"><tr>
			<td colspan="6">	
				<input type="button" value="第一頁">
				<input type="button" value="下一頁">
				<input type="button" value="上一頁">
				<input type="button" value="最後一頁">
			</td>	
			</tr></tfoot>
		</table>
	${sessionScope.book.title}
</body>
</html>