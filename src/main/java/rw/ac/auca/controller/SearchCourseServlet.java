package rw.ac.auca.controller;

import rw.ac.auca.model.Cource;
import rw.ac.auca.model.CourceDefinition;
import rw.ac.auca.service.CourseService;
import rw.ac.auca.service.interfaces.CourseInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchCourseServlet", value = "/SearchCourseServlet")
public class SearchCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        String stdId= request.getParameter("studentId");
        String stdNames= request.getParameter("studentNAme");
        if(courseId.trim().isEmpty()||stdId.trim().isEmpty()||stdNames.trim().isEmpty()){
            String messege1="Search Student first Or Enter Course_code";
            request.setAttribute("message1",messege1);
            request.getRequestDispatcher("StudentCource.jsp").forward(request,response);
        }
        else {
            CourseInterface infc = new CourseService();
            Cource cource1 = infc.getCourseByCode(courseId);


            if (cource1 != null) {
                String cname = cource1.getCourceDefinition().getName();
                String cCredit = cource1.getCredit() + "";
                request.setAttribute("courseId",courseId);
                request.setAttribute("stdId",stdId);
                request.setAttribute("names",stdNames);
                request.setAttribute("cname", cname);
                request.setAttribute("cCredit", cCredit);
                request.getRequestDispatcher("StudentCource.jsp").forward(request, response);

            } else {
                String messege1 = "course Not found";
                request.setAttribute("message1", messege1);
                request.getRequestDispatcher("StudentCource.jsp").forward(request, response);

            }
        }
    }
}
