package rw.ac.auca.service.interfaces;

import rw.ac.auca.model.CourceDefinition;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CourceDefInterface extends Remote {
    public boolean newCourceDefinition(CourceDefinition courceDefinition) throws RemoteException;
    public List<CourceDefinition> courceDefinitionList() throws RemoteException;
}
