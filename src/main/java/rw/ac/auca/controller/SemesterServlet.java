package rw.ac.auca.controller;

import rw.ac.auca.model.Semester;
import rw.ac.auca.service.SemesterService;
import rw.ac.auca.service.interfaces.SemesterInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@WebServlet(name = "SemesterServlet", value = "/SemesterServlet")
public class SemesterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Semester semester=new Semester();
        String semId= request.getParameter("semId");
        String startDateString = request.getParameter("startDate");
        String endDateString = request.getParameter("endDate");
        String name=request.getParameter("semName");

// Define a date format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Replace with your date format

        LocalDate startDate = null;
        LocalDate endDate = null;

        try {
            startDate = LocalDate.parse(startDateString, formatter);
            endDate = LocalDate.parse(endDateString, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace(); // Handle parsing exception
        }

        semester.setSemId(semId);
        semester.setName(name);
        semester.setStartDate(startDate);
        semester.setEndDate(endDate);
        SemesterInterface semesterInterface= new SemesterService();
       boolean result= semesterInterface.newSemester(semester);
       if(result==true){
           String info="New Semester Is Added!!";
           request.setAttribute("info",info);

          request.getRequestDispatcher("Semester.jsp").forward(request,response);
       }else {
           String info1="We have This Semester!!";
           request.setAttribute("info1",info1);

           request.getRequestDispatcher("Semester.jsp").forward(request,response);
       }
    }
}
