plugins {
    `micronaut-demo-module`
}

dependencies {
    testCompile(platform(TestLibs.junitBom))
    testCompile(TestLibs.assertjCore)
    testCompile(TestLibs.junitApi)
    testCompile(TestLibs.junitParams)

    testRuntimeOnly(TestLibs.junitRuntime)
}