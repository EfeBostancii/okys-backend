package com.efe.okys.okysapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/*
 * Bu sınıf, bir öğrencinin bir derse kayıt olmasını temsil ediyor.
 * Kullanılan Konular:
 * - Nesne Yönelimli Programlama (OOP): sınıf yapısı, constructor, getter/setter
 * - JPA ile veritabanı bağlantısı
 * - JPA Many-to-One ilişkileri (öğrenci ve ders ile bağlantılar)
 */

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    // Öğrenci ile bire çok (Many-to-One) ilişki
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Ders ile bire çok (Many-to-One) ilişki
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Kayıt tarihi tutuluyor
    private LocalDate enrollmentDate;

    // Parametresiz constructor – JPA kullanımı için zorunlu
    public Enrollment() {}

    // Parametreli constructor – kolay nesne oluşturma
    public Enrollment(Student student, Course course, LocalDate enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    // Getter ve Setter’lar – OOP prensipleri gereği encapsulation sağlanıyor
    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
