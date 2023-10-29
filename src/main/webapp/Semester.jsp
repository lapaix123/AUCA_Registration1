<%--
  Created by IntelliJ IDEA.
  User: Bijoux
  Date: 20/10/2023
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="rw.ac.auca.service.interfaces.SemesterInterface" %>
<%@ page import="rw.ac.auca.service.SemesterService" %>
<%@ page import="rw.ac.auca.model.Semester" %>


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
  <h2  style="color: dodgerblue">Semester Information Form</h2>

  <form  method="post" action="/SemesterServlet">
    <div class="row">
      <div class="col-md-3">
        <div class="form-group">
          <label for="semId">Semester ID</label>
          <input type="text" class="form-control" id="semId" name="semId" placeholder="Enter Semester ID" required>
        </div>
      </div>
      <div class="col-md-3">
        <div class="form-group">
          <label for="semNAme">Semester Names</label>
          <input type="text" class="form-control" id="semNAme" name="semName" placeholder="Enter Semester Names" required>
        </div>
      </div>
      <div class="col-md-3">
        <div class="form-group">
          <label for="startDate">Start Date</label>
          <input type="date" class="form-control" id="startDate" name="startDate" required>
        </div>
      </div>
      <div class="col-md-3">
        <div class="form-group">
          <label for="endDate">End Date</label>
          <input type="date" class="form-control" id="endDate" name="endDate" required>
        </div>
      </div>
    </div>
    <label>${message}</label><br>
    <button type="submit" class="btn btn-primary">Save Semester</button>
  </form>

  <table class="table mt-4">
    <thead class="thead-dark">
    <tr>
      <th>Semester ID</th>
      <th>Start Date</th>
      <th>End Date</th>
      <th>Sem NAme</th>

    </tr>
    </thead>
    <tbody>
    <%
      SemesterInterface ifc = new SemesterService();
      List<Semester> semesterList = ifc.semesterList();
      for (Semester semester : semesterList) {
    %>
    <tr>
      <td><%= semester.getSemId() %></td>
      <td><%= semester.getStartDate() %></td>
      <td><%= semester.getEndDate() %></td>
      <td><%=semester.getName()%></td>


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
