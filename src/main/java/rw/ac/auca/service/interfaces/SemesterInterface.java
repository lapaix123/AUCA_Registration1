package rw.ac.auca.service.interfaces;

import rw.ac.auca.model.Semester;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SemesterInterface extends Remote {
    public boolean newSemester(Semester semester) throws RemoteException;
    public boolean updateSemester(Semester semester) throws RemoteException;
    public boolean deleteSemester(Semester semester) throws RemoteException;
    public List<Semester> semesterList() throws RemoteException;
}
