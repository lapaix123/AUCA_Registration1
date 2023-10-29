package rw.ac.auca.service.interfaces;

import rw.ac.auca.model.AccademicUnit;
import rw.ac.auca.model.Cource;
import rw.ac.auca.model.CourceDefinition;
import rw.ac.auca.model.Semester;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CourseInterface extends Remote {
    public boolean newCourse(Cource cource) throws RemoteException;
    public List<Cource> courceList() throws  RemoteException;
    public Cource getCourseByCode(String courseCode) throws RemoteException;
    public Cource getCourceByCourceDef(CourceDefinition courceDefinition) throws RemoteException;
    public List<Cource> getCourseByDepartmentAndSemester(AccademicUnit department, Semester semester) throws RemoteException;
}
