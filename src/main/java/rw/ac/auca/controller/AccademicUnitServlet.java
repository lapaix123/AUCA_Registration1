package rw.ac.auca.controller;

import rw.ac.auca.dao.AccademicUnitDao;
import rw.ac.auca.model.AccademicUnit;
import rw.ac.auca.model.enums.EAccademicUnit;
import rw.ac.auca.service.interfaces.AccademicUnitInterface;
import rw.ac.auca.service.AccademicUnitService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccademicUnitServlet", value = "/AccademicUnitServlet")
public class AccademicUnitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccademicUnitInterface ifc= new AccademicUnitService();
        AccademicUnit accademicUnit = new AccademicUnit();
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        String parentId = request.getParameter("parent");
        System.out.println("parent id "+ parentId);

        if (!parentId.trim().isEmpty()) {
            AccademicUnit parent= ifc.getAccademicUnitById(parentId);
            if (parent != null) {
                AccademicUnit acc=new AccademicUnit();
                acc.setCode(parentId);

                accademicUnit.setParent(acc);
            }
        }

        accademicUnit.setUnit(EAccademicUnit.valueOf(unit));
        accademicUnit.setName(name);
        accademicUnit.setCode(code);

        boolean saved=ifc.createAcademicUnit(accademicUnit);
        if(saved ==true){
            String info="Academic Unit Added";
            request.setAttribute("info",info);
            request.getRequestDispatcher("AcademicUnit.jsp").forward(request,response);
        }else{
            String info1="Academic Unit Exist !!";
            request.setAttribute("info1",info1);
            request.getRequestDispatcher("AcademicUnit.jsp").forward(request,response);

        }

    }
}
