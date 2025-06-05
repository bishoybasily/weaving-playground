import org.gradle.api.Plugin
import org.gradle.api.Project

class ConventionsVervericaWeaver implements Plugin<Project> {

    void apply(Project module) {

        def weaverModuleName = "${module.name}-weaver"
        def weaverModule = module.rootProject.allprojects.find { it.name == weaverModuleName }

        if (weaverModule) {
            module.pluginManager.apply('io.freefair.aspectj.post-compile-weaving')
            module.dependencies {
                aspect weaverModule
                implementation weaverModule
                testImplementation weaverModule
            }

            module.tasks.named('compileJava') {
                ajc.options.compilerArgs += "-showWeaveInfo"
                ajc.options.compilerArgs += "-verbose"
                ajc.options.compilerArgs += "-Xlint:adviceDidNotMatch=error"
            }

        }
    }
}
