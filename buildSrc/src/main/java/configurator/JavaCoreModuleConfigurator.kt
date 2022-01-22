package configurator

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension

class JavaCoreModuleConfigurator : ProjectConfigurator {

    override fun configure(project: Project) {
        configurePlugins(project = project)

        val javaExtension = project.extensions.getByName("java")
        if (javaExtension is JavaPluginExtension) {
            javaExtension.apply {
                targetCompatibility = JavaVersion.VERSION_1_8
                sourceCompatibility = JavaVersion.VERSION_1_8
            }
        }
    }

    private fun configurePlugins(project: Project) {

        with(project.plugins) {
            apply("java-library")
            apply("kotlin")
            apply("kotlin-kapt")
        }
    }
}