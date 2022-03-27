plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
    java
}

group = "tokyo.baseballyama"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    val kotlinVersion = "1.6.10"
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    implementation("com.google.code.gson:gson:2.9.0")
}