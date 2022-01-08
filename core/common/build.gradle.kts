plugins {
    id("com.android.library")
    kotlin(module = "android")
    kotlin(module = "kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 23
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
    }

    buildFeatures {
        compose = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
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