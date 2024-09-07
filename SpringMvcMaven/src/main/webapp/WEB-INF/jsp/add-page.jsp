<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Page</title>
</head>
<body>
	<h2>Register Page</h2>
	
	<form action="dataInsert">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="number" name="empid"></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<td>Jobrole</td>
				<td><input type="text" name="jobrole"></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><input type="text" name="dept"></td>
			</tr>
			<tr>
				<td>Department Id</td>
				<td><input type="number" name="deptid"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Employee"></td>
			</tr>	
		</table>
	</form>
	
</body>
</html>