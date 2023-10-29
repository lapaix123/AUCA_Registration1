<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="rw.ac.auca.service.interfaces.StudentInterface" %>
<%@ page import="rw.ac.auca.service.StudentService" %>
<%@ page import="rw.ac.auca.model.Student" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navigation Bar</title>
    <link rel="stylesheet" href="css/style.css" />
    <!-- Boxicons CDN Link -->
    <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet" />
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <style>
        /* Custom styles for the sidebar and page content */
        .sidebar {
            height: 100%;
            width: 250px; /* Adjust the width as needed */
            position: fixed;
            top: 0;
            left: 0;
            background-color: #333;
            padding-top: 20px;
        }
        .nav-link {
            color: #fff;
        }
        .nav-link:hover {
            color: #007bff;
        }
        .page-content {
            margin-left: 250px; /* Adjust to match the sidebar width */
            padding: 20px;
        }
    </style>
    <style>
        body {
            position: relative;
            text-align: center; /* Center the content horizontally */
        }

        .watermark {
            position: fixed;
            opacity: 0.3; /* Adjust the opacity as needed */
            top: 50%; /* Center vertically */
            left: 50%; /* Center horizontally */
            transform: translate(-50%, -50%); /* Center the watermark itself */
            pointer-events: none; /* Allows clicking through the watermark */
        }
    </style>
</head>
<body>
<%@include file="pages/Navar.jsp" %>
<div class="watermark">
    <img src="image/logo.png" alt="Watermark Image">
</div>

<div class="container mt-4">
    <h2  style="color: dodgerblue">Student Information Form</h2>

    <form action="/StudentAdServlet" method="post">
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label for="regNo">Registration Number</label>
                    <input type="text" class="form-control" id="regNo" name="regNo" placeholder="Enter Registration Number" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="fName">First Name</label>
                    <input type="text" class="form-control" id="fName" name="fName" placeholder="Enter First Name" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="lName">Last Name</label>
                    <input type="text" class="form-control" id="lName" name="lName" placeholder="Enter Last Name" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="dateOfBirth">Date of Birth</label>
                    <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Save Student</button>
    </form>

    <table class="table mt-4">
        <thead class="thead-dark">
        <tr>
            <th>Registration Number</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>

        </tr>
        </thead>
        <tbody>
        <%
            StudentInterface ifc = new StudentService();
            List<Student> studentList = ifc.studentList();
            for (Student student : studentList) {
        %>
        <tr>
            <td><%= student.getRegNo() %></td>
            <td><%= student.getfName() %></td>
            <td><%= student.getlName() %></td>
            <td><%= student.getDateOfBirth() %></td>


        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<!-- Include Bootstrap JS and Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js/dist/umd/popper.min.js"></script>
</body>
</html>

