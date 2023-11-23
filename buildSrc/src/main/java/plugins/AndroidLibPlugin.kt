package plugins

import org.gradle.api.Project

class AndroidLibPlugin : BaseAndroidPlugin() {

    override fun apply(project: Project) {
        project.plugins.apply(Plugins.ANDROID_LIBRARY)
        super.apply(project)
    }

}