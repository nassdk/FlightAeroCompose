android {
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(dependencyNotation = projects.core.di)

    libs.run {
        api(dependencyNotation = retrofit)
        api(dependencyNotation = okhttp3.core)
        api(dependencyNotation = okhttp3.logging)
        api(dependencyNotation = serialization.converter)
        api(dependencyNotation = serialization.json)
        kapt(dependencyNotation = daggerCompiler)
    }
}