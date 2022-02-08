package buildSrc.configurators

import buildSrc.ProjectConfigurator
import buildSrc.configurators.dependencies.Deps
import org.gradle.api.Project

internal class DependenciesConfigurator : ProjectConfigurator {

    override fun configure(project: Project) {

        with(project) {
            configureJavaModulesDependencies()
            configureAndroidModulesDependencies()
            configureModulesImplementation()
        }
    }

    private fun Project.configureJavaModulesDependencies() {

        val javaModules = arrayOf(DI_MODULE)

        if (name in javaModules) {
            implementDependency(dependency = Deps.dagger)
            kapt(dependency = Deps.daggerCompiler)
        }
    }

    private fun Project.configureAndroidModulesDependencies() {

        val ignoreModules = arrayOf(
            DI_MODULE,
            CORE_MODULE,
            CORE_FEATURE_MODULE,
            CORE_CORE_MODULE,
            CORE_BUILD_SRC_MODULE
        )

        if (name in ignoreModules) return

        implementDependency(dependency = Deps.appCompat)
        implementDependency(dependency = Deps.coreKtx)
        implementDependency(dependency = Deps.composeConstraint)
        implementDependency(dependency = Deps.composeMaterial)
        implementDependency(dependency = Deps.composeTooling)
        implementDependency(dependency = Deps.composeUi)
        implementDependency(dependency = Deps.navigation)
        implementDependency(dependency = Deps.coroutinesAndroid)
        implementDependency(dependency = Deps.lifecycle)
        implementDependency(dependency = Deps.okhttp)
        implementDependency(dependency = Deps.okhttpLogging)
        implementDependency(dependency = Deps.retrofit)
        implementDependency(dependency = Deps.serializationConverter)
        implementDependency(dependency = Deps.serializationJson)
        implementDependency(dependency = Deps.timber)
        implementDependency(dependency = Deps.junit)
        implementDependency(dependency = Deps.mockitoKotlin)
        implementDependency(dependency = Deps.dagger)
        kapt(dependency = Deps.daggerCompiler)
    }

    private fun Project.configureModulesImplementation() {

        val moduleName = project.name

        if (moduleName !in modulesWithoutCommon) {
            implementModule(modulePath = ":core:$COMMON_MODULE")
        }

        if (moduleName !in modulesWithoutUi) {
            implementModule(modulePath = ":core:$UI_MODULE")
        }

        if (moduleName !in modulesWithoutDi) {
            implementModule(modulePath = ":core:$DI_MODULE")
        }

        if (moduleName !in modulesWithoutNetwork) {
            implementModule(modulePath = ":core:$NETWORK_MODULE")
        }

        if (moduleName !in modulesWithoutNavigation) {
            implementModule(modulePath = ":core:$NAVIGATION_MODULE")
        }
    }

    private fun Project.implementModule(modulePath: String) {
        dependencies.add("implementation", project(modulePath))
    }

    private fun Project.implementDependency(dependency: String) {
        dependencies.add("implementation", dependency)
    }

    private fun Project.kapt(dependency: String) {
        dependencies.add("kapt", dependency)
    }

    private companion object {

        private const val CORE_FEATURE_MODULE = "feature"
        private const val CORE_CORE_MODULE = "core"
        private const val CORE_BUILD_SRC_MODULE = "buildSrc"
        private const val CORE_MODULE = "FlightAeroCompose"
        private const val COMMON_MODULE = "common"
        private const val NETWORK_MODULE = "network"
        private const val DI_MODULE = "di"
        private const val UI_MODULE = "ui"
        private const val NAVIGATION_MODULE = "navigation"

        private val modulesWithoutDi = arrayOf(
            UI_MODULE, NAVIGATION_MODULE, DI_MODULE, CORE_MODULE
        )

        private val modulesWithoutUi = arrayOf(
            NETWORK_MODULE, DI_MODULE, NAVIGATION_MODULE, UI_MODULE, CORE_MODULE
        )

        private val modulesWithoutCommon = arrayOf(
            NETWORK_MODULE, DI_MODULE, NAVIGATION_MODULE, UI_MODULE, COMMON_MODULE, CORE_MODULE
        )

        private val modulesWithoutNavigation = arrayOf(
            NETWORK_MODULE, DI_MODULE, NAVIGATION_MODULE, UI_MODULE, CORE_MODULE
        )

        private val modulesWithoutNetwork = arrayOf(
            NETWORK_MODULE, DI_MODULE, NAVIGATION_MODULE, UI_MODULE, CORE_MODULE
        )
    }
}