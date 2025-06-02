package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Bu interface, eğitmen (Instructor) verilerine erişmek için kullanılıyor.
 * Kullanılan Konular:
 * - Katmanlı Mimari: Repository yapısı
 * - JPA ile veri erişimi (Spring Data JPA)
 * - Method ismine göre özel sorgu üretimi (Derived Query)
 */

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    // İsim üzerinden küçük/büyük harf duyarsız arama işlemi
    List<Instructor> findByNameContainingIgnoreCase(String name);
}
