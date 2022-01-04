buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        val libs = project.extensions
            .getByType<VersionCatalogsExtension>()
            .named("libs") as org.gradle.accessors.dm.LibrariesForLibs

        classpath(dependencyNotation = libs.plugin.gradle)
        classpath(dependencyNotation = libs.plugin.kotlin)
    }
}

task("clean") {
    delete(rootProject.buildDir)
}