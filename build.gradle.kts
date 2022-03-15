import buildSrc.configurators.dependencies.Plugins

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(dependencyNotation = buildSrc.configurators.dependencies.ClasspathDeps.gradle)
        classpath(dependencyNotation = buildSrc.configurators.dependencies.ClasspathDeps.kotlin)
        classpath(dependencyNotation = buildSrc.configurators.dependencies.ClasspathDeps.serialization)
        classpath(dependencyNotation = buildSrc.configurators.dependencies.ClasspathDeps.realm)
    }
}

apply(plugin = Plugins.moduleConfigurator)

subprojects {
    apply(plugin = Plugins.moduleConfigurator)
}