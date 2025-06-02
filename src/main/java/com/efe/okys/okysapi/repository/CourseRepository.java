package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Bu interface, Course verilerine erişmek için kullanılıyor.
 * Kullanılan Konular:
 * - Katmanlı mimari: Repository katmanı
 * - JPA ile veri erişimi (Spring Data JPA)
 * - Method isimlendirme ile özel sorgu yazımı (findByNameContainingIgnoreCase)
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Kurs ismine göre küçük/büyük harf duyarsız arama yapar
    List<Course> findByNameContainingIgnoreCase(String name);
}
