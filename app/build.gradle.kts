import com.singularity_code.plugins.defaultAppConfig
import com.singularity_code.plugins.getKeyStoreProperties

plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
}

// Load keystore
val keystoreProperties = getKeyStoreProperties(
    "${rootDir.absolutePath}/keystore.properties"
)

defaultAppConfig(
    appId = "com.singularity_code.basearchitecture",
    versionCode = 1,
    versionName = "1.0",
    keystoreProperties = keystoreProperties
)

dependencies {
    api(project(":control:igniter"))
}
