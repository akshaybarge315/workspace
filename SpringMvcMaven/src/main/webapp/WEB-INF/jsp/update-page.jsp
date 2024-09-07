<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Form</title>

<style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            background-color: #f9f9f9;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
            border-radius: 4px;
        }

        .btn:hover {
            opacity: 0.8;
        }
    </style>

</head>
<body>
	<h1>Employee Form</h1>

<form action="saveEmployee" method="post">
    <%
            Employee employee = (Employee) request.getAttribute("employee");
        %>

        <label for="empid">Employee ID:</label>
        <input type="number" id="empid" name="empid" value="<%= employee != null ? employee.getEmpid() : "" %>" required>

        <label for="ename">Name:</label>
        <input type="text" id="ename" name="ename" value="<%= employee != null ? employee.getEname() : "" %>" required>

        <label for="jobrole">Job Role:</label>
        <input type="text" id="jobrole" name="jobrole" value="<%= employee != null ? employee.getJobrole() : "" %>" required>

        <label for="dept">Department:</label>
        <input type="text" id="dept" name="dept" value="<%= employee != null ? employee.getDept() : "" %>" required>

        <label for="deptid">Department ID:</label>
        <input type="number" id="deptid" name="deptid" value="<%= employee != null ? employee.getDeptid() : "" %>" required>

        <button type="submit" class="btn">Save</button>

</form>
</body>
</html>