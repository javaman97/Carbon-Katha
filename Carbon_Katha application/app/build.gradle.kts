
import org.jetbrains.kotlin.konan.properties.Properties
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.gms.google-services")

}

android {
    namespace = "project.environment.carby"
    compileSdk = 34

    defaultConfig {
        applicationId = "project.environment.carby"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }


    val properties = readLocalProperties()
    buildTypes {
        debug {
            val localProperties = Properties()
            buildConfigField("String", "apikey",  "\"${properties.getProperty("apikey")}\"")

        }
        release {
            buildConfigField("String", "apikey",  "\"${properties.getProperty("apikey")}\"")

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
    buildFeatures {
        buildConfig = true
        compose = true

    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.ai.client.generativeai:generativeai:0.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    implementation("androidx.compose.material:material:1.6.1")
    implementation("androidx.compose.runtime:runtime:1.6.1")


    //camera settings
    val cameraxVersion = "1.3.0-rc01"

    implementation("androidx.camera:camera-core:$cameraxVersion")
    implementation("androidx.camera:camera-camera2:$cameraxVersion")
    implementation("androidx.camera:camera-lifecycle:$cameraxVersion")
    implementation("androidx.camera:camera-video:$cameraxVersion")

    implementation("androidx.camera:camera-view:$cameraxVersion")
    implementation("androidx.camera:camera-extensions:$cameraxVersion")




    //for chatAI
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")



    //material for icons
    implementation ("androidx.compose.material:material-icons-core:1.7.0-alpha02")
    implementation ("androidx.compose.material:material-icons-extended:1.7.0-alpha02")
    implementation ("androidx.compose.material:material:1.7.0-alpha02")


    //firebase
    implementation ("com.google.firebase:firebase-auth-ktx:22.3.1")
    implementation ("com.google.android.gms:play-services-auth:21.0.0")
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    implementation("com.google.firebase:firebase-analytics")

    //lifecycle dependencies
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation ("androidx.navigation:navigation-compose:2.7.7")
    //coil dependency for fetching data remotely
    implementation ("io.coil-kt:coil-compose:2.2.2")

    //genai
    implementation("com.google.ai.client.generativeai:generativeai:0.2.0")

    implementation("io.coil-kt:coil-compose:2.2.2")  // Latest stable version
    implementation("androidx.navigation:navigation-compose:2.8.0-alpha02")  // Latest stable version
    implementation("com.google.dagger:hilt-android:2.49")


    implementation("androidx.hilt:hilt-navigation-compose:1.2.0-rc01")

//multiple permissions
    implementation ("com.google.android.play:core:1.10.3")

    //accompanist
    implementation ("com.google.accompanist:accompanist-permissions:0.35.0-alpha")
    implementation ("com.google.accompanist:accompanist-navigation-animation:0.35.0-alpha")

}




fun readLocalProperties(): java.util.Properties {

    return  Properties().apply {
        load(rootProject.file("local.properties").reader())
    }
}
