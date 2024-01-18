plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.alexblanco.examen_alex"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.alexblanco.examen_alex"
        minSdk = 26
        targetSdk = 33
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
 buildFeatures{
    dataBinding = true
}

dependencies {

implementation("androidx.core:core-ktx:1.9.0")
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("com.google.android.material:material:1.11.0")
implementation("androidx.constraintlayout:constraintlayout:2.1.4")
implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
testImplementation("junit:junit:4.13.2")
androidTestImplementation("androidx.test.ext:junit:1.1.5")
androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
implementation ("androidx.fragment:fragment-ktx:1.3.6")
implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

implementation("androidx.room:room-runtime:2.4.2")
implementation ("androidx.room:room-ktx:2.4.2")
implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")

// - - ViewModel and LiveData
val lifecycle_version = "2.4.0"
implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

// - - Kotlin Coroutines
val coroutines_version = "1.3.7"
implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
}
}