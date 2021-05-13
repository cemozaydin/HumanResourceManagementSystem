![hrms_main_logo_1](https://user-images.githubusercontent.com/32098845/118172009-8eae0380-b434-11eb-8f4d-101365e89242.png)

# :dolls: <font color="white"> Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)  - HRMS Backend Projesi </font>

<br>

## :books: <font color="cyan"> Senaryo </font>

**Sistemimiz üç temel kullanıcı türüne sahiptir. Sistem personeli, İş Arayanlar ve İş verenler.** 

- **Sistem personeli :** Projenizde çalışan kişiler, HRMS sistemini yöneten kullanıcılar. 

### **İSTEK 1 :** İş Arayanlar sisteme kayıt olabilmelidir.

### Kabul Kriterleri:

- Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
- Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
- Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
- Doğrulama geçerli değilse kullanıcı bilgilendirilir.
- Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
- Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.

### **İSTEK 2 :** İş verenler sisteme kayıt olabilmelidir.

### Kabul Kriterleri:

- Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
- Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
- Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS personelinin onayı gerekmektedir.
- Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.

### **İSTEK 3 :** Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software Architect vs.

### Kabul Kriterleri:

- Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.

## Kullanılacak Teknolojiler

### **FRAMEWORK**
**- Spring Boot**

<br>

### **Dependencies**
**- Spring Boot DevTools**

**- Lombok**

**- Spring Web**

**- Spring Data JPA**

**- PostgreSQL Driver**

### **IDE**
**- IntelliJ IDEA Ultimate**
