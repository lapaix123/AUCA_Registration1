package rw.ac.auca.model;

import rw.ac.auca.dao.HibernateUtil;

public class TestModel {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
    }
}
