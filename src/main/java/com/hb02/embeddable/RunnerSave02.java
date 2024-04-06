package com.hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {



        // 1. Ogrenci :
        Student02 student1 = new Student02();
        student1.setId(1001);
        student1.setName("Ayse Hanim");
        student1.setGrade(80);

        Address address1 = new Address();
        address1.setStreet("Apple Street");
        address1.setCity("Istabul");
        address1.setCountry("Turkey");
        address1.setZipCode("34000");

        student1.setAddress(address1);

        // 2. Ogrenci :
        Student02 student2 = new Student02();
        student2.setId(1002);
        student2.setName("Abdullah Bey");
        student2.setGrade(80);

        Address address2 = new Address();
        address2.setStreet("Orange Street");
        address2.setCity("Ankara");
        address2.setCountry("Turkey");
        address2.setZipCode("06000");

        student2.setAddress(address2);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1);
        session.save(student2);





        tx.commit();
        session.close();
        sf.close();

    }
}
