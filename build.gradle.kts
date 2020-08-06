import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Properties {
    object Versions {
        const val KOTLIN = "1.3.72"
        const val SPIGOT = "1.16.1-R0.1-SNAPSHOT"
    }
}

buildscript {
    repositories {
        maven {
            url = uri("https://files.minecraftforge.net/maven")
        }
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    }
}


plugins {
    kotlin("jvm") version "1.3.72"
}

group = "cf.zihad"
version = "1.0"

val javaVersion = JavaVersion.VERSION_1_8.toString()

val compileJava = tasks.withType<JavaCompile>().first()!!
val compileKotlin = tasks.withType<KotlinCompile>().first()!!
val jar = tasks.withType<Jar>().first()!!

compileJava.options.encoding = "UTF-8"
compileJava.sourceCompatibility = javaVersion
compileJava.targetCompatibility = javaVersion

compileKotlin.kotlinOptions.jvmTarget = javaVersion

jar.baseName = "${project.name}-${version}_S${Properties.Versions.SPIGOT}_K${Properties.Versions.KOTLIN}"
jar.version = ""

val compile = configurations.getByName("compile")
val embed = configurations.create("embed")

configurations {
    compile.extendsFrom(embed)
}

dependencies {
    compile(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Properties.Versions.KOTLIN}")
    compileOnly("org.spigotmc:spigot-api:${Properties.Versions.SPIGOT}")
}

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    }
}

jar.from(embed.map { if (it.isDirectory) it as Any else zipTree(it) })
