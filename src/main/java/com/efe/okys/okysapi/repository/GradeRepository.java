package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Bu interface, not (Grade) verisine erişim sağlıyor.
 * Kullanılan Konular:
 * - Katmanlı Mimari: Repository katmanı
 * - Spring Data JPA ile veritabanı işlemleri
 */

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    // Şu an ek bir metod yok, ama JpaRepository sayesinde
    // findAll, save, deleteById gibi işlemler otomatik sağlanıyor.
}
