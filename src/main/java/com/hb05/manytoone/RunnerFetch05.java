package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {


        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();


//        Student05 student = session.get(Student05.class,1001);
//        System.out.println(student.getUniversity());


        //!!! TASK : 1 id li üniversiteye giden bütün öğrencileri bulalım
        String hqlQuery1 = "FROM Student05 s WHERE s.university.id=1";
        List<Student05> resultList1 = session.createQuery(hqlQuery1, Student05.class).getResultList();
        resultList1.forEach(t-> System.out.println(t));

        //2.yol
        resultList1.forEach(System.out::println);



        tx.commit();
        session.close();
        sf.close();
    }
}
