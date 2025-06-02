package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Instructor;
import com.efe.okys.okysapi.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Sort;
import java.util.List;

/*
 * Bu controller sınıfı, eğitmenlerle ilgili API işlemlerini barındırıyor.
 * Kullanılan Konular:
 * - Web Programlama (REST API)
 * - Katmanlı Mimari (Controller ↔ Repository)
 * - Sıralama algoritması (Spring Sort ile)
 */

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    // Tüm eğitmenleri getiriyoruz – basit GET isteği
    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    // Yeni bir eğitmen kaydı ekliyoruz
    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Eğitmeni silme işlemi – klasik DELETE endpoint
    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorRepository.deleteById(id);
    }

    // Eğitmeni güncellemek için PUT işlemi
    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody Instructor updatedInstructor) {
        return instructorRepository.findById(id).map(instructor -> {
            instructor.setName(updatedInstructor.getName());
            instructor.setDepartment(updatedInstructor.getDepartment());
            return instructorRepository.save(instructor);
        }).orElse(null);
    }

    // Burada sıralama algoritması kullanıyoruz – eğitmenleri isme göre sıralıyoruz
    @GetMapping("/sorted")
    public List<Instructor> getSortedInstructors() {
        return instructorRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    // Eğitmenleri isme göre arıyoruz – küçük/büyük harf duyarsız arama
    @GetMapping("/search")
    public List<Instructor> searchInstructorByName(@RequestParam String name) {
        return instructorRepository.findByNameContainingIgnoreCase(name);
    }

}
