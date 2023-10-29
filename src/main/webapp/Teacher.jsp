<%@ page import="rw.ac.auca.service.interfaces.TeacherInterface" %>
<%@ page import="rw.ac.auca.service.TeacherService" %>
<%@ page import="rw.ac.auca.model.Teacher" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher Information Form</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Boxicons CDN Link -->
    <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css" />
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

<div class="container mt-5">
    <h2  style="color: dodgerblue">Teacher Information Form</h2>
    <!-- Teacher Information Form -->
    <form action="/TeacherServlet" method="post">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="tcode">Teacher Code</label>
                    <input type="text" class="form-control" id="tcode" name="tCode" placeholder="Enter Teacher Code" required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="names">Teacher Names</label>
                    <input type="text" class="form-control" id="names" name="names" placeholder="Enter Teacher Names" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="tel" class="form-control" id="phone" name="phone" placeholder="Enter Phone" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="qualification">Qualification</label>
                    <select class="form-control" id="qualification" name="qualification">
                        <option value="PHD">PHD</option>
                        <option value="MASTER">Masters</option>
                        <option value="PROFESSOR">Professor</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="teacherType">Teacher Type</label>
                    <select class="form-control" id="teacherType" name="teacherType">
                        <option value="Tutor">Tutor</option>
                        <option value="Assistant">Assistant</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <button type="submit" class="btn btn-primary btn-block">Save Teacher</button>
            </div>
        </div>
    </form>

    <div class="mt-4">
        <h2>Teacher List</h2>
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
            <tr>
                <th>Teacher Code</th>
                <th>Teacher Names</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Qualification</th>
                <th>Teacher Type</th>

            </tr>
            </thead>
            <tbody>
            <%
                TeacherInterface ifc = new TeacherService();
                List<Teacher> teacherList = ifc.teacherList();
                for (Teacher teacher : teacherList) {
            %>
            <tr>
                <td><%= teacher.gettCode() %></td>
                <td><%= teacher.getName() %></td>
                <td><%= teacher.getEmail() %></td>
                <td><%= teacher.getPhone() %></td>
                <td><%= teacher.getQualification() %></td>
                <td><%= teacher.getTeacherType() %></td>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<!-- Edit Teacher Modal (unchanged) -->

<!-- Include Bootstrap JS and Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js/dist/umd/popper.min.js"></script>
</body>
</html>
