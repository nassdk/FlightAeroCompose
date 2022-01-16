plugins {
    id("com.android.application")
    kotlin(module = "android")
    kotlin(module = "kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.nassdk.aero"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(name = "proguard-android.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
    }

    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {

    projects.run {
        implementation(dependencyNotation = core.common)

        implementation(dependencyNotation = feature.splash)
        implementation(dependencyNotation = feature.flow)
        implementation(dependencyNotation = feature.flights)
        implementation(dependencyNotation = feature.profile)
        implementation(dependencyNotation = feature.settings)
    }

    libs.run {
        implementation(dependencyNotation = androidx.activityCompose)
        implementation(dependencyNotation = accompanist.systemUiController)

        kapt(dependencyNotation = daggerCompiler)
    }
}