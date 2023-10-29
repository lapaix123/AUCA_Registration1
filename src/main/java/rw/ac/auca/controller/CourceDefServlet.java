package rw.ac.auca.controller;

import rw.ac.auca.model.CourceDefinition;
import rw.ac.auca.service.interfaces.CourceDefInterface;
import rw.ac.auca.service.CourceDefService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CourceDefServlet", value = "/CourceDefServlet")
public class CourceDefServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courceCode= request.getParameter("code");
        String courceName= request.getParameter("name");
        String description=request.getParameter("description");
        CourceDefinition cource= new CourceDefinition();
        CourceDefInterface courceDefInterface= new CourceDefService();
        cource.setName(courceName);
        cource.setDescription(description);
        cource.setCodeDef(courceCode);
        boolean saved=courceDefInterface.newCourceDefinition(cource);
        if(saved == true){
            String info="Course Is Defined!!";
            request.setAttribute("info",info);
            request.getRequestDispatcher("CourseDefinition.jsp").forward(request,response);
        }else {
            String info1="Course Exist !!";
            request.setAttribute("info1",info1);
            request.getRequestDispatcher("CourseDefinition.jsp").forward(request,response);
        }



    }
}
