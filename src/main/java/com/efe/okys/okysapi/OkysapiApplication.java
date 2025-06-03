package com.efe.okys.okysapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/*
 * Bu sınıf, Spring Boot uygulamasının ana giriş noktasıdır.
 * Kullanılan Konular:
 * - Spring Boot başlangıç yapısı (main metodu ile çalıştırma)
 * - @SpringBootApplication ile uygulama yapılandırması
 * - Multithread programlama için @EnableAsync kullanımı
 */

@EnableAsync // Bunun sayesinde @Async kullanılan metodlar ayrı thread'de çalışır
@SpringBootApplication
public class OkysapiApplication {

	public static void main(String[] args) {
		// Uygulama buradan başlatılır
		SpringApplication.run(OkysapiApplication.class, args);
	}
}