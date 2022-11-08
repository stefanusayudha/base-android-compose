fun ApplicationDefaultConfig.default(
    declareApplicationId: Boolean = false,
    supportExternalLibForVectorDrawable: Boolean = false
) {
    if (declareApplicationId)
        applicationId = "com.stefanus_ayudha.basearchitecture"

    minSdk = 28
    targetSdk = 32
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
        useSupportLibrary = supportExternalLibForVectorDrawable
    }
}