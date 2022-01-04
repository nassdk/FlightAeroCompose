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

    kotlinOptions {
        jvmTarget = "1.8"
    }

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