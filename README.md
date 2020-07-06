gradle是基于jvm的构架工具,通常使用dsl语言groovy开发,目前同样支持用kotlin进行开发

gradle插件开发(上传到本地仓库)     

```Java
1.创建groovy工程        
创建一个java-library工程,在src/main目录下新建groovy目录,在groovy目录下编写自定义插件     

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



需要在当前库build文件中引入groovy和maven的api,指定版本信息,上传本地仓库<br>
apply plugin 'groovy'<br>
apply plugin 'maven'<br>

group='com.hezd.plugins'
version='1.0.0'
uploadArchives{
    repositories{
        mavenDeployer{
            repository(url:uri('../repo'))// 本地仓库地址
        }
    }
}

dependences {
    implementation gradleApi()
    implementation localGroovy()
}

在src/main/resouces目录下创建插件配置文件,文件名就是groupid,例如这里的groupid指定位com.hezd.test,创建properties文件com.hezd.test.properties
文件中指定自定义插件名称
implementation-class=com.hezd.plugins.Test

2.执行上传仓库命令,在父目录下生成repo本地仓库<br>

3.在需要应用插件的库引入此插件<br>
    apply plugin: 'com.hezd.test'
    buildscript {
        repositories{
            maven {
                url uri(
                        '../repo'
                )
            }
        }

        dependencies {
            classpath 'com.hezd.plugins:GroovyShare:1.0.0'
        }
    }

demo工程:



感谢:
http://liuwangshu.cn/application/gradle/6-custonplugin.html
https://blog.csdn.net/Gdeer/article/details/83062523
