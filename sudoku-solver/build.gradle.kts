plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "org.ash.french"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
}

tasks.test {
    useJUnitPlatform()
}
