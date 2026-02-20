
plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
kotlin {
    jvmToolchain(21)


    dependencies {
        implementation(libs.firebase.crashlytics.buildtools)
        api(libs.bundles.ktor)
        implementation(libs.koin.core)
        implementation(libs.bundles.kotlin.coroutines)
    }
}
