<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
<!DOCTYPE html>

<form action="fileUploadForm.jsp" id="uploadform" method="post" enctype="multipart/form-data">
<table border=1>
	<tr>
		<td colspan=2 align="center"><h3>파일 업로드 폼</h3></td>
	</tr>
	<tr>
		<td>올린 사람 :</td><td><input type="text" name="name"></td><br>
	</tr>
	<tr>
		<td>제목 :</td><td><input type="text" name="subject"></td><br>
	</tr>
	<tr>
		<td>파일명1 :</td><td><input type="file" name="fileName1" ></td><br>
	</tr>
	<tr>
		<td>파일명2 :</td><td><input type="file" name="fileName"></td><br>
	</tr>
	<tr>
		<td><input type="button" value="file Upload" onclick="checkFile()"></td>
			<td colspan=2 align="center"><input type="submit" value="전송"></td>
	</tr>
	
</table>
</form>

<script>

function checkFile(){
	var form = document.getElementById("uploadform");
	var upload1 = form.fileName1;
	var ext = upload1.value;

	if(ext.length>=1 && !(ext.substring(ext.length-3) == 'jpg' || ext.substring(ext.length-3) == 'jpeg' || ext.substring(ext.length-3) == 'png' )){
		alert("jpg, jpeg, png 파일만 업로드 가능")
		return false
	}
	form.submit();
}

</script>





<%@ include file="/layout/footer.jsp"%>	