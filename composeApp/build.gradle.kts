import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("io.kotest") version "6.0.4"
    id("com.google.devtools.ksp")
    kotlin("plugin.serialization") version "1.9.0"
    id("com.google.dagger.hilt.android")

}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    js {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation("io.ktor:ktor-client-core:3.3.1")
            implementation(libs.kotlinx.serialization.core)
            implementation(libs.core)
            implementation(libs.serialization)
            implementation(libs.simple.xml)
            implementation(libs.hilt.android)
            implementation(libs.androidx.hilt.navigation.compose)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.androidx.material.icons.extended)
            implementation(compose.materialIconsExtended)





        }

        androidUnitTest.dependencies {
            implementation(kotlin("test-junit"))
        }
        androidInstrumentedTest.dependencies {
            implementation(kotlin("test-junit"))
        }
        jsMain.dependencies {

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotest.framework.engine)
            implementation(libs.kotlinx.coroutines.test)

        }
    }
}

android {
    namespace = "com.yellowneedle.yellowneedle"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.yellowneedle.yellowneedle"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    debugImplementation(compose.uiTooling)
    ksp ("com.google.dagger:hilt-compiler:2.57.1")
}

