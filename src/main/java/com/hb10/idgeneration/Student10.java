package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
public class Student10 {

        /*
           GenerationType.Sequence ---> Oracle DB - PostgreSQL kullanir, Sequence ( kontrolü
                    developera bırakır, Id üretilirken başlangıç değeri veya kaç tane id cachelenecek
                    gibi bilgileri developer setliyebilir)

           GenerationType.IDENTITY ---> MySQL - Microsoft SQL  kullanir, IDENTITY ( kontrol DB de ,
                    kendi yapısına göre ıd oluşturur, içlerindeki en basitidir)

           GenerationType.AUTO ---> Hibernate otomatik olarak kullanilan DB ye gore stratejiyi belirler

           GenerationType.TABLE ---> En yavaşı , oyüzden çok kullanılmıyor, çünkü id üretmek için
                    ekstra tablo oluşturuyor
         */


    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",
                       sequenceName = "student_seq", //DB de olusacak sequence ismi
                        initialValue = 1001, // id lerim 1001 ile baslasin
                        allocationSize = 10 //cachele mekanizmasinda 10 adet id hazirda beklesin
    )
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int grade;



    // Getter- Setter **********************
    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }




    //!!! toString() *******************************
    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}