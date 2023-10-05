plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
    //id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android")
    id ("com.google.devtools.ksp")

}
android {
    namespace = "com.mtoz147.artbooktestinghilt"
    compileSdk = 34

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    defaultConfig {
        applicationId = "com.mtoz147.artbooktestinghilt"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunner ="com.mtoz147.artbooktestinghilt.HiltTestRunner"

        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }

        /*javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true"
                )
            }
        }*/
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


    dependencies {
        implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

        implementation("com.google.dagger:hilt-android:2.48")

        //kapt("com.google.dagger:hilt-android-compiler:2.48")
        ksp("com.google.dagger:hilt-android-compiler:2.48")

        //kapt ("androidx.hilt:hilt-compiler:1.0.0")
        /*implementation ("androidx.legacy:legacy-support-v4:1.0.0")
        implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")*/


        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")


        val lifecycleVersion = "2.6.2"

        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
        implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
        implementation ("androidx.activity:activity-ktx:1.7.2")

        implementation ("androidx.room:room-runtime:2.5.2")
        //kapt ("androidx.room:room-compiler:2.5.2")
        ksp ("androidx.room:room-compiler:2.5.2")
        implementation ("androidx.room:room-ktx:2.5.2")
        ksp("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")

        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.google.code.gson:gson:2.9.0")
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")

        val navVersion = "2.7.3"
        implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
        implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

        implementation ("com.github.bumptech.glide:glide:4.16.0")
        //kapt("com.github.bumptech.glide:compiler:4.13.2")
        ksp("com.github.bumptech.glide:compiler:4.16.0")
        implementation (platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))

        //implementation("net.bytebuddy:byte-buddy-android:1.14.6")

        // TestImplementations
        implementation ("androidx.test:core:1.5.0")
        testImplementation ("junit:junit:4.13.2")
        testImplementation ("org.hamcrest:hamcrest-all:1.3")
        testImplementation ("androidx.arch.core:core-testing:2.2.0")
        testImplementation ("org.robolectric:robolectric:4.8.1")
        testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
        testImplementation ("com.google.truth:truth:1.1.4")
        testImplementation ("org.mockito:mockito-core:5.5.0")

        // Android Test Implementations
        androidTestImplementation ("junit:junit:4.13.2")
        androidTestImplementation("org.mockito:mockito-core:5.5.0")
        androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
        androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")
        androidTestImplementation ("com.google.truth:truth:1.1.4")

        androidTestImplementation ("com.google.dagger:hilt-android-testing:2.48")
        androidTestImplementation ("com.google.android.apps.common.testing.accessibility.framework:accessibility-test-framework:4.0.0")
        implementation("org.mockito:mockito-android:5.5.0")
        //kaptAndroidTest ("com.google.dagger:hilt-android-compiler:2.48")
        kspAndroidTest ("com.google.dagger:hilt-android-compiler:2.48")
        debugImplementation ("androidx.fragment:fragment-testing:1.7.0-alpha05")

        androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1")



    }

    /*kapt {
        correctErrorTypes = true
    }*/

}