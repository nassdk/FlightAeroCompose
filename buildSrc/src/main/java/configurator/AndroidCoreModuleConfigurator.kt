package configurator

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidCoreModuleConfigurator : ProjectConfigurator {

    override fun configure(project: Project) {
        configurePlugins(project = project)

        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion(31)
                defaultConfigConfiguration(project = project)
                compileOptionsConfigurator()
                kotlinOptionsConfigurator(project = project)
                packagingOptionsConfigurator()
                composeOptionsConfigurator()
            }
        } else {
            project.logger.error("Failed to configure android settings for ${project.name} module")
        }
    }

    private fun configurePlugins(project: Project) {

        with(project.plugins) {
            apply("com.android.library")
            apply("kotlin-android")
            apply("kotlin-kapt")
        }
    }

    private fun BaseExtension.defaultConfigConfiguration(project: Project) {
        defaultConfig {
            minSdk = 23
            targetSdk = 31
            versionName = "1.0"
            versionCode = 1

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables.useSupportLibrary = true
        }
    }

    private fun BaseExtension.compileOptionsConfigurator() {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    private fun BaseExtension.kotlinOptionsConfigurator(project: Project) {
        project.tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    private fun BaseExtension.composeOptionsConfigurator() {
        composeOptions {
            kotlinCompilerExtensionVersion = "1.0.5"
        }
    }

    private fun BaseExtension.packagingOptionsConfigurator() {
        packagingOptions {
            resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}