package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

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

        // 1 NOT: Get() *******************************************************
//        Student01 student1 = session.get(Student01.class, 1001);
//        System.out.println("student1 = " + student1);
//
//        Student01 student2 = session.get(Student01.class, 1002);
//        System.out.println("student2 = " + student2);


        // 2 NOT: SQL ********************************************************
//        String sqlQuery = "SELECT * FROM t_student01"; //SQL ce konusma
//        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] objects: resultList1){
//            System.out.println("List = " + Arrays.toString(objects));
//        }


        // 3 NOT: HQL ********************************************************
//        String hqlQuery1 = "FROM Student01"; // Java ca konusuruz
//        List<Student01> resultList2 = session.createQuery(hqlQuery1, Student01.class).getResultList();
//        for (Student01 student01: resultList2){
//            System.out.println(student01);
//        }


        // Not:     EXERCISE    **********************************************
//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name='Fatma Hanim'";
//        Object[] uniqueResult = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(uniqueResult));
//        System.out.println(uniqueResult[0]+" : "+uniqueResult[1]+" : "+uniqueResult[2]);

        // !!! Bu sorguyu HQL ile yapalim
//        String hqlQuery2="FROM Student01 WHERE name='Fatma Hanim'";
//        Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(uniqueResult2);
//        System.out.println(uniqueResult2.getId()+" : "+ uniqueResult2.getGrade());


        // HQL -> grade degeri 70 olan ogrencileri getir
//        String hqlQuery3="SELECT s.id ,s.name FROM Student01 s WHERE grade=70";
//        List<Object[]> resultList3= session.createQuery(hqlQuery3).getResultList();
//        for (Object[] objects: resultList3){
//            System.out.println(Arrays.toString(objects));
//        }


        // id ye gore azalan sirli listeyi gorelim
        String hqlQuery4="FROM Student01 s ORDER BY s.id DESC";
        List<Student01> resultList4= session.createQuery(hqlQuery4, Student01.class).getResultList();
       // System.out.println(resultList4);
        for(Student01 student01 : resultList4){
            System.out.println(student01);
        }




        tx.commit();
        session.close();
        sf.close();


        // !!! get - SQL - HQL  hangisini tercih etmeli
        /*
                1. get
                2. HQL
                3. SQL

                    *   Native SQL hizli olsada eksi yonleri :
                1) bazi DB'lerde sql syntax'in farkliliklar olabiliyor, Native SQL burada sorun olabilir
                2) String yapilarin hataya acik olmasi
         */


    }
}
