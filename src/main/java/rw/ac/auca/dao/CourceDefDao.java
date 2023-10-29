package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import rw.ac.auca.model.CourceDefinition;


import java.util.List;

public class CourceDefDao {
    public boolean newCourceDefinition(CourceDefinition courceDefinition){
        try{
            boolean result = true;
            Session ss= HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.save(courceDefinition);
            tr.commit();
            ss.close();

            return true;
        }catch (ConstraintViolationException ex){
            ex.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public List<CourceDefinition> courceDefinitionList(){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<CourceDefinition> courceDefinitions = ss.createQuery("select cd FROM CourceDefinition cd").list();
            ss.close();
            return courceDefinitions;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
