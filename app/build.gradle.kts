plugins {
    id("application") 
}

application {
    mainClass.set("Main")
}

dependencies {
    implementation(project(":library"))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}