plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"

    // Get the current version from https://github.com/JLLeitschuh/ktlint-gradle
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" apply false

    id("org.sonarqube") version "5.1.0.4882"
}

group = "org.ash.french"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // https://mvnrepository.com/artifact/org.jlleitschuh.gradle/ktlint-gradle
    implementation("org.jlleitschuh.gradle:ktlint-gradle:12.1.1")

    // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
}


kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "ashfrench_killer-sudoko")
        property("sonar.organization", "ashfrench")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "org.sonarqube")

    // Optionally configure plugin
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
    }
}