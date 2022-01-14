package com.example.amphibians.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

// Create a property for the base URL provided in the codelab
val BASE_URL =
    "https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/"

/*
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using to parse JSON
 * Moshi is an Android JSON parser that converts a JSON string into Kotlin objects.
 */
val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Build a Retrofit object with the Moshi converter
val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//Declare a suspended function to get the list of amphibians
interface AmphibianApiService {
    @GET("android-basics-kotlin-unit-4-pathway-2-project-api.json")
    suspend fun getAmphibians(): List<Amphibian>
}

// Create an object that provides a lazy-initialized retrofit service
object AmphibiansApi {
    val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }
}

