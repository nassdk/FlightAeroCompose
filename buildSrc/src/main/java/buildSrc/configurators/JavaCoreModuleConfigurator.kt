package buildSrc.configurators

import buildSrc.ProjectConfigurator
import buildSrc.configurators.dependencies.Plugins
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension

internal class JavaCoreModuleConfigurator : ProjectConfigurator {

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
            apply(Plugins.java)
            apply(Plugins.kotlin)
            apply(Plugins.kapt)
        }
    }
}