buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        val libs = project.extensions
            .getByType<VersionCatalogsExtension>()
            .named("libs") as org.gradle.accessors.dm.LibrariesForLibs

        classpath(dependencyNotation = libs.plugin.gradle)
        classpath(dependencyNotation = libs.plugin.kotlin)
        classpath(dependencyNotation = libs.plugin.serialization)
    }
}

task("clean") {
    delete(rootProject.buildDir)
}