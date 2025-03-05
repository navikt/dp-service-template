import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    id("org.jlleitschuh.gradle.ktlint") version "12.2.0"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin"))
    implementation("org.jlleitschuh.gradle:ktlint-gradle:12.1.0")
}

tasks.withType<KotlinCompile>().configureEach {
    dependsOn("ktlintFormat")
}

tasks.named("check") {
    dependsOn("ktlintCheck")
}
