<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="rw.ac.auca.service.interfaces.StudentRegInterface" %>
<%@ page import="rw.ac.auca.service.StudentRegService" %>
<%@ page import="rw.ac.auca.service.interfaces.SemesterInterface" %>
<%@ page import="rw.ac.auca.service.SemesterService" %>
<%@ page import="rw.ac.auca.service.interfaces.AccademicUnitInterface" %>
<%@ page import="rw.ac.auca.service.AccademicUnitService" %>
<%@ page import="rw.ac.auca.service.interfaces.StudentCourceInterface" %>
<%@ page import="rw.ac.auca.service.StudentCourceService" %>
<%@ page import="rw.ac.auca.model.*" %>

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
    <h2 style="color: dodgerblue">List Of Student by Semester</h2>

    <form method="post" action="stdBySem.jsp">


                <div class="form-group">
                    <label for="semester" class="form-label">Semester</label>
                    <select class="form-select" id="semester" name="semester" required>
                        <%
                            SemesterInterface ifc1 = new SemesterService();
                            List<Semester> semesterList = ifc1.semesterList();
                            for (Semester semester : semesterList) {
                        %>
                        <option value="<%= semester.getSemId() %>"><%= semester.getName() %></option>
                        <%
                            }
                        %>
                    </select>
                </div>

        <button type="submit" class="btn btn-primary">Display</button>
    </form>

    <%
        String selectedSemester = request.getParameter("semester");
        if (selectedSemester != null) {
            Semester semester = new Semester();
            semester.setSemId(selectedSemester);
            StudentRegInterface infc = new StudentRegService();
            List<StudentRegistration> studentList = infc.getStudentsBySemester(semester);
            for (StudentRegistration student : studentList) {
    %>

    <table class="table mt-4">
        <thead class="thead-dark">

        <tr>
            <th>Student ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><%= student.getStudentId() %></td>
            <td><%= student.getStudent().getfName() %></td>
            <td><%= student.getStudent().getlName() %></td>
            <td><%= student.getStudent().getDateOfBirth() %></td>
        </tr>
        </tbody>
    </table>
    <%
            }
        }
    %>
</div>

<!-- Include Bootstrap JS and Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js/dist/umd/popper.min.js"></script>
</body>
</html>
