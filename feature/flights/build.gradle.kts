android {
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(dependencyNotation = projects.core.common)
    kapt(dependencyNotation = libs.daggerCompiler)
}