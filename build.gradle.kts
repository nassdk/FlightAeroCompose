buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(dependencyNotation = "com.android.tools.build:gradle:7.0.4")
        classpath(dependencyNotation = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath(dependencyNotation = "org.jetbrains.kotlin:kotlin-serialization:1.5.31")
    }
}

apply(plugin = "com.nassdk.flightaero.module-configurator")

subprojects {
    apply(plugin = "com.nassdk.flightaero.module-configurator")
}