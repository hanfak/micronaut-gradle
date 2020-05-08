object TestLibs {
    const val junitBom = "org.junit:junit-bom:${Versions.junit5}"
    const val junitRuntime = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
    const val junitApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
    const val junitParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junit5}"
    const val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val micronautJunit5Test = "io.micronaut.test:micronaut-test-junit5:${Versions.micronautJunit5}"


    val testLibraries = listOf(junitRuntime, junitApi, junitParams, assertjCore, mockitoCore, micronautJunit5Test)
}