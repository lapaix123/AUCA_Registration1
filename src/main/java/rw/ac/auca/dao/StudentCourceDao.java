package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import rw.ac.auca.model.Cource;
import rw.ac.auca.model.Semester;
import rw.ac.auca.model.StudentCource;
import rw.ac.auca.model.StudentRegistration;

import java.util.List;

public class StudentCourceDao {
    public boolean addStudentCource(StudentCource studentCource) {
        try {
            boolean result = true;
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(studentCource);
            transaction.commit();
            session.close();
            return result;
        } catch (ConstraintViolationException ex){
            ex.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeStudentCource(StudentCource studentCource) {
        try {
            boolean result = true;
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(studentCource);
            transaction.commit();
            session.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<StudentCource> getStudentCourcesByStudent(StudentRegistration student) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<StudentCource> studentCources = session.createQuery("select sc from StudentCource sc where sc.stdReg = :student")
                    .setParameter("student", student)
                    .list();
            session.close();
            return studentCources;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    public List<StudentCource> getStudentCourcesByCourse(Cource course) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<StudentCource> studentCources = session.createQuery("select sc from StudentCource sc where sc.cource = :course")
                    .setParameter("course", course)
                    .list();
            session.close();
            return studentCources;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentCource> studentCourceList(){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            List<StudentCource> studentCources =ss.createQuery("from StudentCource std").list();
            ss.close();
            return studentCources;


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<StudentCource> getStudentsByCourseAndSemester(Cource cource, Semester semester) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM StudentCource sr WHERE sr.cource = :cource AND sr.stdReg.semester = :semester";
            Query<StudentCource> query = session.createQuery(hql, StudentCource.class);
            query.setParameter("cource", cource);
            query.setParameter("semester", semester);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
