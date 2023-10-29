package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import rw.ac.auca.model.Teacher;

import java.util.List;

public class TeacherDao {
    public boolean newTeacher(Teacher teacher){
        try{
            boolean result = true;
            Session ss= HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.save(teacher);
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
    public List<Teacher> teacherList(){
        try {
            Session ss= HibernateUtil.getSessionFactory().openSession();
            List<Teacher> teachers=ss.createQuery("select t from Teacher t").list();
            ss.close();
            return teachers;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
