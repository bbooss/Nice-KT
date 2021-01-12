


pluginManagement {
    repositories {
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://plugins.gradle.org/m2/")
        gradlePluginPortal()
    }
}

include("subProjects:nice-log")
findProject(":subProjects:nice-log")?.name = "nice-log"
include("subProjects:nice-tools")
findProject(":subProjects:nice-tools")?.name = "nice-tools"
include("subProjects:jodd-dependency")
findProject(":subProjects:jodd-dependency")?.name = "jodd-dependency"
include("subProjects:nice-crypto")
findProject(":subProjects:nice-crypto")?.name = "nice-crypto"
include("subProjects:nice-scaffold")
findProject(":subProjects:nice-scaffold")?.name = "nice-scaffold"
include("apps:app-gateway")
findProject(":apps:app-gateway")?.name = "app-gateway"
include("apps:VertxResearch")
findProject(":apps:VertxResearch")?.name = "VertxResearch"
include("apps:proto-lib")
findProject(":apps:proto-lib")?.name = "proto-lib"
include("apps:app-login")
findProject(":apps:app-login")?.name = "app-login"
include("apps:app-gameserver")
findProject(":apps:app-gameserver")?.name = "app-gameserver"
include("lib-core")
include("apps:lib-core")
findProject(":apps:lib-core")?.name = "lib-core"
include("apps:app-allinone")
findProject(":apps:app-allinone")?.name = "app-allinone"
