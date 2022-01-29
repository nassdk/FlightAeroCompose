import buildSrc.configurators.dependencies.Deps

android {
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(dependencyNotation = Deps.composeActivity)
    implementation(dependencyNotation = Deps.accompanistSystemUiController)

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