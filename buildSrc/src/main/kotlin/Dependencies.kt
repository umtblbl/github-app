object Apps {
    const val compileSdk = 31
    const val buildTools = "30.0.3"
    const val minSdk = 26
    const val targetSdk = 31
    const val applicationId = "com.umit.githubapp"
    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTarget = "1.8"
}

object Versions {
    const val annotation = "1.2.0"
    const val appCompat = "1.3.0"
    const val constraintLayout = "2.0.4"
    const val coreKtx = "1.5.0"
    const val gradle = "4.2.1"
    const val fragment = "1.3.4"
    const val kotlin = "1.5.10"
    const val ktLint = "0.41.0"
    const val legacySupport = "1.0.0"
    const val materialDesign = "1.4.0"

    // Navigation
    const val navigation = "2.3.5"

    // test
    const val androidJunit = "1.1.2"
    const val espresso = "3.3.0"
    const val junit = "4.13.2"
}

object Libs {
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val ktLint = "com.pinterest:ktlint:${Versions.ktLint}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
}

object Tests {
    const val jUnit = "junit:junit:${Versions.junit}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Paths {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "android"
    const val kotlinExtensions = "android.extensions"
    const val kotlinKapt = "kapt"
    const val compilation = "scripts.compilation"
    const val ktLint = "scripts.ktlint"
    const val variants = "scripts.variants"
    const val navigationArgs = "androidx.navigation.safeargs.kotlin"
}