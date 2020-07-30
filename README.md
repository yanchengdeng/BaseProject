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