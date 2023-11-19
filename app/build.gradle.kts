plugins {
    id(Plugins.ANDROID_APP_PLUGIN_WITH_DEFAULT_CONFIG)
}

android {
    namespace = "com.tsebi"
}

dependencies {
    androidX()
    materialDesign()
    constraintLayout()
    testsImplementation()
    coroutines()
}