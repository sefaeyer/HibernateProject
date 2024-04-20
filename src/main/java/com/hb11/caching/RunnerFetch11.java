package com.hb11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch11 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("************** Ilk Get Islemi --> 1 id li Student icin : *****************");
        Student11 student1 = session.get(Student11.class,1);

        session.clear();
        System.out.println("-----  session.clear  yapildi   -------");

        System.out.println("************** Ikinci Get Islemi --> 1 id li Student icin : *****************");
        Student11 student2 = session.get(Student11.class,1);




        tx.commit();
        session.close();

        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();

        System.out.println("************** Session1 close sonrasi --> 1 id li Student icin : *****************");
        Student11 student3 = session2.get(Student11.class,1);



        tx2.commit();
        session2.close();

        sf.close();

    }
}
