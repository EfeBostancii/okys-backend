package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Enrollment;
import com.efe.okys.okysapi.model.Grade;
import com.efe.okys.okysapi.repository.EnrollmentRepository;
import com.efe.okys.okysapi.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/*
 * Bu controller, not işlemleriyle ilgili API uçlarını içeriyor.
 * Kullanılan Konular:
 * - Web Programlama (REST API)
 * - Katmanlı Mimari (Controller + Repository)
 * - JPA ile ilişkisel veri modeli (Grade → Enrollment ilişkisi)
 * - Java 8: Stream ve Lambda kullanımı
 * - Multithread Programlama (@Async ile)
 */

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // Tüm notları getiriyoruz – basit bir GET işlemi
    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    // Yeni bir not ekliyoruz
    // Notlar, ilgili kayıt (Enrollment) üzerinden oluşturuluyor – JPA ilişkisi burada devrede
    @PostMapping
    public Grade createGrade(@RequestParam Long enrollmentId,
                             @RequestParam double score) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow();
        Grade grade = new Grade(enrollment, score);
        return gradeRepository.save(grade);
    }

    // Notu güncelliyoruz – PUT işlemi
    @PutMapping("/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestParam double score) {
        return gradeRepository.findById(id).map(g -> {
            g.setScore(score);
            return gradeRepository.save(g);
        }).orElse(null);
    }

    // Notu silmek için DELETE endpoint
    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeRepository.deleteById(id);
    }

    // Java 8 Stream ve Lambda konusunu burada kullandık:
    // Tüm notlar içinden 85 ve üzeri olanları filtreliyoruz
    @GetMapping("/highscores")
    public List<Grade> getHighScores() {
        return gradeRepository.findAll()
                .stream()
                .filter(grade -> grade.getScore() >= 85)
                .toList();
    }

    // Burada da yine Java 8 stream ile max notu buluyoruz
    @GetMapping("/topscore")
    public Grade getTopScore() {
        return gradeRepository.findAll()
                .stream()
                .max((g1, g2) -> Double.compare(g1.getScore(), g2.getScore()))
                .orElse(null);
    }

    // Bu endpoint multithread konusu için yazıldı
    // @Async sayesinde bu metot ayrı bir thread'de çalışıyor
    @Async
    @GetMapping("/simulateProcessing")
    public void simulateGradeProcessing() {
        System.out.println("Thread adı: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000); // işlem süresi simülasyonu
            System.out.println("Notlar işlendi!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
