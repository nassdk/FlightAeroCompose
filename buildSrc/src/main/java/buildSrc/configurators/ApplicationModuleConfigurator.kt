package buildSrc.configurators

import buildSrc.ProjectConfigurator
import buildSrc.configurators.dependencies.Config
import buildSrc.configurators.dependencies.Plugins
import buildSrc.configurators.dependencies.Version
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
                compileSdkVersion(apiLevel = Config.compileSdkVersion)
                buildToolsVersion(version = Config.buildToolsVersion)
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
            apply(Plugins.application)
            apply(Plugins.ktAndroid)
            apply(Plugins.parcelize)
            apply(Plugins.serialization)
            apply(Plugins.kapt)
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

    private fun kotlinOptionsConfigurator(project: Project) {
        project.tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    private fun AppExtension.composeOptionsConfigurator() {
        composeOptions {
            kotlinCompilerExtensionVersion = Version.compose
        }
    }

    private fun AppExtension.packagingOptionsConfigurator() {
        packagingOptions {
            resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}