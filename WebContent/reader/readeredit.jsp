<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>讀者專區</title>
<style type="text/css">
</style>
<script type="text/javascript">
	function setImg(file){
		var ptdir=file.value;
		var f=ptdir.split("\\");
		var sltdir="${initParam.personphoto}"+f[f.length-1];
		getE("img").src=sltdir;	
	}

</script>
</head>
<body>
1. ${param.personphoto}
2. ${initparam.personphoto}
	<form method="post" id="readerform" action="addreader">

		<h3>讀者資訊</h3>
		<table align="center" id="bkedit">
			<tr>
				<td>ID:</td>
				<td><input type="hidden" name="reader.id" min="1" id="id"
					value="${sessionScope.reader.id}" />
				</td>
				<td>編號:</td>
				<td><input type="text" name="reader.number" id="number"
					value="${sessionScope.reader.num}"/>
				</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="reader.name" id="name"
					value="${sessionScope.reader.name}" /></td>
				<td>電子信箱:</td>
				<td><input type="email" name="reader.email" id="email"
					value="${sessionScope.reader.email}" /></td>
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
				<td><input type="file" name="reader.photo" id="photo" accept="image/*" onchange="setImg(this)"
							value="${reader.photo}"/>
					<div>
						<img src="\mylibrary\personphoto\my.png" width="150"
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
				<td>${sessionScope.reader.createtime}</td>
				<td>近期更新時間:</td>
				<td>${sessionScope.reader.updatetime}</td>
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