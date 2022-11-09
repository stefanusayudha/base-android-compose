import com.android.build.gradle.BaseExtension
import java.io.FileInputStream
import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("java-platform")
}

group = "android"
version = "1.0.0"

// Load keystore
val keystorePropertiesFile = file("${rootDir.absolutePath}/keystore.properties");
val keystoreProperties = Properties().apply {
    kotlin.runCatching {
        load(FileInputStream(keystorePropertiesFile))
    }
}

subprojects {
    apply(plugin = "com.android.library")
    apply(plugin = "org.jetbrains.kotlin.android")
    apply(plugin = "kotlin-android")
    apply(plugin = "kotlin-parcelize")
    apply(plugin = "kotlin-kapt")

    plugins.withType(BasePlugin::class.java).configureEach {
        configure<BaseExtension> {
            compileSdkVersion(33)
            defaultConfig {
                minSdk = 28
                targetSdk = 32
                versionCode = 1
                versionName = "1.0"
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                consumerProguardFiles("consumer-rules.pro")
            }
            signingConfigs {
                create("release") {
                    storeFile = file(keystoreProperties["storeFile"] ?: "path/to/keystore")
                    storePassword = keystoreProperties ["storePassword"] as String? ?:""
                    keyAlias = keystoreProperties ["keyAlias"] as String? ?: ""
                    keyPassword = keystoreProperties ["keyPassword"] as String? ?: ""
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

}

dependencies {
    constraints {
        api(project(":modsample:pokemon"))
        api(project(":modsample:splash"))
        api(project(":modsample:todolist"))
        api(project(":modsample:mmdexample"))
    }
}