android {

    buildFeatures {
        compose = true
    }
}

dependencies {

    projects.core.run {
        api(dependencyNotation = ui)
        api(dependencyNotation = di)
        api(dependencyNotation = network)
        api(dependencyNotation = navigation)
    }

    libs.run {
        implementation(dependencyNotation = androidx.datastore)

        api(dependencyNotation = kotlin.coroutines)
        api(dependencyNotation = timber)
        api(dependencyNotation = bundles.lifecycle)

        kapt(dependencyNotation = daggerCompiler)
    }
}