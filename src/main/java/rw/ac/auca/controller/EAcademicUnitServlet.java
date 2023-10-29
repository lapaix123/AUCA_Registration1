package rw.ac.auca.controller;

import rw.ac.auca.model.enums.EAccademicUnit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EAcademicUnitServlet", value = "/EAcademicUnitServlet")
public class EAcademicUnitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("accademicUnits", EAccademicUnit.values());
        request.getRequestDispatcher("AccademicUnit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("accademicUnits", EAccademicUnit.values());
        request.getRequestDispatcher("AccademicUnit.jsp").forward(request, response);


    }
}
