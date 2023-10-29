package rw.ac.auca.controller;

import rw.ac.auca.model.*;
import rw.ac.auca.service.CourseService;
import rw.ac.auca.service.interfaces.CourseInterface;
import rw.ac.auca.service.interfaces.CourseInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CourseServlet", value = "/CourseServlet")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int credit =Integer.parseInt(request.getParameter("credit")) ;
        String courseDefinitionId = request.getParameter("courseDefinition");
        String teacherId = request.getParameter("teacher");
        String semesterId = request.getParameter("semester");
        String courseCode=request.getParameter("courseCode");
        String department=request.getParameter("accademicUnit");


        Cource course = new Cource();
        CourceDefinition def=new CourceDefinition();
        def.setCodeDef(String.valueOf(courseDefinitionId));
        Teacher tc=new Teacher();
        tc.settCode(String.valueOf(teacherId));
        Semester sem= new Semester();
        sem.setSemId(String.valueOf(semesterId));

        AccademicUnit accademicUnit=new AccademicUnit();
        accademicUnit.setCode(department);

        course.setCredit(credit);
        course.setCourceDefinition(def);
        course.setTreTeacher(tc);
        course.setSemester(sem);
        course.setAccademicUnit(accademicUnit);
        course.setCourseCode(courseCode);



        CourseInterface courseService = new CourseService();
        boolean saved= courseService.newCourse(course);
        if(saved ==true){
            request.getRequestDispatcher("Course.jsp").forward(request,response);
        }



    }
}
