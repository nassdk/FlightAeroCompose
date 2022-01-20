enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FlightAeroCompose"

include(":app")
include(":core")
include(":feature")
include(":core:common")
include(":core:ui")
include(":core:di")
include(":core:network")
include(":core:navigation")
include(":feature:splash")
include(":feature:flow")
include(":feature:flights")
include(":feature:profile")
include(":feature:flightdetails")
