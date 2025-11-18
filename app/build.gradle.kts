plugins {
    application
    id("org.sonarqube") version "7.0.1.6134"
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "SergeyKkk1_java-project-61")
        property("sonar.organization", "sergeykkk1")
    }
}