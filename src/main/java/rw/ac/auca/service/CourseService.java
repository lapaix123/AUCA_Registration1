package rw.ac.auca.service;

import rw.ac.auca.dao.CourceDefDao;
import rw.ac.auca.dao.CourseDao;
import rw.ac.auca.model.AccademicUnit;
import rw.ac.auca.model.Cource;
import rw.ac.auca.model.CourceDefinition;
import rw.ac.auca.model.Semester;
import rw.ac.auca.service.interfaces.CourseInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CourseService extends UnicastRemoteObject implements CourseInterface {
    public CourseService() throws RemoteException {
        super();
    }
    CourseDao dao=new CourseDao();

    @Override
    public boolean newCourse(Cource cource) throws RemoteException {
        return dao.newCourse(cource);
    }

    @Override
    public List<Cource> courceList() throws RemoteException {
        return dao.courceList();
    }

    @Override
    public Cource getCourseByCode(String courseCode) throws RemoteException {
        return dao.getCourseByCode(courseCode);
    }

    @Override
    public Cource getCourceByCourceDef(CourceDefinition courceDefinition) throws RemoteException {
        return dao.getCourceByCourceDef(courceDefinition);
    }

    @Override
    public List<Cource> getCourseByDepartmentAndSemester(AccademicUnit department, Semester semester) throws RemoteException {
        return dao.getCourseByDepartmentAndSemester(department,semester);
    }


}
