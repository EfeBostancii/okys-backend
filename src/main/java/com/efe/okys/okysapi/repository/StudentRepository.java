package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Bu interface, öğrenci (Student) verilerine erişmek için kullanılıyor.
 * Kullanılan Konular:
 * - Katmanlı Mimari (Repository yapısı)
 * - JPA ile veri erişimi (Spring Data)
 * - MSSQL veritabanı bağlantısı
 * - Derived Query kullanımı: isme göre arama
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Öğrenci ismine göre küçük/büyük harf duyarsız arama yapar
    List<Student> findByNameContainingIgnoreCase(String name);
}
