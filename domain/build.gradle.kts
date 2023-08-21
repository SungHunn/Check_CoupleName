plugins {
    id ("com.android.library")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace  = "com.example.domain"
    compileSdk = 33

    defaultConfig {
        minSdk  = 33
        targetSdk  = 33

        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation (KTX.CORE)
    implementation (AndroidX.APP_COMPAT)
    implementation (Google.MATERIAL)
    testImplementation (TestTool.JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_ESPRESSO)
    implementation (Firebase.FIREBASE_DATABASE_KTX)
    implementation (Firebase.FIREBASE_FIRESTORE_KTX)

    // Retrofit
    implementation (Retrofit.RETROFIT)
    implementation (Retrofit.CONVERTER_GSON)
    implementation (Retrofit.CONVERTER_JAXB)

    //okHttp
    implementation (OkHttp.OKHTTP)
    implementation (OkHttp.LOGGING_INTERCEPTOR)

    // dager hilt
    implementation (DaggerHilt.DAGGER_HILT)
    kapt (DaggerHilt.DAGGER_HILT_COMPILER)
    //implementation (DaggerHilt.DAGGER_HILT_VIEW_MODEL)
    kapt (DaggerHilt.DAGGER_HILT_ANDROIDX_COMPILER)
}