group = "me.v_21"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.4.0")
    implementation("com.codeborne:selenide:5.24.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.21")
    testImplementation("io.qameta.allure:allure-testng:2.15.0")
    testImplementation("io.qameta.allure:allure-selenide:2.15.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.0.3")
    testImplementation("io.rest-assured:rest-assured:4.4.0")
    testImplementation("io.rest-assured:json-path:4.4.0")
    testImplementation("io.rest-assured:kotlin-extensions:4.4.0")
}

allure {
    version = "2.14.0"
}

plugins {
    kotlin("jvm") version "1.5.21"
    id("io.qameta.allure") version "2.8.1"
}

tasks.test {
    useTestNG {
        suites("src/test/resources/suites/${System.getProperty("suite")}.xml")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}