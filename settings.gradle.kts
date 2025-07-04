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
    }
}

rootProject.name = "PlataformaChamados"
include(":app")

include(":core:auth")
include(":core:design_system")
include(":feature:login")
include(":feature:register_user")
include(":ui:technicians")
include(":data:technicians")
include(":domain:technicians")
include(":core:networking")
include(":core:network")
