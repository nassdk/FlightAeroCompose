package configurator

import org.gradle.api.Project

interface ProjectConfigurator {
    fun configure(project: Project)
}