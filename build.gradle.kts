plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"

//    // Get the current version from https://github.com/JLLeitschuh/ktlint-gradle
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" apply false

    id("org.sonarqube") version "5.1.0.4882"

    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

group = "org.ash.french"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // https://mvnrepository.com/artifact/org.jlleitschuh.gradle/ktlint-gradle
    implementation(libs.ktlint.gradle)

    // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
    runtimeOnly(libs.kotlinx.coroutines.core)

    implementation(libs.kotlinx.serialization.json)
}


kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// Ensure all Kotlin compilation tasks target JVM 21 across the project
subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "21"
        }
    }
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