package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch04 {
    public static void main(String[] args) {


        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student04 student = session.get(Student04.class,1001);
//        Diary04 diary = session.get(Diary04.class,101);
//
//        System.out.println(student);
//        System.out.println("==================================================");
//        System.out.println(student.getDiary());
//        System.out.println("_____________________________________________________******");
//        System.out.println(diary);
//        System.out.println("=======================================================******");
//        System.out.println(diary.getStudent());


//        // Task = Diary si olan Ogrencilerin isimlerini ve gunluklerinin isimlerini getirelim :
//        String hqlQuery1 = "SELECT s.name,d.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id=d.student";
//        // -> NATIVE SQL   -->    SELECT s.std_name, d.name FROM student04 s INNER JOIN diary04 d ON s.id=d.std_id
//        List<Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
//        for (Object[] objects : resultList1){
//            System.out.println(Arrays.toString(objects));
//        }
//        //2.yol
//        resultList1.forEach(t->{
//            System.out.println(Arrays.toString(t));
//        });


        //!!! TASK : bütün öğrenciler ve varsa bu ogrencilerin kitablarini da getirelim

//        String hqlQuery2 = "SELECT s.name,d.name FROM Student04 s LEFT JOIN FETCH Diary04 d ON s.id=d.student";
//        List<Object[]> resultList2 = session.createQuery(hqlQuery2).getResultList();
//        resultList2.forEach(t->{
//            System.out.println(Arrays.toString(t));
//        });




        // TASK : butun ogrenci ve diary bilgilerini getiriyoruz
        String hqlQuery3 = "SELECT s.name,d.name FROM Student04 s FULL JOIN FETCH Diary04 d ON s.id=d.student";
        List<Object[]> resultList3 = session.createQuery(hqlQuery3).getResultList();
        resultList3.forEach(t->{
            System.out.println(Arrays.toString(t));
        });





        tx.commit();
        session.close();
        sf.close();



    }
}
