plugins {
    application
    checkstyle
    jacoco
}


group = "hexlet.code"
version = "1.0-SNAPSHOT"
application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
}
dependencies {
    implementation ("info.picocli:picocli:4.7.5")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.16.0")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.16.0")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.2")
    implementation ("org.apache.commons:commons-lang3:3.14.0")

    testImplementation("org.assertj:assertj-core:3.25.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
tasks.jacocoTestReport { reports { xml.required.set(true) } }