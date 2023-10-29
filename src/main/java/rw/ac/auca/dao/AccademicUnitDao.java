package rw.ac.auca.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import rw.ac.auca.model.AccademicUnit;

import java.util.List;

public class AccademicUnitDao {
    public boolean createAcademicUnit(AccademicUnit accademicUnit){
        try {
            boolean result= true;
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.save(accademicUnit);
            tr.commit();
            ss.close();
            return result;

        }catch (ConstraintViolationException ex){
            ex.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateAcademicUnit(AccademicUnit accademicUnit){
        try {
            boolean result= true;
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.update(accademicUnit);
            tr.commit();
            ss.close();

            return result;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteAcademicUnit(AccademicUnit accademicUnit){
        try {
            boolean result= true;
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.delete(accademicUnit);
            tr.commit();
            ss.close();

            return result;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public List<AccademicUnit> accademicUnitList(){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<AccademicUnit> accademicUnits = ss.createQuery("select academic from AccademicUnit academic").list();

            ss.close();
            return accademicUnits;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AccademicUnit getAccademicUnitById(String code) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.beginTransaction();

            // Use HQL to retrieve the entity by code
            Query query = session.createQuery("FROM AccademicUnit WHERE code = :code");
            query.setParameter("code", code);

            AccademicUnit accademicUnit = (AccademicUnit) query.uniqueResult(); // Assuming code is unique

            tr.commit();
            session.close();

            return accademicUnit;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AccademicUnit> getAllPrograms() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<AccademicUnit> programs = session.createQuery("FROM AccademicUnit WHERE unit = 'PROGRAM'").list();
            session.close();
            return programs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<AccademicUnit> getAllDepartments() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<AccademicUnit> departments = session.createQuery("FROM AccademicUnit WHERE unit = 'DEPARTMENT'").list();
            session.close();
            return departments;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<AccademicUnit> getAllFaculties() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<AccademicUnit> faculties = session.createQuery("FROM AccademicUnit WHERE unit = 'FACULTY'").list();
            session.close();
            return faculties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
