plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")

    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "org.ash.french"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation(project(":share-sudoku-solver"))
    implementation(libs.kotlinx.serialization.json)
    testImplementation(kotlin("test"))

    implementation(compose.desktop.currentOs)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
