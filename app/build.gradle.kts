import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp") // KSP plugin
    id("com.google.dagger.hilt.android") // Hilt plugin
    id("org.jetbrains.kotlin.plugin.serialization") version "2.4.21"
}

val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")

    if (file.exists()) {
        file.inputStream().use { load(it) }
    }
}

val apiUsername: String = localProperties.getProperty("API_USERNAME") ?: ""

android {
    namespace = "com.edaakyil.app.flags"
    //compileSdk = 37
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.edaakyil.app.flags"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_USERNAME", "\"$apiUsername\"")
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    implementation("androidx.compose.material:material-icons-extended")

    // For Navigation
    implementation("androidx.navigation:navigation-compose:2.10.2")

    // For ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.11.1")

    // For Hilt
    implementation("com.google.dagger:hilt-android:2.60.1") // implementation(libs.hilt.android)
    ksp("com.google.dagger:hilt-compiler:2.60.1") // ksp(libs.hilt.compiler)
    //implementation("androidx.hilt:androidx-hilt-navigation-compose:1.2.0") // implementation(libs.androidx.hilt.navigation.compose)
    implementation("androidx.hilt:hilt-navigation-compose:1.4.0") // implementation(libs.androidx.hilt.navigation.compose)

    // For SplashScreen
    implementation("androidx.core:core-splashscreen:1.2.0")

    // For Retrofit
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    // Retrofit with Gson Converter
    //implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    // Kotlin serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.13.0")
    // Retrofit with Kotlin serialization Converter
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("com.squareup.okhttp3:okhttp:5.5.1")
    // For Gson
    //implementation("com.google.code.gson:gson:2.14.0")

    // For Coil
    //implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("io.coil-kt.coil3:coil-compose:3.6.3")
    implementation("io.coil-kt.coil3:coil-svg:3.6.3")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.6.3")
}