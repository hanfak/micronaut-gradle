import infrastructure.MicronautLibs

plugins {
    `micronaut-demo-module`
    id("net.ltgt.apt-eclipse") version "0.21"
    id("application")
}

tasks {
    withType<JavaExec> {
        jvmArgs("-noverify", "-XX:TieredStopAtLevel=1", "-Dcom.sun.management.jmxremote")
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
    }
}

// TODO add some function that takes list of all libraries for
//  each dep type ie testImpl, impl etc and executes it as separate
// separate functions for each package. One for core, infrast etc
dependencies {
    annotationProcessorBomDependencies(listOf(MicronautLibs.micronautBom))

    annotationProcessorDependencies(MicronautLibs.annotationProcessorLibraries)

    implementationDependencies(MicronautLibs.micronaughtLibraries)

    implementationBomDependencies(listOf(MicronautLibs.micronautBom))

    runtimeOnlyDependencies(listOf(Libs.logback))

    testAnnotationProcessorBomDependencies(listOf(MicronautLibs.micronautBom))

    testAnnotationProcessorDependencies(listOf(MicronautLibs.micronautInjectJava))

    testImplementationBomDependencies(listOf(
            MicronautLibs.micronautBom,
            TestLibs.junitBom))

    testImplementationDependencies(TestLibs.testLibraries)

    testRuntimeOnlyDependencies(listOf(TestLibs.junitRuntime))
}

// Cannot extract these out as cannot access implemetnation as it is a gradle file only method, maybe other way
fun DependencyHandlerScope.implementationDependencies(vararg dependencies: List<String>) {
    dependencies.asList().flatten().forEach { dependencyInfo -> implementation(dependencyInfo) }
}

fun DependencyHandlerScope.annotationProcessorDependencies(vararg annotationProcessorDependencies: List<String>) {
    annotationProcessorDependencies.asList().flatten().forEach { dependencyInfo -> testAnnotationProcessor(dependencyInfo) }
}

fun DependencyHandlerScope.annotationProcessorBomDependencies(vararg annotationProcessorBomDependencies: List<String>) {
    annotationProcessorBomDependencies.asList().flatten().forEach { dependencyInfo -> testAnnotationProcessor(platform(dependencyInfo)) }
}

fun DependencyHandlerScope.implementationBomDependencies(vararg implementationBomDependencies: List<String>) {
    implementationBomDependencies.asList().flatten().forEach { dependencyInfo -> implementation(platform(dependencyInfo)) }
}

fun DependencyHandlerScope.runtimeOnlyDependencies(vararg runtimeOnlyDependencies: List<String>) {
    runtimeOnlyDependencies.asList().flatten().forEach { dependencyInfo -> runtimeOnly(dependencyInfo) }
}

fun DependencyHandlerScope.testRuntimeOnlyDependencies(vararg testRuntimeOnlyDependencies: List<String>) {
    testRuntimeOnlyDependencies.asList().flatten().forEach { dependencyInfo -> testRuntimeOnly(dependencyInfo) }
}

fun DependencyHandlerScope.testImplementationDependencies(vararg testDependencies: List<String>) {
    testDependencies.asList().flatten().forEach { dependencyInfo -> testImplementation(dependencyInfo) }
}

fun DependencyHandlerScope.testAnnotationProcessorDependencies(vararg testAnnotationDependencies: List<String>) {
    testAnnotationDependencies.asList().flatten().forEach { dependencyInfo -> testAnnotationProcessor(dependencyInfo) }
}

fun DependencyHandlerScope.testAnnotationProcessorBomDependencies(vararg testAnnotationProcessorBomDependencies: List<String>) {
    testAnnotationProcessorBomDependencies.asList().flatten().forEach { dependencyInfo -> testAnnotationProcessor(platform(dependencyInfo)) }
}

fun DependencyHandlerScope.testImplementationBomDependencies(vararg testBomDependencies: List<String>) {
    testBomDependencies.asList().flatten().forEach { dependencyInfo -> testImplementation(platform(dependencyInfo)) }
}
