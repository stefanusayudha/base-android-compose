import com.ckundr.plugins.defaultAppConfig
import com.ckundr.plugins.getKeyStoreProperties
import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
}

// Load keystore
val keystoreProperties = getKeyStoreProperties(
    "${rootDir.absolutePath}/keystore.properties"
)

defaultAppConfig(
    appId = "com.stefanus_ayudha.basearchitecture",
    versionCode = 1,
    versionName = "1.0",
    keystoreProperties = keystoreProperties
)

dependencies {
    api(project(":control:igniter"))
}
