package infrastructure

import Versions

object MicronautLibs {
    const val micronautInject = "io.micronaut:micronaut-inject:${Versions.micronaut}"
    const val micronautBom = "io.micronaut:micronaut-bom:${Versions.micronaut}"
    const val micronautValidation = "io.micronaut:micronaut-validation:${Versions.micronaut}"
    const val micronautRuntime = "io.micronaut:micronaut-runtime:${Versions.micronaut}"
    const val micronautNettyServer = "io.micronaut:micronaut-http-server-netty:${Versions.micronaut}"
    const val micronautNettyClient = "io.micronaut:micronaut-http-client:${Versions.micronaut}"
    const val micronautInjectJava = "io.micronaut:micronaut-inject-java:${Versions.micronaut}"
    const val micronautOpenapi = "io.micronaut.configuration:micronaut-openapi:${Versions.micronautopenapi}"

    val micronaughtLibraries = listOf(micronautInject,
            micronautValidation,
            micronautRuntime,
            micronautNettyServer,
            micronautNettyClient)

    val annotationProcessorLibraries = listOf(
            micronautInject,
            micronautValidation,
            micronautOpenapi)
}
