package com.efe.okys.okysapi.model;

import jakarta.persistence.*;

/*
 * Bu sınıf, eğitmen (Instructor) bilgisini tutmak için oluşturuldu.
 * Kullanılan Konular:
 * - Nesne Yönelimli Programlama (OOP): constructor, getter, setter
 * - Veritabanı bağlantısı – JPA Entity tanımı (@Entity, @Id)
 */

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    private String name;
    private String department;

    // JPA için zorunlu olan parametresiz constructor
    public Instructor() {}

    // Kolay nesne oluşturmak için parametreli constructor
    public Instructor(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getter ve setter metodları – OOP'nin kapsülleme (encapsulation) prensibiyle
    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
