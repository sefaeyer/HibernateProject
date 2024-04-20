package com.hb11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {

    public static void main(String[] args) {

        Student11 student1 = new Student11();
        student1.setName("Emre Bey");
        student1.setMathGrade(55);

        Student11 student2 = new Student11();
        student2.setName("Kenan Bey");
        student2.setMathGrade(55);

        Student11 student3 = new Student11();
        student3.setName("Ayse Hanim");
        student3.setMathGrade(55);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sf.close();
    }
}