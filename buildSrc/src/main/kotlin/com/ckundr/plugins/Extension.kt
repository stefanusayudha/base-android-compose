package com.ckundr.plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.Transformer
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.provider.Provider
import java.io.FileInputStream
import java.util.*
import java.util.function.BiFunction

fun testBundle() : Provider<ExternalModuleDependencyBundle> {
    return object : Provider<ExternalModuleDependencyBundle>{
        override fun get(): ExternalModuleDependencyBundle {
            TODO("Not yet implemented")
        }

        override fun getOrNull(): ExternalModuleDependencyBundle? {
            TODO("Not yet implemented")
        }

        override fun getOrElse(defaultValue: ExternalModuleDependencyBundle): ExternalModuleDependencyBundle {
            TODO("Not yet implemented")
        }

        override fun <S : Any?> map(transformer: Transformer<out S, in ExternalModuleDependencyBundle>): Provider<S> {
            TODO("Not yet implemented")
        }

        override fun <S : Any?> flatMap(transformer: Transformer<out Provider<out S>, in ExternalModuleDependencyBundle>): Provider<S> {
            TODO("Not yet implemented")
        }

        override fun isPresent(): Boolean {
            TODO("Not yet implemented")
        }

        override fun orElse(value: ExternalModuleDependencyBundle): Provider<ExternalModuleDependencyBundle> {
            TODO("Not yet implemented")
        }

        override fun orElse(p0: Provider<out ExternalModuleDependencyBundle>): Provider<ExternalModuleDependencyBundle> {
            TODO("Not yet implemented")
        }

        override fun forUseAtConfigurationTime(): Provider<ExternalModuleDependencyBundle> {
            TODO("Not yet implemented")
        }

        override fun <B : Any?, R : Any?> zip(
            p0: Provider<B>,
            p1: BiFunction<ExternalModuleDependencyBundle, B, R>
        ): Provider<R> {
            TODO("Not yet implemented")
        }
    }
}
//fun DependencyHandlerScope.kotlinProject() {
//    "implementation"(Libraries.kotlinStdLib)
//}
//
//fun DependencyHandlerScope.unitTestDependencies() {
//    "testImplementation"(Libraries.junit)
//}
//
//fun DependencyHandlerScope.androidTestDependencies() {
//    "androidTestImplementation"(Libraries.testRunner)
//    "androidTestImplementation"(Libraries.espressoCore)
//}

val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Project '$name' is not an Android module")

fun Project.defaultAppConfig(
    appId: String,
    versionCode: Int = 1,
    versionName: String = "1.0",
    keystoreProperties: Properties? = null
) {
    defaultConfigBuilder(
        appId = appId,
        verCode = versionCode,
        verName = versionName,
        keystoreProperties = keystoreProperties
    )
}

fun Project.defaultLibraryConfig(
    versionCode: Int = 1,
    versionName: String = "1.0",
    keystoreProperties: Properties? = null
) {
    defaultConfigBuilder(
        verCode = versionCode,
        verName = versionName,
        keystoreProperties = keystoreProperties
    )
}

private fun Project.defaultConfigBuilder(
    appId: String? = null,
    verCode: Int,
    verName: String,
    keystoreProperties: Properties? = null
) {
    android.apply {
        compileSdkVersion(33)
        defaultConfig {
            if (appId.isNullOrBlank().not())
                applicationId = appId

            minSdk = 28
            targetSdk = 32
            versionCode = verCode
            versionName = verName

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary = true
            }
        }

        if (keystoreProperties != null)
            signingConfigs {
                create("release") {
                    storeFile = file(keystoreProperties["storeFile"] as String)
                    storePassword = keystoreProperties["storePassword"] as String
                    keyAlias = keystoreProperties["keyAlias"] as String
                    keyPassword = keystoreProperties["keyPassword"] as String
                }
            }

        buildTypes {
            getByName("debug") {
                isMinifyEnabled = false
                isDebuggable = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
            create("staging") {
                isMinifyEnabled = true
                isDebuggable = true
                signingConfig = signingConfigs.getByName("release")
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
            getByName("release") {
                isMinifyEnabled = true
                isDebuggable = false
                signingConfig = signingConfigs.getByName("release")
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        packagingOptions {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
        lintOptions {
            disable += "Instantiatable"
        }
    }
}

fun Project.getKeyStoreProperties(
    path: String
) = Properties().apply {
    kotlin.runCatching {
        load(
            FileInputStream(
                file(path)
            )
        )
    }
}
