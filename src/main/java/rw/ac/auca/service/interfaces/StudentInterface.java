package rw.ac.auca.service.interfaces;

import rw.ac.auca.model.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentInterface extends Remote {
    public boolean newStudent(Student student) throws RemoteException;
    public List<Student> studentList() throws RemoteException;
}
