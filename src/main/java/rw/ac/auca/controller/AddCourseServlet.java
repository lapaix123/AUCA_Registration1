package rw.ac.auca.controller;

import rw.ac.auca.dao.CourseDao;
import rw.ac.auca.model.*;
import rw.ac.auca.service.CourseService;
import rw.ac.auca.service.StudentCourceService;
import rw.ac.auca.service.interfaces.CourseInterface;
import rw.ac.auca.service.interfaces.StudentCourceInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.io.IOException;

@WebServlet(name = "AddCourseServlet", value = "/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        String stdId= request.getParameter("studentId");

        System.out.println("corce Id "+courseId);
        System.out.println("Student Id"+stdId);


        if(courseId.trim().isEmpty()||stdId.trim().isEmpty()){
            String trimmedCourseId = courseId.trim();
            String messege1="Search Student first Or Enter Course_code";
            request.setAttribute("message1",messege1);
            request.getRequestDispatcher("StudentCource.jsp").forward(request,response);
        }
        else {
            // Load or create the Student entity if not already available
            StudentRegistration stdreg = new StudentRegistration();
            stdreg.setStudentId(stdId);

            // Create the StudentCource entity and associate it with the Student and Course
            StudentCource studentCource = new StudentCource();
            studentCource.setStdReg(stdreg);

            // Find the Course by its CourceDefinition
            CourseDao courseDao = new CourseDao();
            CourceDefinition courceDefinition = new CourceDefinition();
            courceDefinition.setCodeDef(courseId);

            // Use the CourseDao method to find the Course
            Cource cource = courseDao.getCourceByCourceDef(courceDefinition);

            if (cource != null) {
                studentCource.setCource(cource);

                // Now, you can save the StudentCource entity with the associated Course
                StudentCourceInterface infc = new StudentCourceService();
                boolean saved = infc.addStudentCource(studentCource);

            if (saved == true) {
                String message="Cource added!";
                request.setAttribute("message11",message);
                request.getRequestDispatcher("StudentCource.jsp").forward(request, response);

            } else {
                String messege1 = "Course Not addde!!";
                request.setAttribute("message1", messege1);
                request.getRequestDispatcher("StudentCource.jsp").forward(request, response);

            }
        }
    }}
}
