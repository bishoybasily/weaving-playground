import org.gradle.api.Plugin
import org.gradle.api.Project

class ConventionsWeaving implements Plugin<Project> {

    void apply(Project module) {

        module.pluginManager.apply('io.freefair.aspectj.post-compile-weaving')
        module.sourceSets {
            main {
                java {
                    srcDirs = ['src/main/java', 'src/main/aspect']
                }
            }
        }
        module.dependencies {
            compileOnly 'org.aspectj:aspectjweaver'
            implementation 'org.aspectj:aspectjrt'
        }
        module.tasks.named('compileJava') {
            ajc.options.compilerArgs += "-showWeaveInfo"
            ajc.options.compilerArgs += "-verbose"
            ajc.options.compilerArgs += "-Xlint:adviceDidNotMatch=error"
        }
        module.tasks.named('compileTestJava') {
            ajc.options.compilerArgs += "-showWeaveInfo"
            ajc.options.compilerArgs += "-verbose"
            ajc.options.compilerArgs += "-Xlint:adviceDidNotMatch=error"
        }

    }
}
