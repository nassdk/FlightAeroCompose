package buildSrc.configurators

import buildSrc.ProjectConfigurator
import org.gradle.api.Project
import org.gradle.api.tasks.Delete
import org.gradle.kotlin.dsl.register

internal class RootModuleConfigurator: ProjectConfigurator {

    override fun configure(project: Project) {
        project.tasks.register<Delete>("clean") {
            delete(project.rootProject.buildDir)
        }
    }
}