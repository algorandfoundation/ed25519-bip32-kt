/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.5/userguide/building_java_projects.html in the Gradle documentation.
 */

version = "0.1.0"
group = "com.algorandfoundation.bip32ed25519"

plugins {
    kotlin("plugin.serialization") version "1.9.22"
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

}


dependencies {
    implementation(project(":sharedModule"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

// Apply a specific Java toolchain to ease working on different environments.
java { toolchain { languageVersion.set(JavaLanguageVersion.of(17)) } }

// Run ./gradlew test to execute tests not requiring an Algorand Sandbox network
tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform{
        excludeTags("sandbox")
    }
    testLogging.showStandardStreams = true
}

// Run ./gradlew testWithAlgorandSandbox to run tests that interact with an Algorand Sandbox network (e.g. Algokit Localnet)
tasks.register<Test>("testWithAlgorandSandbox") {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}