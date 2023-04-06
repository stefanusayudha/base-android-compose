/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import java.io.FileInputStream
import java.util.*

/**
 * ## Default Config
 */
const val MIN_SDK = 28
const val TARGET_SDK = 32
const val COMPILE_SDK = 33

/**
 * ## Util
 */
val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Project '$name' is not an Android module")

/**
 * Use to define application configuration
 */
fun Project.defaultAppConfig(
    appId: String,
    versionCode: Int = 1,
    versionName: String = "1.0",
    keystoreProperties: Properties? = null,
    minSdk: Int = MIN_SDK,
    targetSdk: Int = TARGET_SDK,
    compileSdk: Int = COMPILE_SDK,
) {
    defaultConfigBuilder(
        appId = appId,
        verCode = versionCode,
        verName = versionName,
        keystoreProperties = keystoreProperties,
        minSdk = minSdk,
        targetSdk = targetSdk,
        compileSdk = compileSdk
    )
}

/**
 * Use to define library configuration
 */
fun Project.defaultLibraryConfig(
    versionCode: Int = 1,
    versionName: String = "1.0",
    keystoreProperties: Properties? = null,
    minSdk: Int = MIN_SDK,
    targetSdk: Int = TARGET_SDK,
    compileSdk: Int = COMPILE_SDK,
) {
    defaultConfigBuilder(
        verCode = versionCode,
        verName = versionName,
        keystoreProperties = keystoreProperties,
        minSdk = minSdk,
        targetSdk = targetSdk,
        compileSdk = compileSdk
    )
}

private fun Project.defaultConfigBuilder(
    appId: String? = null,
    verCode: Int,
    verName: String,
    keystoreProperties: Properties? = null,
    minSdk: Int,
    targetSdk: Int,
    compileSdk: Int,
) {
    android.apply {
        compileSdkVersion(compileSdk)
        defaultConfig {
            if (appId.isNullOrBlank().not())
                applicationId = appId

            this.minSdk = minSdk
            this.targetSdk = targetSdk
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

            if (keystoreProperties != null)
                create("staging") {
                    isMinifyEnabled = true
                    isDebuggable = true
                    signingConfig = signingConfigs.getByName("release")
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }

            if (keystoreProperties != null)
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
): Properties? = Properties().let {

    val fileLoaded = kotlin.runCatching {
        it.load(
            FileInputStream(
                file(path)
            )
        )
    }.isSuccess

    if (fileLoaded) it
    else null
}
