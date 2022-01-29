package buildSrc

import buildSrc.configurators.AndroidCoreModuleConfigurator
import buildSrc.configurators.AndroidFeatureModuleConfigurator
import buildSrc.configurators.ApplicationModuleConfigurator
import buildSrc.configurators.DependenciesConfigurator
import buildSrc.configurators.JavaCoreModuleConfigurator
import buildSrc.configurators.RootModuleConfigurator
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class ModuleConfiguratorPlugin : Plugin<Project> {

    private val featureModuleConfigurator = AndroidFeatureModuleConfigurator()
    private val applicationModuleConfigurator = ApplicationModuleConfigurator()
    private val coreAndroidModuleConfigurator = AndroidCoreModuleConfigurator()
    private val coreJavaModuleConfigurator = JavaCoreModuleConfigurator()
    private val rootModuleConfigurator = RootModuleConfigurator()
    private val commonModuleConfigurators = arrayOf(
        DependenciesConfigurator()
    )

    override fun apply(target: Project) {
        target.logger.debug("Configuring ${target.name} module")
        when {
            ignoreModules.contains(element = target.name) -> return
            coreJavaModules.contains(element = target.name) -> configureCoreJavaModule(project = target)
            coreAndroidModules.contains(element = target.name) -> configureCoreAndroidModule(project = target)
            target.name == APPLICATION_PROJECT -> configureApplicationModule(project = target)
            target.name == ROOT_PROJECT -> configureRootAndroidModule(project = target)
            else -> configureFeatureModule(project = target)
        }
        configureCommonSettings(project = target)
    }

    private fun configureCommonSettings(project: Project) {
        commonModuleConfigurators.forEach { configurator ->
            configurator.configure(project = project)
        }
    }

    private fun configureFeatureModule(project: Project) {
        featureModuleConfigurator.configure(project = project)
    }

    private fun configureApplicationModule(project: Project) {
        applicationModuleConfigurator.configure(project = project)
    }

    private fun configureCoreJavaModule(project: Project) {
        coreJavaModuleConfigurator.configure(project = project)
    }

    private fun configureCoreAndroidModule(project: Project) {
        coreAndroidModuleConfigurator.configure(project = project)
    }

    private fun configureRootAndroidModule(project: Project) {
        rootModuleConfigurator.configure(project = project)
    }

    private companion object {

        private const val APPLICATION_PROJECT = "app"
        private const val ROOT_PROJECT = "FlightAeroCompose"

        private val coreJavaModules = arrayOf("di")
        private val ignoreModules = arrayOf("core", "feature")
        private val coreAndroidModules = arrayOf("common", "navigation", "network", "ui")
    }
}