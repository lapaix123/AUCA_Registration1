package rw.ac.auca.service;

import rw.ac.auca.dao.TeacherDao;
import rw.ac.auca.model.Teacher;
import rw.ac.auca.service.interfaces.TeacherInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TeacherService extends UnicastRemoteObject implements TeacherInterface {
    public TeacherService() throws RemoteException {
        super();
    }
    TeacherDao dao= new TeacherDao();

    @Override
    public boolean newTeacher(Teacher teacher) throws RemoteException {
        return dao.newTeacher(teacher);
    }

    @Override
    public List<Teacher> teacherList() throws RemoteException {
        return dao.teacherList();
    }
}
