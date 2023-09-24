plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
    //Safe args Added, to be sure android.useAndroidX=true in your gradle.properties file
    // kotlin("kapt") version "1.9.10" kapt plugins added
    id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.mtoz147.artbooktestinghilt"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mtoz147.artbooktestinghilt"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_17////java version has been changed
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    //https://developer.android.com/topic/libraries/view-binding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //coroutines components added
    // threading ops.
    //https://github.com/Kotlin/kotlinx.coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    //navigation components added
    //https://developer.android.com/jetpack/androidx/releases/navigation
    val nav_version = "2.6.0"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //https://developer.android.com/training/dependency-injection/hilt-android
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    //https://developer.android.com/training/dependency-injection/hilt-jetpack
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")

    //lifecycle components added
    //https://developer.android.com/jetpack/androidx/releases/lifecycle
    val lifecycle_version = "2.6.2"
    val arch_version = "2.2.0"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    // optional - Test helpers for LiveData
    testImplementation("androidx.arch.core:core-testing:$arch_version")
    // optional - Test helpers for Lifecycle runtime
    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")


    //Room components added
    //Sqlite and Local database section
    //https://developer.android.com/jetpack/androidx/releases/room
    val room_version = "2.5.2"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // To use Kotlin annotation processing tool (kapt)
    //https://kotlinlang.org/docs/kapt.html#annotation-processor-arguments
    kapt("androidx.room:room-compiler:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")


    //retrofit components added
    //  to exchange data with web as synchronize or asynchronous
    //https://github.com/square/retrofit/tree/master
    //https://github.com/square/retrofit/tree/master/retrofit-converters/gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //https://github.com/square/retrofit/tree/master/retrofit-adapters/rxjava3
    //https://github.com/ReactiveX/RxJava for latest version
    //implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")


    //Glide components added
    //to download and to show picture from web (alternative picasso)
    //https://github.com/bumptech/glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")

    // TestImplementations
    implementation ("androidx.test:core:1.5.0")
    testImplementation ("junit:junit:4.13.2")

    testImplementation ("org.hamcrest:hamcrest-all:1.3")

    testImplementation ("androidx.arch.core:core-testing:2.2.0")

    testImplementation ("org.robolectric:robolectric:4.8.1")

    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    //https://truth.dev/
    testImplementation ("com.google.truth:truth:1.1.4")

    testImplementation ("org.mockito:mockito-core:4.7.0")

// Android Test Implementations
    androidTestImplementation ("junit:junit:4.13.2")
    //androidTestImplementation "com.linkedin.dexmaker:dexmaker-mockito:2.12.1"
    androidTestImplementation ("org.mockito:mockito-android:4.7.0")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ("com.google.truth:truth:1.1.4")

    //https://developer.android.com/training/testing/espresso/setup
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    androidTestImplementation ("org.mockito:mockito-core:4.7.0")
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.43.2")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:2.48")

    //https://developer.android.com/jetpack/androidx/releases/fragment
    debugImplementation ("androidx.fragment:fragment-testing:1.6.1")//new version is needed to sdk 34











}