# OKYS - Öğrenci Kayıt ve Yönetim Sistemi Backend

---

Bu proje Java Spring Boot kullanılarak geliştirilmiş bir öğrenci yönetim sistemidir. REST API mimarisiyle öğrenci, ders, eğitmen, kayıt ve not işlemlerini yönetmek amacıyla tasarlanmıştır.

---

## Proje Yapısı

- **Model Katmanı**: `Student`, `Course`, `Instructor`, `Enrollment`, `Grade` sınıfları veritabanı modelleridir.
- **Repository Katmanı**: JPA ile temel veritabanı işlemleri (`findAll`, `save`, `deleteById`...) otomatik sağlanır.
- **Controller Katmanı**: REST API endpointleri tanımlıdır. Her model için ayrı controller vardır.
- **Veritabanı**: **Railway** platformunda **PostgreSQL** kullanılmaktadır.

## Deploy Linki: https://okys-backend-production.up.railway.app/

---

## Öğrenci Endpointleri `/api/students`

### GET /api/students  
Tüm öğrencileri listeler.
```
GET https://okys-backend-production.up.railway.app/api/students
```

### GET /api/students/1  
Belirli bir öğrenciyi ID ile getirir.
```
GET https://okys-backend-production.up.railway.app/api/students/1
```

### POST /api/students  
Yeni öğrenci ekler.
```
POST https://okys-backend-production.up.railway.app/api/students
```
```
{
  "name": "Efe Bostancı",
  "email": "efe@okul.com",
  "registrationDate": "2025-06-01"
}
```

### PUT /api/students/1  
Öğrenci bilgilerini günceller.
```
PUT https://okys-backend-production.up.railway.app/api/students/1
```
```
{
  "name": "Güncel İsim",
  "email": "guncel@okul.com",
  "registrationDate": "2025-06-05"
}
```

### DELETE /api/students/1  
Öğrenciyi siler.
```
DELETE https://okys-backend-production.up.railway.app/api/students/1
```

### GET /api/students/sorted  
İsimlerine göre sıralanmış öğrenci listesini getirir.
```
GET https://okys-backend-production.up.railway.app/api/students/sorted
```

### GET /api/students/search?name=Efe  
İsme göre arama yapar.
```
GET https://okys-backend-production.up.railway.app/api/students/search?name=Efe
```

### GET /api/students/filterByName?name=Efe  
Java Stream kullanarak filtreleme yapar.
```
GET https://okys-backend-production.up.railway.app/api/students/filterByName?name=Efe
```

---

## Eğitmen Endpointleri `/api/instructors`

### GET /api/instructors  
Tüm eğitmenleri listeler.
```
GET https://okys-backend-production.up.railway.app/api/instructors
```

### POST /api/instructors  
Yeni eğitmen ekler.
```
POST https://okys-backend-production.up.railway.app/api/instructors
```
```
{
  "name": "Ali Demir",
  "department": "Bilgisayar Programcılığı"
}
```

### PUT /api/instructors/1  
Eğitmen günceller.
```
PUT https://okys-backend-production.up.railway.app/api/instructors/1
```
```
{
  "name": "Ali Güncel",
  "department": "Yazılım Mühendisliği"
}
```

### DELETE /api/instructors/1  
Eğitmen siler.
```
DELETE https://okys-backend-production.up.railway.app/api/instructors/1
```

### GET /api/instructors/sorted  
İsme göre eğitmenleri sıralar.
```
GET https://okys-backend-production.up.railway.app/api/instructors/sorted
```

### GET /api/instructors/search?name=Ali  
İsme göre eğitmen arar.
```
GET https://okys-backend-production.up.railway.app/api/instructors/search?name=Ali
```

---

## Ders Endpointleri `/api/courses`

### GET /api/courses  
Tüm dersleri listeler.
```
GET https://okys-backend-production.up.railway.app/api/courses
```

### POST /api/courses  
Yeni ders ekler.
```
POST https://okys-backend-production.up.railway.app/api/courses
```
```
{
  "name": "Nesneye Dayalı Programlama",
  "credit": 5,
  "instructorId": 1
}
```

### PUT /api/courses/1  
Ders günceller.
```
PUT https://okys-backend-production.up.railway.app/api/courses/1
```
```
{
  "name": "Güncel Ders",
  "credit": 6,
  "instructorId": 2
}
```

### DELETE /api/courses/1  
Ders siler.
```
DELETE https://okys-backend-production.up.railway.app/api/courses/1
```

### GET /api/courses/sorted  
İsme göre sıralanmış dersleri getirir.
```
GET https://okys-backend-production.up.railway.app/api/courses/sorted
```

### GET /api/courses/search?name=veri  
Ders adına göre arama yapar.
```
GET https://okys-backend-production.up.railway.app/api/courses/search?name=veri
```

---

## Kayıt (Enrollment) Endpointleri `/api/enrollments`

### GET /api/enrollments  
Tüm kayıtları listeler.
```
GET https://okys-backend-production.up.railway.app/api/enrollments
```

### POST /api/enrollments  
Yeni kayıt oluşturur.
```
POST https://okys-backend-production.up.railway.app/api/enrollments
```
```
{
  "studentId": 1,
  "courseId": 2
}
```

### DELETE /api/enrollments/1  
Kayıt siler.
```
DELETE https://okys-backend-production.up.railway.app/api/enrollments/1
```

### GET /api/enrollments/by-student/1  
Bir öğrencinin kayıtlarını getirir.
```
GET https://okys-backend-production.up.railway.app/api/enrollments/by-student/1
```

### GET /api/enrollments/by-course/1  
Bir kursun kayıtlı öğrencilerini getirir.
```
GET https://okys-backend-production.up.railway.app/api/enrollments/by-course/1
```

---

## Not (Grade) Endpointleri `/api/grades`

### GET /api/grades  
Tüm notları getirir.
```
GET https://okys-backend-production.up.railway.app/api/grades
```

### POST /api/grades  
Yeni not ekler.
```
POST https://okys-backend-production.up.railway.app/api/grades
```
```
{
  "enrollmentId": 1,
  "score": 87.5
}
```

### PUT /api/grades/1?score=90  
Not günceller.
```
PUT https://okys-backend-production.up.railway.app/api/grades/1?score=90
```

### DELETE /api/grades/1  
Notu siler.
```
DELETE https://okys-backend-production.up.railway.app/api/grades/1
```

### GET /api/grades/highscores  
85 ve üzeri notları getirir.
```
GET https://okys-backend-production.up.railway.app/api/grades/highscores
```

### GET /api/grades/topscore  
En yüksek notu getirir.
```
GET https://okys-backend-production.up.railway.app/api/grades/topscore
```

### GET /api/grades/simulateProcessing  
Arka planda sahte işlem simülasyonu başlatır.
```
GET https://okys-backend-production.up.railway.app/api/grades/simulateProcessing
```

---
