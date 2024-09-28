import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.vinaysshenoy.json_parser"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.strikt:strikt-core:0.35.1")
    testImplementation(platform("org.junit:junit-bom:5.11.1"))
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events("skipped", "failed", "passed")
    }
}
kotlin {
    jvmToolchain(21)
}