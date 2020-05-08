import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `micronaut-demo-module`
    id("net.ltgt.apt-eclipse") version "0.21"
    id("application")
}

tasks {
    withType<JavaExec> {
        jvmArgs("-noverify", "-XX:TieredStopAtLevel=1", "-Dcom.sun.management.jmxremote")
    }

    withType<JavaCompile>{
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
    }
}

// TODO add some function that takes list of all libraries for
//  each dep type ie testImpl, impl etc and executes it as separate
dependencies {
    annotationProcessor (platform("io.micronaut:micronaut-bom:${Versions.micronautVersion}"))
    annotationProcessor ("io.micronaut:micronaut-inject-java")
    annotationProcessor ("io.micronaut:micronaut-validation")
    annotationProcessor ("io.micronaut.configuration:micronaut-openapi")
    implementation (platform("io.micronaut:micronaut-bom:${Versions.micronautVersion}"))
    implementation ("io.micronaut:micronaut-inject")
    implementation ("io.micronaut:micronaut-validation")
    implementation ("io.micronaut:micronaut-runtime")
    implementation ("io.micronaut:micronaut-http-server-netty")
    implementation ("io.micronaut:micronaut-http-client")
    runtimeOnly ("ch.qos.logback:logback-classic:1.2.3")
    testAnnotationProcessor(platform("io.micronaut:micronaut-bom:${Versions.micronautVersion}"))
    testAnnotationProcessor("io.micronaut:micronaut-inject-java")
    testImplementation(platform("io.micronaut:micronaut-bom:${Versions.micronautVersion}"))
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testImplementation(platform(TestLibs.junitBom))
    testImplementation(TestLibs.assertjCore)
    testImplementation(TestLibs.junitApi)
    testImplementation(TestLibs.junitParams)

    testRuntimeOnly(TestLibs.junitRuntime)
}