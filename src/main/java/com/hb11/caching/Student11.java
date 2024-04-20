package com.hb11.caching;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

        /*
        1)  First Level Cache --->
                  * defaultta açık geliyor , kapatma durumu yok
                  * Aynı session içinde kayıt alır
                  * Her session, kendi first level cache'ini yönetir.
                  Yani, bir session içinde yapılan sorguların sonuçları o
                  session'a özgü bir önbellekte tutulur.
                  * aynı session içinde tekrarlanan sorguların performansını artırır
                  ve gereksiz veritabanı erişimlerini engeller.
                  * session kapanınca içindekiler silinir

        2) Second Level Cache --->
                  * Defaultta kapalıdır
                  * Session factory seviyesinde cachleme yapar, yani farklı
                        sessionlar arasında data kullanılabiliyor
                  * hibernate.cfg.xml den active edilebilir

        3) Query Cache
                  * Query ler için kullanılıyor
                  * hibernate.cfg.xml den active edilebilir
                  * sessionlar arasi sorgulari cachliyebilir

            query cache sorguların sonuçlarını önbellekte saklarken, second level cache entity'leri
            ve ilişkili verileri önbelleğe alır. İki cache türü de performans artışı sağlar ancak
            farklı düzeyde ve farklı kullanım senaryoları için tasarlanmıştır.

         */

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Student11")
//!!! region --> cache islemi icin kullanilacak alanin ismi setleniyor
//!!! WRITE--> veri tabaninda bir veriyi guncellediginiz by veri cache alinir ve
// ayi veri okunmak isterse DB ye gitmeden cache den okunur
public class Student11 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int mathGrade;



    //!!! Getter-Setter ***************************8
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

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }



    //!!! toString() ***************************
    @Override
    public String toString() {
        return "Student11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}