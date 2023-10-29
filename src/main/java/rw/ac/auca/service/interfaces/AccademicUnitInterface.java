package rw.ac.auca.service.interfaces;

import rw.ac.auca.model.AccademicUnit;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AccademicUnitInterface extends Remote {
    public boolean createAcademicUnit(AccademicUnit accademicUnit) throws RemoteException;
    public boolean updateAcademicUnit(AccademicUnit accademicUnit)throws RemoteException;
    public boolean deleteAcademicUnit(AccademicUnit accademicUnit)throws RemoteException;
    public List<AccademicUnit> accademicUnitList()throws RemoteException;
    public AccademicUnit getAccademicUnitById(String code) throws RemoteException;
    public List<AccademicUnit> getAllPrograms() throws RemoteException;
    public List<AccademicUnit> getAllDepartments() throws RemoteException;
    public List<AccademicUnit> getAllFaculties() throws RemoteException;
}
