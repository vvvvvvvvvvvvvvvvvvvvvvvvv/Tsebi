package plugins

import org.gradle.api.Project

class AndroidAppPlugin : BaseAndroidPlugin() {

    override fun apply(project: Project) {
        project.plugins.apply(Plugins.ANDROID_APPLICATION)
        //project.plugins.apply(Plugins.LICENCE_PLUGIN)
        super.apply(project)
    }

}