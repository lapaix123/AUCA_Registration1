package rw.ac.auca.service;

import rw.ac.auca.dao.StudentCourceDao;
import rw.ac.auca.model.Cource;
import rw.ac.auca.model.Semester;
import rw.ac.auca.model.StudentCource;
import rw.ac.auca.model.StudentRegistration;
import rw.ac.auca.service.interfaces.StudentCourceInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StudentCourceService extends UnicastRemoteObject implements StudentCourceInterface {
    public StudentCourceService() throws RemoteException {
        super();
    }
StudentCourceDao dao = new StudentCourceDao();
    @Override
    public boolean addStudentCource(StudentCource studentCource) throws RemoteException {
        return dao.addStudentCource(studentCource);
    }

    @Override
    public boolean removeStudentCource(StudentCource studentCource) throws RemoteException {
        return dao.removeStudentCource(studentCource);
    }

    @Override
    public List<StudentCource> getStudentCourcesByStudent(StudentRegistration student) throws RemoteException {
        return dao.getStudentCourcesByStudent(student);
    }

    @Override
    public List<StudentCource> getStudentCourcesByCourse(Cource course) throws RemoteException {
        return dao.getStudentCourcesByCourse(course);
    }

    @Override
    public List<StudentCource> studentCourceList() throws RemoteException {
        return dao.studentCourceList();
    }

    @Override
    public List<StudentCource> getStudentsByCourseAndSemester(Cource cource, Semester semester) throws RemoteException {
        return dao.getStudentsByCourseAndSemester(cource,semester);
    }
}
