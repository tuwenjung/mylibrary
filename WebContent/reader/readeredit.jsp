<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>讀者專區</title>
<style type="text/css">
tr {
	padding-left: 0;
}

td {
	text-align: left;
}

#bkedit {
	font-weight: bold;
	font-size: 1.2em;
	padding: 5px;
	color: #ff45fe;
}

#head {font-size =2em;
	color: red;
}

#readersubmit{
	margin-right: 20px;
}
</style>
<script>
	
</script>
</head>
<body>
	<form method="post" id="readerform" action="getreader"
		enctype="application/x-www-form-urlencoded">
		<table align="center" id="bkedit">
			<caption id="head">編輯區</caption>

			<tr>
				<td>ID:</td>
				<td><input type="hidden" name="reader.id" min="1" id="id"
					value="${sessionScope.reader.id}" />
				</td>
				<td>編號:</td>
				<td><input type="text" name="reader.num" id="num"
					value="${sessionScope.reader.num}"/>
				</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="reader.name" id="name"
					value="${sessionScope.reader.name}" /></td>
				<td>職業:</td>
				<td><input type="text" name="reader.work" id="work"
					value="${sessionScope.reader.work}" /></td>
			</tr>
			<tr>
				<td>電話:</td>
				<td><input type="text" name="reader.tel" id="tel"
					value="${sessionScope.reader.tel}" /></td>
				<td>住址:</td>
				<td><input type="text" name="reader.address" id="address"
					value="${sessionScope.reader.address}" /></td>
			</tr>
			<tr>
				<td>性別:</td>
				<td>
					<input type="radio" name="reader.gender" id="gender"
					value="${sessionScope.reader.gender}" />男
					<input type="radio" name="reader.gender" id="gender"
					value="${sessionScope.reader.gender}" />女
				</td>
				<td>生日:</td>
				<td><input type="date" name="reader.birthday" id="birthday"
					value="${sessionScope.reader.birthday}" /></td>
			</tr>
			<tr>
				<td>照片:</td>
				<td><input type="file" name="photo" id="photo" accept="image/*" />
					<div>
						<img src="data:image/jpeg;base64,${reader.photo}" width="150"
							height="120" id="img" />
					</div>
				</td>
				<td>備註:</td>
				<td>
					<textarea name="reader.remark" id="remark" rows="6">
						${sessionScope.reader.remark}
					</textarea>
				</td>
			</tr>
			<tr>
				<td>建立時間:</td>
				<td><input type="text" name="reader.createtime" id="createtime"
					value="${sessionScope.reader.createtime}" /></td>
				<td>近期更新時間:</td>
				<td><input type="text" name="reader.updatetime" id="updatetime"
					value="${sessionScope.reader.updatetime}" /></td>
			</tr>
			<tr>
				<td>狀態:</td>
				<td><s:select
						list="{'normal','forbid','uncommon'}"
						name="reader.status" theme="simple" id="status" /></td>
				<td></td>
				<td></td>
			</tr>
			<tr height="20">
			</tr>
			<tfoot align="right">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="submit" value="執行" id="readersubmit" /> <input
						type="reset" value="重填" /></td>
				</tr>
			</tfoot>
		</table>

	</form>
	${sessionScope.reader.title}
</body>
</html>