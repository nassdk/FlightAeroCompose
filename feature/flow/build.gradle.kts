android {
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(dependencyNotation = libs.accompanist.systemUiController)
    implementation(dependencyNotation = projects.core.common)
    kapt(dependencyNotation = libs.daggerCompiler)
}