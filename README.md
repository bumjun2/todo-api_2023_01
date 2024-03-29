```groovy

plugins {
id 'java'
id 'org.springframework.boot' version '2.7.12'
id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = 'com.study'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

configurations {
compileOnly {
extendsFrom annotationProcessor
}
}

repositories {
mavenCentral()
}

dependencies {
// jdbc 대신 쓰는거 이자식이 상위 라이브러리
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
// mvc 패턴을 가능하게 하는 라이브러리
implementation 'org.springframework.boot:spring-boot-starter-web'
testImplementation 'junit:junit:4.13.1'
// @ 쓰는거
compileOnly 'org.projectlombok:lombok'
// 마리아 디비랑 연결해주는 커넥터
runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
annotationProcessor 'org.projectlombok:lombok'
//junit 라이브러리
testImplementation 'org.springframework.boot:spring-boot-starter-test'

    // 쿼리파라미터 추가 외부로그 남기기
    implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.8'

}

tasks.named('test') {
useJUnitPlatform()
}
