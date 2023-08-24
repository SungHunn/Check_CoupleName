plugins {
    id ("com.android.library")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    namespace  = "com.example.presentation"
    compileSdk  = 33

    defaultConfig {
        minSdk  = 33
        targetSdk  = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation (project (":domain"))
    implementation (project (":data"))

    implementation (KTX.CORE)
    implementation (AndroidX.APP_COMPAT)
    implementation (Google.MATERIAL)
    implementation (AndroidX.CONSTRAINT_LAYOUT)
    implementation (AndroidX.LEGACY)
    implementation (Firebase.FIREBASE_DATABASE_KTX)
    implementation (Firebase.FIREBASE_FIRESTORE_KTX)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.google.firebase:firebase-database-ktx:20.1.0")
    implementation("com.google.firebase:firebase-firestore-ktx:24.4.1")
    testImplementation (TestTool.JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_ESPRESSO)

    // dagger hilt
    implementation (DaggerHilt.DAGGER_HILT)
    kapt (DaggerHilt.DAGGER_HILT_COMPILER)
    kapt (DaggerHilt.DAGGER_HILT_ANDROIDX_COMPILER)

    // ViewModel
    implementation (AndroidX.LIFECYCLE_VIEW_MODEL)

    // LiveData
    implementation (AndroidX.LIFECYCLE_LIVEDATA)

    // Retrofit
    implementation (Retrofit.RETROFIT)
    implementation (Retrofit.CONVERTER_GSON)
    implementation (Retrofit.CONVERTER_JAXB)

    //okHttp
    implementation (OkHttp.OKHTTP)
    implementation (OkHttp.LOGGING_INTERCEPTOR)

    //coroutines
    implementation (Coroutines.COROUTINES)

    //by viewModel
    implementation (AndroidX.ACTIVITY)
    implementation (AndroidX.FRAGMENT)

    //nav component
    implementation (NavComponent.NAVIGATION_FRAGMENT)
    implementation (NavComponent.NAVIGATION_UI)
    implementation (NavComponent.NAVIGATION_DYNAMIC_FEATURES_FRAGMENT)
    androidTestImplementation (NavComponent.NAVIGATION_TESTING)
    implementation (NavComponent.NAVIGATION_COMPOSE)

    //datastore
    implementation (AndroidX.DATASTORE)

    implementation (Library.NOTIFICATION_BAR_CUSTOM)
    implementation (Library.COUNT_NUMBER_EVENT)
}