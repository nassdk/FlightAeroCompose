plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("com.nassdk.flightaero.module-configurator") {
            id = "com.nassdk.flightaero.module-configurator"
            implementationClass = "buildSrc.ModuleConfiguratorPlugin"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(dependencyNotation = "com.android.tools.build:gradle:7.1.2")
    implementation(dependencyNotation = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}