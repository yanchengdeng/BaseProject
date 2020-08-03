# BaseProject


## library发布到AAR
1. Library项目的build.gradle中增加如下代码
''' 
//对maven_build.gradle进行依赖
apply from: 'maven_build.gradle'

'''

2. 创建文件 maven_build.gradle
'''
apply plugin: 'maven'

ext {
    // 这个路径是从Github上Clone的本地路径
    GITHUB_REPO_PATH = "D:\\android_project\\BaseProject"
    // 在用到的代码上依赖的代码compile 'com.andrjhf.storage:encrypt:1.0.0'
    PUBLISH_GROUP_ID = 'com.dyc.common'
    PUBLISH_ARTIFACT_ID = 'baseproject'
    PUBLISH_VERSION = '1.0.0'
}

uploadArchives {
    repositories.mavenDeployer {
        def deployPath = file(project.GITHUB_REPO_PATH)
        repository(url: "file://${deployPath.absolutePath}")
        pom.project {
            groupId project.PUBLISH_GROUP_ID
            artifactId project.PUBLISH_ARTIFACT_ID
            version project.PUBLISH_VERSION
        }
    }
}

// 源代码一起打包(不需要打包源代码的不要添加这几行)
task androidSourcesJar(type: Jar) {
    classifier = 'sources'
    from android.sourceSets.main.java.sourceFiles
}
artifacts {
    archives androidSourcesJar
}


'''

3. 在整个项目的build.gradle中增加如下代码
注意这个链接一定是这个形式的，只需要修改UserName和ProjectName就可以了
'''
allprojects {
    repositories {
        maven { url "https://raw.githubusercontent.com/dengyancheng/BaseProject/master" }
    }
}

'''

4. 运行 发布
点击项目右侧Gradle，找到对应的项目，找到upload下的uploadArchives双击运行






## 组件化开发说明

'''
参考：
[MVVMHabitComponent](https://github.com/goldze/MVVMHabitComponent)
[MVVMHabitComponent](https://github.com/goldze/MVVMHabitComponent)

'''
### 目的: 
高内聚，低耦合，代码边界清晰，每一个组件都可以拆分出来独立运行。所有组件寄托于宿主App，加载分离的各个组件，各自编译自己的模块，有利于多人团队协作开发

### 方法使用
1. 定义一个变量控制组件运行方式
在gradle.properties 中定义  isBuildModule ： true 时可以使每个组件独立运行, false 则可以将所有组件集成到宿主 App 中
isBuildModule=false
2. 因为组件中的build.gradle 大体相同，这里直接创建一个 公用的  

 