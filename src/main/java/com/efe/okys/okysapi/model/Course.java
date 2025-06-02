package com.efe.okys.okysapi.model;

import jakarta.persistence.*;

/*
 * Bu sınıf, ders (Course) modelini temsil ediyor.
 * Kullanılan Konular:
 * - Nesne Yönelimli Programlama (OOP): sınıf yapısı, constructor, getter/setter
 * - JPA ile veritabanı bağlantısı (@Entity, @Table, @Id vb.)
 */

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String name;

    private int credit;

    private Long instructorId;

    // Parametresiz constructor – JPA için gerekli
    public Course() {}

    // Parametreli constructor – obje oluştururken kullanışlı
    public Course(String name, int credit, Long instructorId) {
        this.name = name;
        this.credit = credit;
        this.instructorId = instructorId;
    }

    // Aşağıdaki getter ve setter’lar sayesinde
    // nesnenin özelliklerini kontrollü şekilde okuyup değiştirebiliyoruz (encapsulation)
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
}
