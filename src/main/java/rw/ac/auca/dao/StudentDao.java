package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import rw.ac.auca.model.Student;
import java.util.List;

public class StudentDao {
    public boolean newStudent(Student student){
        try{
            boolean result = true;
            Session ss= HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.save(student);
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
    public List<Student> studentList(){
        try {
            Session ss= HibernateUtil.getSessionFactory().openSession();
            List<Student> students=ss.createQuery("select std from Student std").list();
            ss.close();
            return students;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}