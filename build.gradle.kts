import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.0"
}

group = "com.tgirard12.bbl"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("org.slf4j:slf4j-simple:1.7.25")

    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.9")
}

tasks.getting(Test::class) {
    useJUnitPlatform { }
}

dependencies {
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.create("revealjs") {
    group = "Presentation"

    inputs.file("README.adoc")
    inputs.file("reveal.js")

    outputs.files("README.html")

    doLast {
        exec {
            commandLine("node", "reveal.js")
        }
    }
}