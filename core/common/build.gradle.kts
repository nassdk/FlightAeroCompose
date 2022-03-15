import buildSrc.configurators.dependencies.Deps

plugins {
    id(buildSrc.configurators.dependencies.Plugins.realm)
}

android {
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(dependencyNotation = Deps.dataStore)
}