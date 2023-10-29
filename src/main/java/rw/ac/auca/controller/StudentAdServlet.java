package rw.ac.auca.controller;

import rw.ac.auca.model.Student;
import rw.ac.auca.service.StudentRegService;
import rw.ac.auca.service.StudentService;
import rw.ac.auca.service.interfaces.StudentInterface;
import rw.ac.auca.service.interfaces.StudentRegInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentAdServlet", value = "/StudentAdServlet")
public class StudentAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regNo= request.getParameter("regNo");
        String fName=request.getParameter("fName");
        String lName=request.getParameter("lName");
        String dateOfBirth= request.getParameter("dateOfBirth");
        Student student=new Student();
        student.setRegNo(regNo);
        student.setfName(fName);
        student.setlName(lName);
        student.setDateOfBirth(dateOfBirth);
        StudentInterface infc=new StudentService();
        boolean result=infc.newStudent(student);
        if(result == true){
            String message="Dear "+fName+" and "+lName+" you have Send your Request with new Reg Number "+regNo;
            request.setAttribute("message",message);
            request.getRequestDispatcher("Student.jsp").forward(request,response);
        }else {
            String message="Dear "+fName+" and "+lName+" Sutudent of this information exist "+regNo;
            request.setAttribute("message",message);
            request.getRequestDispatcher("Student.jsp").forward(request,response);
        }

    }
}
