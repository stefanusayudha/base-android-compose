import com.android.build.gradle.BaseExtension
import com.ckundr.plugins.defaultLibraryConfig
import com.ckundr.plugins.getKeyStoreProperties
import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    id("java-platform")
}

group = "android"
version = "1.0.0"

// Load keystore
val keystoreProperties = getKeyStoreProperties(
    "${rootDir.absolutePath}/keystore.properties"
)

subprojects {
    apply(plugin = "com.android.library")
    apply(plugin = "org.jetbrains.kotlin.android")
    apply(plugin = "kotlin-android")
    apply(plugin = "kotlin-parcelize")
    apply(plugin = "kotlin-kapt")

    plugins.withType(BasePlugin::class.java).configureEach {
        configure<BaseExtension> {
            defaultLibraryConfig(
                versionCode = 1,
                versionName = "1.0",
                keystoreProperties = keystoreProperties
            )
        }

    }

}

dependencies {
    constraints {
        api(project(":control:provider"))
    }
}