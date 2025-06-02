package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Enrollment;
import com.efe.okys.okysapi.model.Student;
import com.efe.okys.okysapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Bu interface, öğrenci ve ders kayıtlarına (enrollment) erişmek için kullanılır.
 * Kullanılan Konular:
 * - Katmanlı Mimari (Repository)
 * - Spring Data JPA ile ilişkisel veri erişimi
 * - Derived Query Methods: method ismine göre otomatik sorgu üretimi
 */

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    // Aynı öğrenci ve kurs için kayıt olup olmadığını kontrol eder
    boolean existsByStudentAndCourse(Student student, Course course);

    // Belirli bir öğrenciye ait tüm kayıtları döner
    List<Enrollment> findByStudent(Student student);

    // Belirli bir kursa ait tüm kayıtları döner
    List<Enrollment> findByCourse(Course course);
}
