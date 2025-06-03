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
		return "OKYS Backend API (Spring Boot)\n\n"
				+ "Örnek endpointler:\n"
				+ "/api/students → Öğrenciler\n"
				+ "/api/instructors → Eğitmenler\n"
				+ "/api/courses → Dersler\n"
				+ "/api/enrollments → Kayıtlar\n"
				+ "/api/grades → Notlar\n\n"
				+ "Detaylı kullanım ve örnek test istekleri için README.md dosyasını inceleyebilirsiniz.";
	}
}