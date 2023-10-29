package rw.ac.auca.service.interfaces;

import rw.ac.auca.model.Cource;
import rw.ac.auca.model.Semester;
import rw.ac.auca.model.StudentCource;
import rw.ac.auca.model.StudentRegistration;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentCourceInterface extends Remote {
    public boolean addStudentCource(StudentCource studentCource) throws RemoteException;
    public boolean removeStudentCource(StudentCource studentCource) throws RemoteException;
    public List<StudentCource> getStudentCourcesByStudent(StudentRegistration student) throws RemoteException;
    public List<StudentCource> getStudentCourcesByCourse(Cource course) throws RemoteException;
    public List<StudentCource> studentCourceList() throws RemoteException;
    public List<StudentCource> getStudentsByCourseAndSemester(Cource cource, Semester semester) throws RemoteException;
}
