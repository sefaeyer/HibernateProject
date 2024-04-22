package com.hb14.entity_life_cycle;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_salary")
    private Double salary;






    //NOT: Entity Lifecycle Metodlari


    /*
         Employee sınıfı kaydedilmeden once, onPrePersist() metodu otomatik olarak
       çağrılır ve "onPrePersist method called" çıktısı verilir. Nesne kaydedilmeden
       önce yapılması gereken herhangi bir işlemi gerçekleştirmek için kullanılabilir.
    */
    @PrePersist
    public void onPrePersist(){
        System.out.println("******************** onPrePersist metodu calisti");
    }


    /*
        Employee nesnesi veritabanına kaydedildikten sonra, onPostPersist() metodu çağrılır
    ve "onPostPersist method called" çıktısı verilir. Bu, Nesne kaydedildikten
    sonra yapılması gereken herhangi bir işlemi gerçekleştirmek için kullanılabilir.
     */
    @PostPersist
    public void onPostPersist(){
        System.out.println("******************** onPostPersist ========= calisti");
    }



    /*
        Employee nesnesi veritabanından yüklendiğinde, onPostLoad() metodu çağrılır ve
       "onPostLoad method called" çıktısı verilir. Bu, bir nesne yüklendikten
       sonra yapılması gereken herhangi bir işlemi gerçekleştirmek için kullanılabilir.
    */
    @PostLoad
    public void onPostLoad(){
        System.out.println("******************** onPostLoad --- calisti");
    }



    /*
        @PreRemove anotasyonu, bir nesne silinmeden önce çalıştırılacak bir metodu
        belirtmek için kullanılır. Bu yöntem, bir nesne silinmeden önce yapılması
        gereken işlemleri gerçekleştirmek için kullanılabilir. Örneğin, bir nesnenin
        silinmeden önce bağımlı varlıkları ile olan ilişkileri çözmek veya bir kaydı
        arşivlemek gibi işlemler yapılabilir.
     */
    @PreRemove
    public void onPreRemove(){
        System.out.println("******************** onPreRemove ==================== calisti");
    }


    /*
        @PostRemove yöntemi ise, bir Employee nesnesi silindikten sonra çağrılır ve
        "Employee record removed from the database" çıktısı verilir. Bu örnekte,
        loglama veya istatistik toplama gibi işlemler yapmak gerekiyorsa, @PostRemove
        yöntemi içine kodlar eklenebilir.
     */
    @PostRemove
    public void onPostRemove(){
        System.out.println("***********  onPostRemove   ========= calisti");
    }











    //getter setter
    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
