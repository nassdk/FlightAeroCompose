import buildSrc.configurators.dependencies.Deps

android {
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(dependencyNotation = Deps.dataStore)
}