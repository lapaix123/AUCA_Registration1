<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="rw.ac.auca.service.interfaces.StudentRegInterface" %>
<%@ page import="rw.ac.auca.service.StudentRegService" %>
<%@ page import="rw.ac.auca.model.StudentRegistration" %>
<%@ page import="rw.ac.auca.service.interfaces.SemesterInterface" %>
<%@ page import="rw.ac.auca.service.SemesterService" %>
<%@ page import="rw.ac.auca.model.Semester" %>
<%@ page import="rw.ac.auca.service.interfaces.AccademicUnitInterface" %>
<%@ page import="rw.ac.auca.service.AccademicUnitService" %>
<%@ page import="rw.ac.auca.model.AccademicUnit" %>
<%@ page import="rw.ac.auca.service.interfaces.StudentCourceInterface" %>
<%@ page import="rw.ac.auca.service.StudentCourceService" %>
<%@ page import="rw.ac.auca.model.StudentCource" %>

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
    <h2  style="color: dodgerblue">List Course per Student</h2>
    <form method="post" action="courcePerStd.jsp">
        <div class="row">

                <div class="form-group">
                    <label for="studentId" class="form-label">Student ID</label>
                    <input type="text" class="form-control" id="studentId" name="studentId" required>
                </div>
            </div>

        <button type="submit" class="btn btn-primary">Display</button>
    </form>
    <%
        String studentIdFound = request.getParameter("studentId");
        if (studentIdFound != null) {
    %>

    <table class="table mt-4">
        <thead class="thead-dark">
        <tr>
        <tr>
            <th>Cource Code</th>
            <th>Cource NAme</th>
            <th>Course Credit</th>
            <th>Teacher</th>
        </tr>
        </tr>
        </thead>
        <tbody>
        <%
            StudentRegistration studentRegistration = new StudentRegistration();
            studentRegistration.setStudentId(studentIdFound);
            StudentCourceInterface infc = new StudentCourceService();
            List<StudentCource> courceList = infc.getStudentCourcesByStudent(studentRegistration);
            for (StudentCource stdCource : courceList) {
        %>


        <tr>
            <td><%= stdCource .getCource().getCourseCode() %></td>
            <td><%= stdCource .getCource().getCourceDefinition().getName() %></td>
            <td><%= stdCource .getCource().getCredit() %></td>
            <td><%= stdCource .getCource().getTreTeacher().getName() %></td>
        </tr>
        <%
            }
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

