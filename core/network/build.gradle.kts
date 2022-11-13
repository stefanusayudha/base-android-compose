plugins {
    id("com.apollographql.apollo3").version("3.1.0")
}

android {
    externalNativeBuild {
        cmake {
            path("CMakeLists.txt")
        }
    }
}

dependencies {
    api(project(":core:common"))
}

apollo {
    packageName.set("com.singularity_code.core.network")
}