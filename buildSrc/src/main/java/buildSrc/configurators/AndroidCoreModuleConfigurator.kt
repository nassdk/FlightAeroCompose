package buildSrc.configurators

import buildSrc.ProjectConfigurator
import buildSrc.configurators.dependencies.Config
import buildSrc.configurators.dependencies.Plugins
import buildSrc.configurators.dependencies.Version
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal class AndroidCoreModuleConfigurator : ProjectConfigurator {

    override fun configure(project: Project) {
        configurePlugins(project = project)

        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion(apiLevel = Config.compileSdkVersion)
                defaultConfigConfiguration()
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
            apply(Plugins.android)
            apply(Plugins.ktAndroid)
            apply(Plugins.kapt)
        }
    }

    private fun BaseExtension.defaultConfigConfiguration() {
        defaultConfig {
            minSdk = Config.minSdkVersion
            targetSdk = Config.targetSdkVersion
            versionName = Config.versionName
            versionCode = Config.versionCode

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

    private fun kotlinOptionsConfigurator(project: Project) {
        project.tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    private fun BaseExtension.composeOptionsConfigurator() {
        composeOptions {
            kotlinCompilerExtensionVersion = Version.compose
        }
    }

    private fun BaseExtension.packagingOptionsConfigurator() {
        packagingOptions {
            resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}