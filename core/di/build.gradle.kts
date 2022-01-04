plugins {
    id("java-library")
    id("kotlin")
    kotlin(module = "kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    api(dependencyNotation = libs.dagger)
    kapt(dependencyNotation = libs.daggerCompiler)
}