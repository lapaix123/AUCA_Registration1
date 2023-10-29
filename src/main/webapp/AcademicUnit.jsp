<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="rw.ac.auca.service.interfaces.AccademicUnitInterface" %>
<%@ page import="rw.ac.auca.service.AccademicUnitService" %>
<%@ page import="rw.ac.auca.model.AccademicUnit" %>


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
    <h2  style="color: dodgerblue">Academic Unit</h2>

    <form action="/AccademicUnitServlet" method="post">
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label for="code">Unit Code</label>
                    <input type="text" class="form-control" id="code" name="code" placeholder="Enter Unit Code" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="name">Unit Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter Unit Name" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="unit">Unit Type</label>
                    <select class="form-control" id="unit" name="unit">
                        <option value="PROGRAMME">Programme</option>
                        <option value="FACULTY">Faculty</option>
                        <option value="DEPARTMENT">Department</option>
                    </select>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="parent">Parent Unit</label>

                    <select class="form-control" id="parent" name="parent">
                        <option selected>Select Parent</option>
                        <%
                            AccademicUnitInterface ifc1 = new AccademicUnitService();
                            List<AccademicUnit> academicUnitList1 = ifc1.accademicUnitList();
                            for (AccademicUnit academicUnit : academicUnitList1) {
                        %>
                        <option value="<%=academicUnit.getCode()%>"><%=academicUnit.getName()%> </option>
                        <% } %>

                    </select>
                </div>
            </div>
        </div>
        <label style="color: red">${info}</label>
        <label style="color: green">${info1}</label><br>
        <button type="submit" class="btn btn-primary">Save Academic Unit</button>
    </form>

    <table class="table mt-4">
        <thead class="thead-dark">
        <tr>
            <th>Unit Code</th>
            <th>Unit Name</th>
            <th>Unit Type</th>
            <th>Parent Unit</th>

        </tr>
        </thead>
        <tbody>
        <%
            AccademicUnitInterface ifc = new AccademicUnitService();
            List<AccademicUnit> academicUnitList = ifc.accademicUnitList();
            for (AccademicUnit academicUnit : academicUnitList) {
        %>
        <tr>
            <td><%= academicUnit.getCode() %></td>
            <td><%= academicUnit.getName() %></td>
            <td><%= academicUnit.getUnit() %></td>


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

