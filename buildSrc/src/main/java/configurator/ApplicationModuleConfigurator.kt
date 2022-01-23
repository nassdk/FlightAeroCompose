package configurator

import com.android.build.gradle.AppExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal class ApplicationModuleConfigurator : ProjectConfigurator {

    override fun configure(project: Project) {

        configurePlugins(project = project)

        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is AppExtension) {
            androidExtension.apply {
                compileSdkVersion(31)
                buildToolsVersion("30.0.2")
                defaultConfigConfiguration()
                buildTypesConfiguration()
                compileOptionsConfigurator()
                kotlinOptionsConfigurator(project = project)
                composeOptionsConfigurator()
                packagingOptionsConfigurator()
            }
        }
    }

    private fun configurePlugins(project: Project) {

        with(project.plugins) {
            apply("com.android.application")
            apply("kotlin-android")
            apply("kotlin-parcelize")
            apply("kotlinx-serialization")
            apply("kotlin-kapt")
        }
    }

    private fun AppExtension.defaultConfigConfiguration() {

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
    }

    private fun AppExtension.buildTypesConfiguration() {
        buildTypes {
            named("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile(name = "proguard-android.txt"), "proguard-rules.pro"
                )
            }
        }
    }

    private fun AppExtension.compileOptionsConfigurator() {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    private fun AppExtension.kotlinOptionsConfigurator(project: Project) {
        project.tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    private fun AppExtension.composeOptionsConfigurator() {
        composeOptions {
            kotlinCompilerExtensionVersion = "1.0.5"
        }
    }

    private fun AppExtension.packagingOptionsConfigurator() {
        packagingOptions {
            resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}