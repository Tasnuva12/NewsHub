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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    //Retrofit Library
    val retrofit_version = "2.11.0"
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0") // for http logging interceptor


    // ViewModel
    val lifecycle_version = "2.8.6"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

}