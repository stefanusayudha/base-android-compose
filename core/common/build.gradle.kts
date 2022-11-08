android {
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {

    // CORE
    api(libs.bundles.core)
    testApi(libs.bundles.core.test)
    androidTestApi(libs.bundles.core.android.test)

    // ARROW
    api(libs.bundles.kotlin.arrow)

    // UI
    api(libs.bundles.compose)
    testApi(libs.bundles.compose.test)
    androidTestApi(libs.bundles.compose.android.test)
    debugApi(libs.bundles.compose.debug)

    // Accompanist
    api(libs.bundles.accompanist)

    // INJECTION
    api(libs.bundles.koin)

    // RETROFIT
    api(libs.bundles.retrofit)

    // APOLLO
    api(libs.bundles.apollo)

    // BUILDER
    kapt(libs.bundles.builder.kapt)

    // PREFERENCE
    api(libs.bundles.preference)

    // GSON
    api(libs.bundles.serialization)

    // DEBUG
    debugApi(libs.bundles.chucker.debug)
    releaseApi(libs.bundles.chucker.release)

    // IMAGE LOADER
    api(libs.bundles.image.loader)

}