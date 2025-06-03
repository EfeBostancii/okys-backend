package com.efe.okys.okysapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Bu sınıf, Spring Boot uygulamasının ana giriş noktasıdır.
 * Kullanılan Konular:
 * - Spring Boot başlangıç yapısı (main metodu ile çalıştırma)
 * - @SpringBootApplication ile uygulama yapılandırması
 * - Multithread programlama için @EnableAsync kullanımı
 * - Basit bir root endpoint ile proje durumu mesajı sağlanması
 */

@EnableAsync // Bunun sayesinde @Async kullanılan metodlar ayrı thread'de çalışır
@SpringBootApplication
@RestController // Bu sınıf aynı zamanda REST Controller olarak da görev yapar
public class OkysapiApplication {

	public static void main(String[] args) {
		// Uygulama buradan başlatılır
		SpringApplication.run(OkysapiApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return """
        OKYS - Öğrenci Kayıt ve Yönetim Sistemi Backend

        Bu API; öğrenci, ders, eğitmen, kayıt ve not işlemlerini yönetmek için Java Spring Boot ile geliştirilmiştir.
        REST mimarisi kullanılarak oluşturulmuş ve PostgreSQL ile desteklenmektedir.

        Temel Endpointler:

        Öğrenciler (/api/students)
        - GET /api/students                   → Tüm öğrencileri getir
        - GET /api/students/{id}             → Belirli bir öğrenciyi getir
        - POST /api/students                 → Yeni öğrenci ekle
        - PUT /api/students/{id}             → Öğrenci bilgisi güncelle
        - DELETE /api/students/{id}          → Öğrenciyi sil
        - GET /api/students/sorted           → İsme göre sıralı liste
        - GET /api/students/search?name=Efe  → İsme göre ara
        - GET /api/students/filterByName?name=Efe → Stream ile filtrele

        Eğitmenler (/api/instructors)
        - GET /api/instructors               → Tüm eğitmenleri getir
        - POST /api/instructors              → Yeni eğitmen ekle
        - PUT /api/instructors/{id}          → Eğitmen güncelle
        - DELETE /api/instructors/{id}       → Eğitmen sil
        - GET /api/instructors/sorted        → İsme göre sıralı liste
        - GET /api/instructors/search?name=Ali → İsme göre ara

        Dersler (/api/courses)
        - GET /api/courses                   → Tüm dersleri getir
        - POST /api/courses                  → Yeni ders ekle
        - PUT /api/courses/{id}              → Ders bilgisi güncelle
        - DELETE /api/courses/{id}           → Dersi sil
        - GET /api/courses/sorted            → İsme göre sıralı liste
        - GET /api/courses/search?name=veri  → İsme göre ara

        Kayıtlar (/api/enrollments)
        - GET /api/enrollments               → Tüm kayıtları getir
        - POST /api/enrollments              → Yeni kayıt oluştur
        - DELETE /api/enrollments/{id}       → Kaydı sil
        - GET /api/enrollments/by-student/{id} → Öğrencinin kayıtları
        - GET /api/enrollments/by-course/{id}  → Dersin öğrencileri

        Notlar (/api/grades)
        - GET /api/grades                    → Tüm notları getir
        - POST /api/grades                   → Yeni not ekle
        - PUT /api/grades/{id}?score=90      → Not güncelle
        - DELETE /api/grades/{id}            → Notu sil
        - GET /api/grades/highscores         → 85+ notlar
        - GET /api/grades/topscore           → En yüksek not
        - GET /api/grades/simulateProcessing → Async işlem simülasyonu

        Tüm endpoint'lerin açıklamaları ve Postman ile test edilebilecek örnek istekler için README.md dosyasını inceleyebilirsiniz.
        """;
	}
}