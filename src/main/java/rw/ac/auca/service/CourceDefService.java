package rw.ac.auca.service;

import rw.ac.auca.dao.CourceDefDao;
import rw.ac.auca.model.CourceDefinition;
import rw.ac.auca.service.interfaces.CourceDefInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CourceDefService extends UnicastRemoteObject implements CourceDefInterface {
    public CourceDefService() throws RemoteException {
        super();
    }
    CourceDefDao dao =new CourceDefDao();
    @Override
    public boolean newCourceDefinition(CourceDefinition courceDefinition) throws RemoteException {
        return dao.newCourceDefinition(courceDefinition);
    }

    @Override
    public List<CourceDefinition> courceDefinitionList() throws RemoteException {
        return dao.courceDefinitionList();
    }
}
