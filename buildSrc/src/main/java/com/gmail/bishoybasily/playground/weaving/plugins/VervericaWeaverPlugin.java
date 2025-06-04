package com.gmail.bishoybasily.playground.weaving.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class VervericaWeaverPlugin implements Plugin<Project> {

    @Override
    public void apply(Project module) {

        module.getRootProject()
                .getAllprojects()
                .stream().filter(proj -> proj.getName().equals("%s-weaver".formatted(module.getName())))
                .findAny()
                .ifPresent(weaverModule -> {
                    module.getPluginManager().apply("io.freefair.aspectj");
                    module.getDependencies().add("aspect", weaverModule);
                    module.getDependencies().add("implementation", weaverModule);
                });


    }
}
