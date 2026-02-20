
plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
kotlin {
    jvmToolchain(21)


    dependencies {
        implementation(libs.firebase.crashlytics.buildtools)
        implementation(libs.koin.core)
        implementation(libs.bundles.kotlin.coroutines)
        implementation(libs.androidx.paging.common)
        implementation(project(":core:network"))
    }
}
