package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import rw.ac.auca.model.AccademicUnit;
import rw.ac.auca.model.Semester;
import rw.ac.auca.model.StudentRegistration;

import java.util.List;

public class StudentRegistrationDao {
    public boolean newStudentRegistration(StudentRegistration studentRegistration){
        try {
            boolean result=true;
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.save(studentRegistration);
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
    public boolean updateStudentRegistration(StudentRegistration studentRegistration){
        try {
            boolean result=true;
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.update(studentRegistration);
            tr.commit();
            ss.close();

            return result;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean deleteStudentRegistration(StudentRegistration studentRegistration){
        try {
            boolean result=true;
            Session ss=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.delete(studentRegistration);
            tr.commit();
            ss.close();

            return result;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public List<StudentRegistration> studentRegistrationList(){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            List<StudentRegistration> studentRegistrations=ss.createQuery("select  studentReg from StudentRegistration studentReg").list();
            ss.close();
            return studentRegistrations;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public StudentRegistration getStudentRegistrationByStudentId(String studentId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            StudentRegistration studentRegistration = (StudentRegistration) session.createQuery("from StudentRegistration where studentId = :id")
                    .setParameter("id", studentId)
                    .uniqueResult();
            session.close();
            return studentRegistration;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentRegistration> getStudentsBySemester(Semester semester) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM StudentRegistration sr WHERE sr.semester = :semester";
            Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
            query.setParameter("semester", semester);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentRegistration> getStudentsByDepartmentAndSemester(AccademicUnit department, Semester semester) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM StudentRegistration sr WHERE sr.accademicUnit = :department AND sr.semester = :semester";
            Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
            query.setParameter("department", department);
            query.setParameter("semester", semester);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
