android {
    buildFeatures {
        compose = true
    }
}

dependencies {

    projects.run {
        implementation(dependencyNotation = core.common)
    }

    libs.run {
        implementation(dependencyNotation = androidx.activityCompose)
        implementation(dependencyNotation = accompanist.systemUiController)

        kapt(dependencyNotation = daggerCompiler)
    }

    File("$rootDir/feature").listFiles()
        ?.filter { it.isDirectory }
        ?.forEach { module ->
            val moduleName = module.name
            val gradleFile = File("${module.absolutePath}/build.gradle")
            val gradleFileKts = File("${module.absolutePath}/build.gradle.kts")
            // Если в директории есть файл build.gradle, то это модуль
            if (gradleFile.exists() || gradleFileKts.exists()) {
                implementation(project(":feature:$moduleName"))
            }
        }
}