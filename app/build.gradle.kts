android {
    buildFeatures {
        compose = true
    }
}

dependencies {

    projects.run {
        implementation(dependencyNotation = core.common)

        implementation(dependencyNotation = feature.splash)
        implementation(dependencyNotation = feature.flow)
        implementation(dependencyNotation = feature.flights)
        implementation(dependencyNotation = feature.profile)
        implementation(dependencyNotation = feature.flightdetails)
    }

    libs.run {
        implementation(dependencyNotation = androidx.activityCompose)
        implementation(dependencyNotation = accompanist.systemUiController)

        kapt(dependencyNotation = daggerCompiler)
    }
}