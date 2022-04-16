plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExtensions)
    kotlin(Plugins.kotlinKapt)
    id(Plugins.variants)
    id(Plugins.compilation)
    id(Plugins.navigationArgs)
}

android {

    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildTools)

    defaultConfig {
        applicationId = Apps.applicationId
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    kotlinOptions {
        jvmTarget = Apps.jvmTarget
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.annotation)
    implementation(Libs.appCompat)
    implementation(Libs.constraintLayout)
    implementation(Libs.coreKtx)
    implementation(Libs.fragment)
    implementation(Libs.materialDesign)
    implementation(Libs.kotlin)
    implementation(Libs.legacySupport)

    testImplementation(Tests.jUnit)

    androidTestImplementation(Tests.androidJunit)
    androidTestImplementation(Tests.espresso)
}
