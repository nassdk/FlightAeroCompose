plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("com.nassdk.flightaero.module-configurator") {
            id = "com.nassdk.flightaero.module-configurator"
            implementationClass = "configurator.ModuleConfiguratorPlugin"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.4")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
}