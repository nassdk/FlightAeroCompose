import buildSrc.configurators.dependencies.Plugins

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(dependencyNotation = "com.android.tools.build:gradle:7.0.4")
        classpath(dependencyNotation = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath(dependencyNotation = "org.jetbrains.kotlin:kotlin-serialization:1.5.31")
    }
}

apply(plugin = Plugins.moduleConfigurator)

subprojects {
    apply(plugin = Plugins.moduleConfigurator)
}