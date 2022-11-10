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
    id (libs.plugins.android.application.get().pluginId) apply false
    id (libs.plugins.android.library.get().pluginId) apply false
    id (libs.plugins.kotlin.android.get().pluginId) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}