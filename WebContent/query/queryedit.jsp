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
	<div id="querybookresult">
		<table align="center" id="qryedit">
			<caption style="font-size:1.3em">查詢結果</caption>
			<tr>
				<th>書名</th>
				<th>作者</th>
				<th>內容</th>
				<th>出版年月</th>
				<th>狀態</th>
				<th>預約</th>
			</tr>
			<% 
				if(request.getAttribute("books")==null){return;}
				List<Book> bks=(List<Book>)request.getAttribute("books");
				
				for(int i=0;i<bks.size();i++){ 
					pageContext.setAttribute("bk", bks.get(i));
			%>
			<tr>
<%-- 				<td><%=bks.get(i).getTitle() %></td> --%>
				<td>${bk.title}</td>
				<td><%=bks.get(i).getAuthor() %></td>
				<td><%=bks.get(i).getSummary() %></td>
				<td><%=bks.get(i).getPublishdate() %></td>
				<td><%=bks.get(i).getStatus()%></td>
				<td>
					<form method="post" action="reservebook">
						<button name="bookid" value="<%=bks.get(i).getId()%>">預約</button>
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
	</div>
	${sessionScope.book.title}
</body>
</html>