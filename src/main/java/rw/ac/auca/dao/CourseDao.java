package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import rw.ac.auca.model.AccademicUnit;
import rw.ac.auca.model.Cource;
import rw.ac.auca.model.CourceDefinition;
import rw.ac.auca.model.Semester;

import java.util.List;

public class CourseDao {
    public boolean newCourse(Cource cource){
        try {
            boolean result= true;
            Session ss= HibernateUtil.getSessionFactory().openSession();
            Transaction tr=ss.beginTransaction();
            ss.save(cource);
            tr.commit();
            ss.close();

            return  result;
        }catch (ConstraintViolationException ex){
            ex.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Cource> courceList(){
        try {
            Session ss= HibernateUtil.getSessionFactory().openSession();
            List<Cource> cources=ss.createQuery("select course from Cource course").list();

            ss.close();
            return cources;


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Cource getCourseByCode(String courseCode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Cource cource = null;

        try {
            transaction = session.beginTransaction();
            // Update your query to search for a course by code
            Query<Cource> query = session.createQuery("FROM Cource WHERE courceDefinition.code = :code", Cource.class);
            query.setParameter("code", courseCode);

            cource = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return cource;
    }

    public Cource getCourceByCourceDef(CourceDefinition courceDefinition) {

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // Create an HQL query to find the Course by CourceDefinition
                String hql = "FROM Cource WHERE courceDefinition = :courceDefinition";
                Query<Cource> query = session.createQuery(hql, Cource.class);
                query.setParameter("courceDefinition", courceDefinition);

                return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


}
    public List<Cource> getCourseByDepartmentAndSemester(AccademicUnit department, Semester semester){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Cource sr WHERE sr.accademicUnit = :department AND sr.semester = :semester";
            Query<Cource> query = session.createQuery(hql, Cource.class);
            query.setParameter("department", department);
            query.setParameter("semester", semester);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
