### 🟡 Start project
- VSC Open Command Palate ( up + command + P)
- keyword "> spring", select Spring Initializr: Create a Maven Project
- Specify Spring Boot version : 2.6.6
- Specify project language : Java
- package name : com.domain
- Artifact ID : demo-api
- Specify package type : JAR
- Versi java version : 11
- Choose dependencies : <br />
    -- Spring Web <br />
    -- Spring Boot DevTools <br />
    -- #Lombok ( fungsinya : biar codingan tidak panjang )

&nbsp;

#### Test running

Run Command:
<pre>
❯ mvn spring-boot:run
</pre>

Open Browser: <br />
URL http://localhost:8080/api/welcome


&nbsp;

&nbsp;

&nbsp;

<pre>
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project test-welcome: Fatal error compiling: invalid target release: 11
</pre>

Error tersebut terjadi karena versi Java yang digunakan di Jitpack tidak sesuai dengan konfigurasi `target release` dalam proyek Anda. Error "invalid target release: 11" menunjukkan bahwa proyek Anda memerlukan Java 11, namun Jitpack kemungkinan menggunakan versi Java yang lebih lama (misalnya Java 8).

### Solusi
Ada beberapa cara untuk memastikan Jitpack menggunakan versi Java yang sesuai:

#### 1. Tentukan Versi Java di `pom.xml`
Pastikan Anda sudah mengonfigurasi versi Java di `pom.xml` dengan benar. Tambahkan atau perbarui bagian berikut untuk mengatur `maven.compiler.source` dan `maven.compiler.target` ke versi Java 11:

```xml
<properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>
```

#### 2. Gunakan File `jitpack.yml`
Jika penambahan di `pom.xml` tidak berhasil, Anda bisa membuat file `jitpack.yml` di root proyek untuk mengatur versi Java secara eksplisit. Isi file `jitpack.yml` sebagai berikut untuk mengatur Java 11:

```yaml
jdk:
  - openjdk11
```

#### 3. Perbarui Konfigurasi Maven Compiler Plugin (Jika Diperlukan)
Pastikan plugin Maven Compiler Plugin juga disetel untuk Java 11. Tambahkan atau perbarui bagian plugin seperti ini di `pom.xml`:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>11</source>
                <target>11</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Setelah mengonfigurasi ulang, coba build ulang proyek Anda di Jitpack.