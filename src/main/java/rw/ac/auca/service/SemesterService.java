package rw.ac.auca.service;

import rw.ac.auca.dao.SemesterDao;
import rw.ac.auca.model.Semester;
import rw.ac.auca.service.interfaces.SemesterInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SemesterService extends UnicastRemoteObject implements SemesterInterface {
    public SemesterService() throws RemoteException {
        super();
    }

    SemesterDao dao= new SemesterDao();
    @Override
    public boolean newSemester(Semester semester) throws RemoteException {
        return dao.newSemester(semester);
    }

    @Override
    public boolean updateSemester(Semester semester) throws RemoteException {
        return dao.updateSemester(semester);
    }

    @Override
    public boolean deleteSemester(Semester semester) throws RemoteException {
        return dao.deleteSemester(semester);
    }

    @Override
    public List<Semester> semesterList() throws RemoteException {
        return dao.semesterList();
    }
}
