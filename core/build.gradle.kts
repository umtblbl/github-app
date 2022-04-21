import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.implementation
import extensions.kapt
import extensions.buildConfigStringField

plugins {
    id("commons.android-library")
}

android {
    buildTypes.forEach {
        it.buildConfigStringField("GITHUB_API_BASE_URL", "https://api.github.com/")
        it.buildConfigStringField("GITHUB_DATABASE_NAME", "github-db")
    }
}

dependencies {
    implementation(Dependencies.ROOM)
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER_MOSHI)
    implementation(Dependencies.LOGGING)
    implementation(Dependencies.MOSHI)
    implementation(Dependencies.MOSHI_KTX)

    kapt(AnnotationProcessorsDependencies.DATABINDING)
    kapt(AnnotationProcessorsDependencies.ROOM)
}
