import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandler.fragment() {
    implementation(Library.ANDROIDX_FRAGMENT)
    implementation(Library.ANDROIDX_FRAGMENT_KTX)
}

fun DependencyHandler.materialDesign() {
    implementation(Library.ANDROID_MATERIAL)
}

fun DependencyHandler.fullMaterialDesign() {
    implementation(Library.SWIPE_TO_REFRESH)
    implementation(Library.PAGE_INDICATOR)
}

fun DependencyHandler.permissionDispatcher() {
    implementation(Library.PERMISSION_DISPATCHER)
    kapt(Library.PERMISSION_DISPATCHER_ANNOTATION_PROCESSOR)
}

fun DependencyHandler.constraintLayout() {
    implementation(Library.ANDROIDX_CONSTRAINT)
}

fun DependencyHandler.androidX() {
    implementation(Library.ANDROIDX_CORE)
    implementation(Library.ANDROIDX_APPCOMPAT)
}

fun DependencyHandler.recyclerView() {
    implementation(Library.ANDROIDX_RECYCLER)
}

fun DependencyHandler.kotlinStd() {
    implementation(Library.KOTLIN_STDLIB)
}

fun DependencyHandler.paging() {
    implementation(Library.PAGING)
}

fun DependencyHandler.navigation() {
    implementation(Library.CICERONE)
}

fun DependencyHandler.youtubePlayer() {
    implementation(Library.YOUTUBE_PLAYER)
}

fun DependencyHandler.testsImplementation() {
    testimplementation(Library.JUNIT)
    androidTestImplementation(Library.JUNIT_EXT)
    androidTestImplementation(Library.EXPRESSO)
}


fun DependencyHandler.coreBase() {
    dagger()
    navigation()
    constraintLayout()
    materialDesign()
    moshi()

}

fun DependencyHandler.retrofit() {
    implementation(Library.RETROFIT)
    implementation(Library.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Library.OKHTTP)
    implementation(Library.MOSHI_RETROFIT)
}

fun DependencyHandler.dagger(withAssistedInject: Boolean = true) {
    implementation(Library.DAGGER)
    kapt(Library.DAGGER_COMPILER)
    kapt(Library.DAGGER_PROCESSOR)
    implementation(Library.DAGGER_COMPONENT_MANAGER)

    if (withAssistedInject) {
        compileOnly(Library.DAGGER_INJECT_ASSISTED_ANNOTATIONS)
        kapt(Library.DAGGER_INJECT_ASSISTED_PROCESSOR)
    }
}

fun DependencyHandler.glide() {
    implementation(Library.GLIDE)
    implementation(Library.GLIDE_OKHTTP_INTEGRATION)
    kapt(Library.GLIDE_COMPILER)
}

fun DependencyHandler.coil() {
    implementation(Library.COIL)
    implementation(Library.COIL_SVG)
}

fun DependencyHandler.location() {
    implementation(Library.LOCATION)
}

fun DependencyHandler.moshi() {
    implementation(Library.MOSHI)
    kapt(Library.MOSHI_CODEGEN)
}

fun DependencyHandler.lifecycle() {
    implementation(Library.ANDROID_LIFECYCLE_EXTENSIONS)
    implementation(Library.ANDROID_LIFECYCLE_VIEW_MODEL_EXTENSIONS)
    implementation(Library.ANDROID_LIFECYCLE_LIVE_DATA_EXTENSIONS)
}

fun DependencyHandler.coroutines() {
    implementation(Library.COROUTINES_CORE)
    implementation(Library.COROUTINES_ANDROID)
}

fun DependencyHandler.leakCanary() {
    add("withTestPanelImplementation", Library.LEAK_CANARY)
}

fun DependencyHandler.chucker() {
    add("withTestPanelImplementation", Library.CHUCKER)
    add("withoutTestPanelImplementation", Library.CHUCKER_NO_OP)
}


fun DependencyHandler.zxing() {
    implementation(Library.ZXING)
    implementation(Library.ZXING_ANDROID)
}

fun DependencyHandler.logs() {
    implementation(Library.TIMBER)
}

fun DependencyHandler.joda() {
    implementation(Library.JODA)
}

fun DependencyHandler.implementationModule(moduleName: String) {
    implementation(project(":$moduleName"))
}

private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.testimplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

private fun DependencyHandler.compileOnly(dependencyNotation: Any): Dependency? =
    add("compileOnly", dependencyNotation)

private fun DependencyHandler.project(
    path: String,
    configuration: String? = null
): ProjectDependency {
    val notation = if (configuration != null) {
        mapOf("path" to path, "configuration" to configuration)
    } else {
        mapOf("path" to path)
    }

    return uncheckedCast(project(notation))
}

@Suppress("unchecked_cast", "nothing_to_inline", "detekt.UnsafeCast")
private inline fun <T> uncheckedCast(obj: Any?): T = obj as T
