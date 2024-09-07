<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.Entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .btn {
            display: inline-block;
            padding: 8px 16px;
            margin: 5px 0;
            text-align: center;
            text-decoration: none;
            border-radius: 4px;
            color: white;
        }

        .btn-edit {
            background-color: #4CAF50;
        }

        .btn-delete {
            background-color: #f44336;
        }

        .btn-add {
            background-color: #2196F3;
            margin-top: 20px;
        }

        .btn:hover {
            opacity: 0.8;
        }
    </style>

</head>
<body>
	<h1>Employee List</h1>

<table>
    <thead>
    <tr>
        <th>Employee ID</th>
        <th>Name</th>
        <th>Job Role</th>
        <th>Department</th>
        <th>Department ID</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        for (Employee employee : employees) {
    %>
        <tr>
            <td><%= employee.getEmpid() %></td>
            <td><%= employee.getEname() %></td>
            <td><%= employee.getJobrole() %></td>
            <td><%= employee.getDept() %></td>
            <td><%= employee.getDeptid() %></td>
            <td>
                <a href="showFormForUpdate?empid=<%= employee.getEmpid() %>" class="btn btn-edit">Edit</a>
                <a href="deleteData?empid=<%= employee.getEmpid() %>" class="btn btn-delete" 
                   onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
            </td>
        </tr>
    <% } %>
    </tbody>
</table>

<a href="showFormForAdd" class="btn btn-add">Add Employee</a>

</body>
</html>