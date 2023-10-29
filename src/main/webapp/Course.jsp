<%@ page import="java.util.List" %>
<%@ page import="rw.ac.auca.model.*" %>
<%@ page import="rw.ac.auca.service.*" %>
<%@ page import="rw.ac.auca.service.interfaces.*" %>
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
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addCourseModal">Add New Course</button>
    <h2 class="display-4" style="color: dodgerblue">Course List</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Course Code</th>
            <th>Course Credit</th>
            <th>Course Definition</th>
            <th>Teacher</th>
            <th>Semester</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <!-- Loop through your existing courses and display them here -->
        <%
            List<Cource> courseList = null;
            try {
                CourseInterface courseService = new CourseService();
                courseList = courseService.courceList();

                for (Cource course : courseList) {
        %>
        <tr>
            <td><%=course.getCourseCode()%></td>
            <td><%= course.getCredit() %></td>
            <td><%= course.getCourceDefinition().getName() %></td>
            <td><%= course.getTreTeacher().getName() %></td>
            <td><%= course.getSemester().getName() %></td>

        </tr>
        <%
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        %>

        </tbody>
    </table>
    <!-- New Course Form Modal -->
    <div class="modal fade" id="addCourseModal" tabindex="-1" role="dialog" aria-labelledby="addCourseModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addCourseModalLabel">Add New Course</h5>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="post" action="/CourseServlet" class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="cd" class="form-label">Course Code</label>
                            <input type="text" class="form-control" id="cd" name="courseCode" required>
                        </div>
                        <div class="mb-3">
                            <label for="credit" class="form-label">Course Credit</label>
                            <input type="text" class="form-control" id="credit" name="credit" required>
                        </div>
                        <div class="mb-3">
                            <label for="courseDefinition" class="form-label">Course Definition</label>
                            <select class="form-select" id="courseDefinition" name="courseDefinition" required>
                                <%

                                    CourceDefInterface courseInterface = new CourceDefService();
                                    List<CourceDefinition> cdf = courseInterface.courceDefinitionList();

                                    for (CourceDefinition course : cdf) {
                                %>
                                <option value="<%= course.getCodeDef() %>"><%= course.getName() %></option>
                                <%
                                    }
                                %>

                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="teacher" class="form-label">Teacher</label>
                            <select class="form-select" id="teacher" name="teacher" required>
                                <%
                                    List<Teacher> teacherList = null;

                                    TeacherInterface infc = new TeacherService();
                                    teacherList = infc.teacherList();

                                    for (Teacher teacher : teacherList) {
                                %>
                                <option value="<%= teacher.gettCode() %>"><%= teacher.getName() %></option>
                                <%
                                    }
                                %>

                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="semester" class="form-label">Semester</label>
                            <select class="form-select" id="semester" name="semester" required>
                                <%
                                    List<Semester> semesterList = null;

                                    SemesterInterface inf = new SemesterService();
                                    semesterList = inf.semesterList();

                                    for (Semester semester : semesterList) {
                                %>
                                <option value="<%= semester.getSemId() %>"><%= semester.getName() %></option>
                                <%

                                    }
                                %>


                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="acc" class="form-label">Accademic unit</label>
                            <select class="form-select" id="acc" name="accademicUnit" required>
                                <%
                                    List<AccademicUnit> accademicUnits = null;

                                    AccademicUnitInterface f = new AccademicUnitService();
                                    accademicUnits = f.getAllDepartments();

                                    for (AccademicUnit accc : accademicUnits) {
                                %>
                                <option value="<%= accc.getCode() %>"><%= accc.getName() %></option>
                                <%

                                    }
                                %>


                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Add Course</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
