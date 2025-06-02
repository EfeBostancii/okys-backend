package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Student;
import com.efe.okys.okysapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Bu sınıf, öğrencilerle ilgili tüm API işlemlerini kapsıyor.
 * Kullanılan Konular:
 * - Web Programlama (REST API)
 * - J2EE Katmanlı Yapı (Controller ↔ Repository)
 * - Veri akışı (JSON dönüşleri)
 * - Java 8 Stream & Lambda
 * - Sıralama ve filtreleme algoritmaları
 */

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Tüm öğrencileri listeliyoruz – temel bir GET endpoint
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Yeni öğrenci ekleme işlemi – POST endpoint
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Öğrenciyi ID'ye göre getiriyoruz – veri erişimi örneği
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // ID ile öğrenci silme işlemi
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    // Öğrenci bilgilerini güncellemek için PUT endpoint
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setRegistrationDate(updatedStudent.getRegistrationDate());
            return studentRepository.save(student);
        }).orElse(null);
    }

    // Burada Spring'in sıralama desteğini kullanıyoruz – isme göre artan sıralama
    @GetMapping("/sorted")
    public List<Student> getStudentsSortedByName() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    // Basit bir arama işlemi – isme göre küçük/büyük harf duyarsız filtreleme
    @GetMapping("/search")
    public List<Student> searchStudentsByName(@RequestParam String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    // Java 8 Stream API kullanımı örneği
    // Stream ile filtreleme yapıyoruz – lambda ile öğrencinin adını kontrol ediyoruz
    @GetMapping("/filterByName")
    public List<Student> filterByName(@RequestParam String name) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
