plugins {
    kotlin("jvm") version "1.6.21"
    id("io.gitlab.arturbosch.detekt") version "1.20.0"
}

group = "krosemann.lise.declarative.coding.kata"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // JUnit 5
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    // AssertJ
    testImplementation("org.assertj:assertj-core:3.22.0")
}

/* Source sets by Kotlin conventions /src and /test */
val sources = setOf("main" to "src/", "test" to "test/")
kotlin {
    sources.forEach { (set, dir) ->
        sourceSets[set].apply { kotlin.srcDirs(dir) }
    }
}

/* Resources */
sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("test-resources")

/* Detekt */
detekt {
    source = files(sources.map { it.second })
    config = files("detekt.yml")
}

/* Check with JUnit 5 */
tasks.test {
    useJUnitPlatform {
        includeEngines("junit-jupiter")
        excludeEngines("junit-vintage")
    }
}

/* Gradle wrapper */
tasks.withType<Wrapper> {
    gradleVersion = "7.4.2"
    distributionType = Wrapper.DistributionType.BIN
}