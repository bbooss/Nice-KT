/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn how to create Gradle builds at https://guides.gradle.org/creating-new-gradle-builds/
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    kotlin("jvm").version("1.4.21").apply(false)
}

allprojects {
    group = "com.nice.kt"
    version = "1.0.0-dev"

    System.getProperty("version")?.apply {
        version = this
    }

    repositories {
        mavenLocal()
        maven(url="https://maven.aliyun.com/repository/public/")
        mavenCentral()
        jcenter()
    }

}

tasks.register<Delete>("removeLocalSzJarsCache") {
    val localMaven = this.project.repositories.mavenLocal()
    val path = localMaven.url.path + listOf("com", "nice", "kt").joinToString(separator = File.separator)
    this.delete(path)
    println("remove Local Maven Cache For KT Framework: $path")
    val gradleJsrCachePath = listOf(this.project.gradle.gradleUserHomeDir.path, "caches", "modules-2", "files-2.1", "com.nice.kt").joinToString(separator = File.separator)
    val gradleMetaCachePath1 = listOf(this.project.gradle.gradleUserHomeDir.path, "caches", "modules-2", "metadata-2.23", "descriptors", "com.nice.kt").joinToString(separator = File.separator)
    val gradleMetaCachePath2 = listOf(this.project.gradle.gradleUserHomeDir.path, "caches", "modules-2", "metadata-2.71", "descriptors", "com.nice.kt").joinToString(separator = File.separator)
    this.delete(gradleJsrCachePath, gradleMetaCachePath1, gradleMetaCachePath2)
    println("remove Local Gradle Cache For KT Framework: $gradleJsrCachePath")
}