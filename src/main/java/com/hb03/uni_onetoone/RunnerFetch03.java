package com.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //!!! student fetch ediyoruz 1001 id
        Student03 student1 = session.get(Student03.class,1001);
        //!!! diary yi fetch ediyoruz 101
        Diary diary1 = session.get(Diary.class,101);

        System.out.println(student1);
        System.out.println("==================================================");
        System.out.println(diary1);
        System.out.println("___________________________________________________");
        System.out.println(diary1.getStudent());


        tx.commit();
        session.close();
        sf.close();
    }
}
