import org.gradle.api.Plugin
import org.gradle.api.Project

class VervericaWeaverPlugin implements Plugin<Project> {

    void apply(Project module) {

        def weaverModuleName = "${module.name}-weaver"
        def weaverModule = module.rootProject.allprojects.find { it.name == weaverModuleName }

        if (weaverModule) {
            module.pluginManager.apply('io.freefair.aspectj')
            module.dependencies {
                aspect weaverModule
                implementation weaverModule
            }

            module.tasks.named('compileAspectj') {
//                ajcOptions.compilerArgs.addAll(['-XshowWeaveInfo', '-Xlint:adviceDidNotMatch=error'])
            }

            module.tasks.named('compileTestAspectj') {
//                ajcOptions.compilerArgs.addAll(['-XshowWeaveInfo', '-Xlint:adviceDidNotMatch=error'])
            }
        }
    }
}
