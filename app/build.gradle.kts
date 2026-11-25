import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp") // KSP eklentisi
    id("com.google.dagger.hilt.android") // Hilt eklentisi
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
}