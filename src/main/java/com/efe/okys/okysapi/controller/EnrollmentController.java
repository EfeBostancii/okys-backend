package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Course;
import com.efe.okys.okysapi.model.Enrollment;
import com.efe.okys.okysapi.model.Student;
import com.efe.okys.okysapi.repository.CourseRepository;
import com.efe.okys.okysapi.repository.EnrollmentRepository;
import com.efe.okys.okysapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
 * Bu controller sınıfı, öğrenci-kurs kayıtlarını yönetiyor.
 * Kullanılan Konular:
 * - REST API (Web Programlama)
 * - Katmanlı Mimari (Controller-Repository)
 * - JPA ile ilişkisel veri çekme (JOIN)
 * - Exception handling (runtime exception örneği)
 */

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Tüm kayıtları getiriyoruz – klasik bir GET endpoint
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Yeni bir kayıt oluşturuyoruz
    // Burada JPA ile ilişkili veriler çekiliyor: öğrenci ve kursu id ile alıp eşliyoruz
    // Ayrıca kayıt kontrolü yapıyoruz: öğrenci daha önce kayıtlıysa hata fırlatılıyor
    @PostMapping
    public Enrollment createEnrollment(@RequestParam Long studentId,
                                       @RequestParam Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        boolean exists = enrollmentRepository.existsByStudentAndCourse(student, course);
        if (exists) {
            throw new RuntimeException("Bu öğrenci bu kursa zaten kayıtlı.");
        }

        Enrollment enrollment = new Enrollment(student, course, LocalDate.now());
        return enrollmentRepository.save(enrollment);
    }

    // Kayıt silme işlemi – DELETE endpoint örneği
    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentRepository.deleteById(id);
    }

    // Öğrenciye göre kayıtları filtreliyoruz
    // Bu tarz endpoint’ler ilişkilendirilmiş veri çekme (JOIN) örneğidir
    @GetMapping("/by-student/{studentId}")
    public List<Enrollment> getByStudent(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        return enrollmentRepository.findByStudent(student);
    }

    // Kursa göre kayıtları çekiyoruz – yine ilişkisel veri erişimi
    @GetMapping("/by-course/{courseId}")
    public List<Enrollment> getByCourse(@PathVariable Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        return enrollmentRepository.findByCourse(course);
    }
}
