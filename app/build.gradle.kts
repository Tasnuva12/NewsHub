plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.nexdecade.newshub"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nexdecade.newshub"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    //Retrofit Library
    val retrofit_version = "2.11.0"
    implementation (libs.converter.gson)
    implementation (libs.retrofit)
    implementation (libs.retrofit2.kotlin.coroutines.adapter)
    implementation(libs.logging.interceptor) // for http logging interceptor


    // ViewModel
    val lifecycle_version = "2.8.6"
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    kapt(libs.androidx.lifecycle.compiler)

    // Room dependencies
    implementation ("androidx.room:room-runtime:2.5.1" ) // Use the latest version
    annotationProcessor ("androidx.room:room-compiler:2.5.1" ) // For Java users

    // For Kotlin users, use KAPT instead of annotationProcessor
    kapt ("androidx.room:room-compiler:2.5.1")
    //coil
    implementation(libs.coil)

    //Glide
    implementation (libs.glide)
    annotationProcessor (libs.compiler)

}