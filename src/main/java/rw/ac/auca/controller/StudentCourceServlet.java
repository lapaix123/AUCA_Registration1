package rw.ac.auca.controller;

import rw.ac.auca.model.Cource;
import rw.ac.auca.model.StudentCource;
import rw.ac.auca.model.StudentRegistration;
import rw.ac.auca.service.StudentCourceService;
import rw.ac.auca.service.interfaces.StudentCourceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentCourceServlet", value = "/StudentCourceServlet")
public class StudentCourceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId=request.getParameter("stdregId");
        String courceCode=request.getParameter("course");
        Cource cource=new Cource();
        cource.setCourseCode(courceCode);

        StudentRegistration studentRegistration=new StudentRegistration();
        studentRegistration.setStudentId(studentId);

        StudentCource studentCource=new StudentCource();
        studentCource.setCource(cource);
        studentCource.setStdReg(studentRegistration);

        StudentCourceInterface ifc=new StudentCourceService();
        boolean saved=ifc.addStudentCource(studentCource);
        if(saved){
            request.getRequestDispatcher("StudentCourse.jsp").forward(request,response);
        }
    }

}
