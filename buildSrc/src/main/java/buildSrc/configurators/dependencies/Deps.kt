package buildSrc.configurators.dependencies

object Deps {
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val composeActivity = "androidx.activity:activity-ktx:${Version.composeActivity}"
    const val navigation = "androidx.navigation:navigation-compose:${Version.navigation}"
    const val dataStore = "androidx.datastore:datastore-preferences:${Version.dataStore}"
    const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
    const val composeConstraint = "androidx.constraintlayout:constraintlayout-compose:${Version.composeConstraint}"
    const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val dagger = "com.google.dagger:dagger:${Version.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    const val timber = "com.jakewharton.timber:timber:${Version.timber}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesAndroid}"
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Version.mockitoKotlin}"
    const val junit = "androidx.test.ext:junit:${Version.junit}"
    const val accompanistPlaceholder = "com.google.accompanist:accompanist-placeholder-material:${Version.accompanist}"
    const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serializationJson}"
    const val serializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Version.serializationConverter}"
    const val accompanistSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:${Version.accompanist}"
}
