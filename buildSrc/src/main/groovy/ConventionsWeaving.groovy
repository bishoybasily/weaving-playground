import org.gradle.api.Plugin
import org.gradle.api.Project


class ConventionsWeaving implements Plugin<Project> {

    private static final var COMPILER_EXTRA_ARGS = [
            "-showWeaveInfo",
            "-verbose",
            "-Xlint:adviceDidNotMatch=error"
    ]

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
            compileOnly module.libs.aspectjweaver
            implementation module.libs.aspectjrt
        }
        module.tasks.named('compileJava') {
            ajc.options.compilerArgs += COMPILER_EXTRA_ARGS
        }
        module.tasks.named('compileTestJava') {
            ajc.options.compilerArgs += COMPILER_EXTRA_ARGS
        }

    }
}
