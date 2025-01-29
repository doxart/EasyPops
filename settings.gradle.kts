pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        maven(url = "https://repository-achartengine.forge.cloudbees.com/snapshot/")
        maven(url = "https://maven.google.com")
        maven(url = "https://jitpack.io")

        gradlePluginPortal()
    }
}

rootProject.name = "ModuleCustomPopUp"
include(":app")
include(":easypops")
