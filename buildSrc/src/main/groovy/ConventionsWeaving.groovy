import org.gradle.api.Plugin
import org.gradle.api.Project

class ConventionsWeaving implements Plugin<Project> {

    void apply(Project module) {

        def moduleName = module.name
        if (moduleName.endsWith("-weaver")) {
            // this is a weaver module
            def wovenModuleName = moduleName.substring(0, moduleName.lastIndexOf("-weaver"))
            // 1- find the corresponding woven module of this module
            def wovenModule = module.rootProject.allprojects.find { it.name == wovenModuleName }
            // 2- if a woven module is found, only include its main sources "compileOnly"
            if (wovenModule) {
                module.pluginManager.apply('io.freefair.aspectj.post-compile-weaving')
                module.dependencies {
                    compileOnly 'org.aspectj:aspectjweaver'
                    // not necessary but a nice to have for the ide to be aware of the classes being woven
                    compileOnly module.files("${wovenModule.buildDir.path}/classes/java/main")
                }
            }
        } else {
            // the module to be woven
            def weaverModuleName = "${moduleName}-weaver"
            // 1- find the corresponding weaver module of this module
            def weaverModule = module.rootProject.allprojects.find { it.name == weaverModuleName }
            // 2- if a weaver module is found, apply it this module
            if (weaverModule) {
                module.pluginManager.apply('io.freefair.aspectj.post-compile-weaving')
                module.dependencies {
                    aspect weaverModule
                    implementation weaverModule
                    testImplementation weaverModule
                    implementation 'org.aspectj:aspectjrt'
                }
                module.tasks.named('compileJava') {
                    ajc.options.compilerArgs += "-showWeaveInfo"
                    ajc.options.compilerArgs += "-verbose"
                    ajc.options.compilerArgs += "-Xlint:adviceDidNotMatch=error"
                }
            }
        }

    }
}
