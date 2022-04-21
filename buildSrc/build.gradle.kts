plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    jcenter()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

object PluginsVersions {
    const val GRADLE_ANDROID = "4.1.0"
    const val KOTLIN = "1.6.0"
    const val NAVIGATION = "2.3.0"
    const val KTLINT = "0.39.0"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${PluginsVersions.NAVIGATION}")
    implementation("com.pinterest:ktlint:${PluginsVersions.KTLINT}")
}
