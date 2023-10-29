package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import rw.ac.auca.model.Semester;

import java.util.List;

public class SemesterDao {

    public boolean newSemester(Semester semester){
        try {
            Session ss= HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            boolean result= true;
            ss.save(semester);
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
    public boolean updateSemester(Semester semester){
        try {
            Session ss= HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            boolean result= true;
            ss.update(semester);
            tr.commit();
            ss.close();
            return result;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteSemester(Semester semester){
        try {
            Session ss= HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            boolean result= true;
            ss.delete(semester);
            tr.commit();
            ss.close();
            return result;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Semester> semesterList(){
        try {
            Session ss= HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            List<Semester> semesters= ss.createQuery("select semester from Semester  semester").list();
            ss.close();
            return  semesters;


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
