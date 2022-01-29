package buildSrc

import org.gradle.api.Project

internal interface ProjectConfigurator {
    fun configure(project: Project)
}