
plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlinSerialization)
}
kotlin {
    jvmToolchain(21)


    dependencies {
        implementation(libs.firebase.crashlytics.buildtools)
        implementation(libs.koin.core)
        implementation(libs.bundles.kotlin.coroutines)
        implementation(libs.androidx.paging.common)

        implementation(project(":core:network"))
        implementation(project(":feature:character:domain"))
    }
}
