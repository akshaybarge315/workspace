<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="FormSubmit">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Semester</td>
				<td><input type="text" name="sem"></td>
			</tr>
			<tr>
				<td>Marks</td>
				<td><input type="text" name="marks"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Student"></td>
			</tr>	
		</table>
	</form>
</body>
</html>