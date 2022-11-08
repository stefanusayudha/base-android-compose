// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:${libs.versions.gradle.plugin.get()}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
    }
    extra.apply {
//        set("variableName", "value")
    }
}

plugins {
    alias (libs.plugins.android.application) apply false
    alias (libs.plugins.android.library) apply false
    alias (libs.plugins.kotlin.android) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}