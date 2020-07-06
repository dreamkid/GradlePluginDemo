package com.hezd.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class Test implements Plugin<Project>{
    @Override
    void apply(Project project) {
        project.task("testTask"){
            try {
                def assetsPath = project.android.sourceSets.main.assets.getSrcDirs()[0]
                println("testtask:$assetsPath")
            }catch(Exception e){
                println("获取assets目录失败")
                println("父目录是:$project.parent.projectDir.absolutePath")
            }

        }

    }
}