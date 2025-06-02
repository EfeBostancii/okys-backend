package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Course;
import com.efe.okys.okysapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Comparator;

/*
 * Bu sınıf, derslerle ilgili işlemleri yapan API katmanıdır.
 * Konular:
 * - REST API (Web programlama)
 * - Java 8 Lambda ve Stream kullanımı
 * - Sıralama algoritması (Comparator)
 */

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // Tüm dersleri getiriyoruz
    // (Basit bir GET işlemi – REST API örneği)
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Yeni bir ders eklemek için POST işlemi
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // Java 8 özelliklerini burada kullanıyoruz:
    // Stream ile tüm dersleri alıp isme göre sıralıyoruz (Comparator)
    @GetMapping("/sorted")
    public List<Course> getCoursesSortedByName() {
        return courseRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Course::getName)) // burada lambda kullanımı da var
                .toList();
    }

    // Var olan bir dersi güncellemek için PUT işlemi
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setName(updatedCourse.getName());
            course.setCredit(updatedCourse.getCredit());
            course.setInstructorId(updatedCourse.getInstructorId());
            return courseRepository.save(course);
        }).orElse(null);
    }

    // ID ile bir dersi siliyoruz – DELETE işlemi
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    // Ders adında geçen kelimeye göre arama yapıyoruz
    // Bu da güzel bir filtreleme örneği (query parametre ile)
    @GetMapping("/search")
    public List<Course> searchCourseByName(@RequestParam String name) {
        return courseRepository.findByNameContainingIgnoreCase(name);
    }
}
