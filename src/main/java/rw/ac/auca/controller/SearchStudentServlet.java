package rw.ac.auca.controller;

import rw.ac.auca.model.StudentRegistration;
import rw.ac.auca.service.StudentRegService;
import rw.ac.auca.service.interfaces.StudentRegInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchStudentServlet", value = "/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the student ID from the request
        String studentId = request.getParameter("studentId");
        StudentRegInterface infc= new StudentRegService();
        StudentRegistration reg=infc.getStudentRegistrationByStudentId(studentId);
        if(reg != null){
            String stdId= reg.getStudentId();
            String names=reg.getStudent().getfName() +" " +reg.getStudent().getlName();
            request.setAttribute("names",names);
            request.setAttribute("stdId",stdId);
            System.out.println(names);
            request.getRequestDispatcher("StudentCource.jsp").forward(request, response);

        }else{
            String message="Student Not found";
            request.setAttribute("message",message);
            System.out.println();
            request.getRequestDispatcher("StudentCource.jsp").forward(request, response);
        }

    }
}
