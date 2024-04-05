package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // !!! DB den bilgi cekmek icin 3 yol:

                // 1) get methodu
                // 2) SQL
                // 3) HQL (Hibernate Query Language)

        // NOT: Get() ************************************
        Student01 student1 = session.get(Student01.class, 1001);
        System.out.println("student1 = " + student1);


        tx.commit();
        session.close();
        sf.close();
    }
}
