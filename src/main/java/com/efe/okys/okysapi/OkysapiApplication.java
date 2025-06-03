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
		return "✅ OKYS - Öğrenci Kayıt ve Yönetim Sistemi Backend\n\n"
				+ "Bu API, Java Spring Boot kullanılarak geliştirilmiştir. Öğrenci, ders, eğitmen, kayıt ve not işlemlerini yönetmek amacıyla REST mimarisiyle tasarlanmıştır.\n\n"
				+ "🔗 Temel Endpointler:\n\n"

				+ "👨‍🎓 Öğrenciler (/api/students)\n"
				+ "- GET /api/students                   → Tüm öğrencileri getirir\n"
				+ "- GET /api/students/{id}             → Belirli öğrenciyi getirir\n"
				+ "- POST /api/students                 → Yeni öğrenci ekler\n"
				+ "- PUT /api/students/{id}             → Öğrenciyi günceller\n"
				+ "- DELETE /api/students/{id}          → Öğrenciyi siler\n"
				+ "- GET /api/students/sorted           → İsme göre sıralar\n"
				+ "- GET /api/students/search?name=Efe  → İsme göre arar\n"
				+ "- GET /api/students/filterByName?name=Efe → Stream ile filtreleme\n\n"

				+ "👨‍🏫 Eğitmenler (/api/instructors)\n"
				+ "- GET /api/instructors               → Tüm eğitmenleri getirir\n"
				+ "- POST /api/instructors              → Yeni eğitmen ekler\n"
				+ "- PUT /api/instructors/{id}          → Eğitmeni günceller\n"
				+ "- DELETE /api/instructors/{id}       → Eğitmeni siler\n"
				+ "- GET /api/instructors/sorted        → İsme göre sıralar\n"
				+ "- GET /api/instructors/search?name=Ali → İsme göre arar\n\n"

				+ "📚 Dersler (/api/courses)\n"
				+ "- GET /api/courses                   → Tüm dersleri listeler\n"
				+ "- POST /api/courses                  → Yeni ders ekler\n"
				+ "- PUT /api/courses/{id}              → Dersi günceller\n"
				+ "- DELETE /api/courses/{id}           → Dersi siler\n"
				+ "- GET /api/courses/sorted            → İsme göre sıralar\n"
				+ "- GET /api/courses/search?name=veri  → Ders adına göre arar\n\n"

				+ "📝 Kayıtlar (/api/enrollments)\n"
				+ "- GET /api/enrollments               → Tüm kayıtları getirir\n"
				+ "- POST /api/enrollments              → Yeni kayıt oluşturur\n"
				+ "- DELETE /api/enrollments/{id}       → Kaydı siler\n"
				+ "- GET /api/enrollments/by-student/{id} → Öğrencinin kayıtlarını getirir\n"
				+ "- GET /api/enrollments/by-course/{id}  → Dersin öğrencilerini getirir\n\n"

				+ "🎓 Notlar (/api/grades)\n"
				+ "- GET /api/grades                    → Tüm notları getirir\n"
				+ "- POST /api/grades                   → Yeni not ekler\n"
				+ "- PUT /api/grades/{id}?score=90      → Notu günceller\n"
				+ "- DELETE /api/grades/{id}            → Notu siler\n"
				+ "- GET /api/grades/highscores         → 85 ve üzeri notları getirir\n"
				+ "- GET /api/grades/topscore           → En yüksek notu getirir\n"
				+ "- GET /api/grades/simulateProcessing → Arka planda sahte işlem başlatır\n\n"

				+ "📬 Daha fazla örnek istek ve test senaryosu için README.md dosyasına göz atabilirsiniz.\n";
	}

}