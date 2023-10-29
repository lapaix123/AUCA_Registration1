package rw.ac.auca.controller;

import rw.ac.auca.model.AccademicUnit;
import rw.ac.auca.model.Semester;
import rw.ac.auca.model.Student;
import rw.ac.auca.model.StudentRegistration;
import rw.ac.auca.model.enums.ERegistrationStatus;
import rw.ac.auca.service.StudentRegService;
import rw.ac.auca.service.interfaces.StudentRegInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "StudentRegServlet", value = "/StudentRegServlet")
public class StudentRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String registrationDate = request.getParameter("registrationDate");
        String academicUnitId = request.getParameter("academicUnit");
        String registrationStatus = request.getParameter("registrationStatus");
        String studentName = request.getParameter("student");
        String semesterId = request.getParameter("semester");
        System.out.println(studentName+"this your student name");

       System.out.println("Sydent id "+studentId);
        System.out.println("Regstration date "+registrationDate);
        System.out.println("accademic Unit "+academicUnitId);
        System.out.println("registartion Status "+registrationStatus);
        System.out.println("student names "+studentName);
        System.out.println("semester id "+semesterId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDate regDate= null;
        regDate = LocalDate.parse(registrationDate,formatter);


        StudentRegistration registration=new StudentRegistration();
        registration.setRegistrationDate(regDate);
        registration.setStudentId(studentId);
        registration.setRegstatus(ERegistrationStatus.valueOf(registrationStatus));

        AccademicUnit acc= new AccademicUnit();
        acc.setCode(academicUnitId);

        Student std= new Student();
        std.setRegNo(studentName);

        Semester sem= new Semester();
        sem.setSemId(semesterId);
        registration.setAccademicUnit(acc);
        registration.setStudent(std);
        registration.setSemester(sem);

        StudentRegInterface infc=new StudentRegService();
        boolean saved=infc.newStudentRegistration(registration);
        if(saved ==true){
            String info="Student Registered!!";
            request.setAttribute("info",info);

            request.getRequestDispatcher("StudentRegistration.jsp").forward(request,response);
        }else {
            String info1="Student Not Registered!!";
            request.setAttribute("info1",info1);

            request.getRequestDispatcher("StudentRegistration.jsp").forward(request,response);
        }


    }
}
