package com.efe.okys.okysapi.model;

import jakarta.persistence.*;

/*
 * Bu sınıf, bir öğrencinin bir dersteki notunu tutar.
 * Kullanılan Konular:
 * - OOP (Nesne Yönelimli Programlama): sınıf, constructor, getter/setter
 * - JPA Entity tanımı
 * - İlişkisel veritabanı yapısı – Foreign key (enrollment ile ilişki)
 */

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    // Bir not, bir kayıt (Enrollment) ile ilişkilidir (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "enrollment_id", nullable = false)
    private Enrollment enrollment;

    private double score;

    // Parametresiz constructor – JPA için gereklidir
    public Grade() {}

    // Parametreli constructor – hızlı nesne oluşturma için
    public Grade(Enrollment enrollment, double score) {
        this.enrollment = enrollment;
        this.score = score;
    }

    // Getter ve setter’lar – kapsülleme (encapsulation) için gerekli
    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
