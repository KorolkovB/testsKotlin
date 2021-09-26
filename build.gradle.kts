group = "me.v_21"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.testng:testng:7.4.0")
    implementation("com.codeborne:selenide:5.24.3")
    implementation("org.jetbrains.kotlin:kotlin-test:1.5.21")
    implementation("io.qameta.allure:allure-testng:2.15.0")
    implementation("io.qameta.allure:allure-selenide:2.15.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.0.3")
    implementation("io.github.microutils:kotlin-logging:2.0.11")
}

allure {
    version = "2.14.0"
//    autoconfigure = true
//    aspectjweaver = true
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