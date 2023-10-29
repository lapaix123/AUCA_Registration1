package rw.ac.auca.service;

import rw.ac.auca.dao.StudentDao;
import rw.ac.auca.model.Student;
import rw.ac.auca.service.interfaces.StudentInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StudentService extends UnicastRemoteObject implements StudentInterface {
    public StudentService() throws RemoteException{
        super();
    }
    StudentDao dao=new StudentDao();
    @Override
    public boolean newStudent(Student student) throws RemoteException {
        return dao.newStudent(student);
    }

    @Override
    public List<Student> studentList() throws RemoteException {
        return dao.studentList();
    }
}
