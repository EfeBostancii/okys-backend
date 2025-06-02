package com.efe.okys.okysapi.model;

import jakarta.persistence.*;

/*
 * Bu sınıf, öğrenci bilgilerini tutmak için oluşturuldu.
 * Kullanılan Konular:
 * - OOP: sınıf yapısı, constructor, getter ve setter’lar
 * - JPA ile veritabanı bağlantısı (@Entity, @Id, @Table, @Column)
 */

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String name;

    // E-mail alanı benzersiz olacak şekilde tanımlandı (unique constraint)
    @Column(unique = true)
    private String email;

    // Öğrencinin kayıt tarihi
    private String registrationDate;

    // Parametresiz constructor – JPA için gerekli
    public Student() {}

    // Parametreli constructor – hızlı nesne oluşturmak için
    public Student(String name, String email, String registrationDate) {
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    // Getter ve setter’lar – OOP prensibi olan encapsulation uygulanıyor
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
