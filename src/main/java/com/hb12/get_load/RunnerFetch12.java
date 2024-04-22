package com.hb12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {


        /*
           get() ---> gerçek nesneyi döndürür ,
                    nesne yoksa null döner
                    nesnenin olduğundan emin değilseniz get() kullanın
                    dönen nesneyi hemen kullanacaksam get() kullanılmalı
           load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
                    nesne yoksa exception fırlatır
                    dönen nesne üzerinde delete yapılacaksa kullanılabilir
         */


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        System.out.println("************************** start to execute get method");
//        Student12 student1 = session.get(Student12.class,1L);
//        System.out.println("************************** finish to execute get method");
//        System.out.println("student ID : "+student1.getId());
//        System.out.println("student Name : "+student1.getName());
//
//
//        System.out.println("----------------------* START to LOAD method");
//        Student12 student2 = session.load(Student12.class,2L);
//        System.out.println("----------------------* FINISH to LOAD method");
//        System.out.println("-CALL getId()   =======");
//        System.out.println("student ID : "+student2.getId());
//        System.out.println("  =  =  CALL GET NAME  =  =  ");
//        System.out.println("student Name : "+student2.getName());


        //DB de olmayan id ler ile get load methodlarinin davranisini gorme
        System.out.println("--==  START to GET METHOD  ==--");
        Student12 setudent3 = session.get(Student12.class,5L);
        System.out.println("--==  FINISH to GET METHOD  ==--");

        if(setudent3!=null) {
            System.out.println("Student3 ID : " + setudent3.getId());
        }

        System.out.println("-------------------------------------------------------------");

        //LOAD
        System.out.println("--==--Start to LOAD--==--");
        Student12 student4 = session.load(Student12.class,10L);
        System.out.println("--==--finish to LOAD--==--");

        if(student4!=null) {
            System.out.println("Student3 ID : " + student4.getId());
            System.out.println("Student4 name : "+ student4.getName());
        }


        tx.commit();
        session.close();
        sf.close();



    }
}
