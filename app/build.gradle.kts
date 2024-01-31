plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.smart_shop"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.smart_shop"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // dependencies section firestore
    implementation ("com.google.firebase:firebase-firestore:22.0.1")
    //dependencies section firestore
    // firebase storage dependency
    implementation ("com.google.firebase:firebase-storage:19.1.0")
    // firebase storage dependency

    // Add the dependency for the Realtime Database library
    implementation("com.google.firebase:firebase-database")
    // Add the dependency for the Realtime Database library

// image from the gallery or clicking an image from the camera.
    implementation ("androidx.recyclerview:recyclerview:1.1.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")
    //image from the gallery or clicking an image from the camera.

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies

    implementation ("io.github.chaosleung:pinview:1.4.4")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-analytics")
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.android.car.ui:car-ui-lib:2.5.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //---Create Fragment Using Bottom Navigation in Social Media Android--//
    implementation ("com.google.android.material:material:1.2.0")
    //---Create Fragment Using Bottom Navigation in Social Media Android--//

    //help firebase to open the browser for reCAPTCHA verification.
    implementation( "androidx.browser:browser:1.2.0")


}