package com.hb06.uni_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {

    @Id
    private int id;

    @Column(name= "student_name", nullable = false)
    private String name;

    private int grade;

    @OneToMany
    @JoinColumn
    private List<Book06> bookList=new ArrayList<>();
    // !!! yukardaki @JoinColumn eklenmezse ---> @JoinTable yapar otomatik olarak
    // @JoinTable-->  ayrı bir tablo oluşturuyor ve
    // tabloda 2 kolon oluyor sadece biri student_id diğeri book_id fakat
    // oneToMany için @JoinClumn daha kullanışlı çünki ekstra tablo
    // oluşturmak fetch leme işlemlerinde extra sql query lerin oluşmasına sebeb oluyor
    // !!! Trick Önemli :normalde yeni oluşacak kolon Student06 tablosunda olması lazım ama bu yapıda
    // Book06 tablosunda oluşturuluyor, oneToMany veya ManyToOne gibi yapılarda Hibernate,
    // ilişkiyi daha rahat takip edebilmek için , yeni oluşacak kolonu Many tarafında oluşturur.
    // !!! iliski sahibi, her halukarda Student tarafi oldugu icin, buradan setlenmesi gerekiyor




    //GETTER - SETTER ----------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book06> bookList) {
        this.bookList = bookList;
    }



    //toString
    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
