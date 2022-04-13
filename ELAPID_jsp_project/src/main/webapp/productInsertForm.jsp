<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<form action="productInsert.do">
	<table>
		<tr>
			<td align="right">상품명:</td>
			<td><input type="text" name="p_name"><br></td>
		</tr>
		<tr>
			<td align="right">상품색상:</td>
			<td><input type="text" name="p_id"><br></td>
		</tr>
		<tr>
			<td align="right">상품메인카테고리:</td>
			<td><input type="text" name="ctg_main"><br></td>
		</tr>
		<tr>
			<td align="right">상품미들카테고리:</td>
			<td><input type="text" name="ctg_middle"><br></td>
		</tr>
		<tr>
			<td align="right">제품썸네일 이미지:</td>
			<td><input type="file" name="img_thum"><br></td>
		</tr>
		<tr>
			<td align="right">상세페이지 제품이미지01:</td>
			<td><input type="file" name="img_01"><br></td>
		</tr>
		<tr>
			<td align="right">상세페이지 제품이미지02:</td>
			<td><input type="file" name="img_02"><br></td>
		</tr>
		<tr>
			<td align="right">상세페이지 제품이미지03:</td>
			<td><input type="file" name="img_03"><br></td>
		</tr>
		<tr>
			<td align="right">상세페이지 제품이미지04:</td>
			<td><input type="file" name="img_04"><br></td>
		</tr>
		<tr>
			<td align="right">상세페이지 제품이미지05:</td>
			<td><input type="file" name="img_05"><br></td>
		</tr>
		<tr>
			<td align="right">상세페이지 제품이미지06:</td>
			<td><input type="file" name="img_06"><br></td>
		</tr>
	</table>
		<input type="submit" value="상품등록">
	</form>








<%@ include file="/layout/footer.jsp"%>	