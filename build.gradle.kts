import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
	kotlin("plugin.jpa") version "1.9.23"
	kotlin("plugin.serialization") version "2.0.0"
}

group = "com.gabsmoliv"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	//implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.1")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.mongodb:mongo-java-driver:3.12.14")
	implementation("org.springdoc:springdoc-openapi-ui:1.8.0")
	implementation("org.springframework.data:spring-data-redis:3.2.5")
	implementation("org.springframework.data:spring-data-mongodb:4.2.5")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
	implementation("org.springframework.kafka:spring-kafka:3.0.12")
	implementation("io.github.openfeign:feign-jackson:12.5")
	implementation("org.springframework.data:spring-data-redis:3.3.2")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation(kotlin("test"))
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito.kotlin:mockito-kotlin:5.3.1")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
	testImplementation("org.testcontainers:testcontainers:1.19.7")
	testImplementation("org.testcontainers:junit-jupiter:1.19.7")
	testImplementation("org.testcontainers:mongodb:1.19.7")
	testImplementation("com.redis:testcontainers-redis:2.2.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
