import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "bz.tsung"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
}

javafx {
    version = "17.0.8"
    modules = listOf(
        "javafx.controls",
        "javafx.swing",
        "javafx.web",
        "javafx.graphics",
    )
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "webview-bug"
            packageVersion = "1.0.0"
            modules(
                "java.instrument",
                "java.management",
                "java.net.http",
                "java.prefs",
                "java.sql",
                "jdk.crypto.ec",
                "jdk.unsupported",
                // webview start
                "javafx.controls",
                "javafx.swing",
                "javafx.web",
                "javafx.graphics",
                // webview end
            )
        }
    }
}
