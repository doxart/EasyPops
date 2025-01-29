buildscript {
    repositories {
        google()
        mavenCentral()

        maven(url = "https://repository-achartengine.forge.cloudbees.com/snapshot/")
        maven(url = "https://maven.google.com")
        maven(url = "https://jitpack.io")

    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
}