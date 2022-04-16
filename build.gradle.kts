buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Paths.gradle)
        classpath(Paths.kotlin)
        classpath(Paths.navigationArgs)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    afterEvaluate {
        apply(plugin = Plugins.ktLint)
    }
}