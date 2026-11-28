package com.edaakyil.app.flags.data.network

import com.edaakyil.app.flags.model.MarsPhoto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

/*
You implement the Retrofit service API with the following steps:

    + Create a data source, MarsApiService class.
    + Create a Retrofit object with the base URL and the converter factory to convert strings.
    - Create an interface that explains how Retrofit talks to the web server.
    - Create a Retrofit service and expose the instance to the api service to the rest of the app.
 */

// constant for the base URL for the web service
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val json = Json {
    ignoreUnknownKeys = true
}

// a Retrofit builder that builds and creates a Retrofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()  // to create the Retrofit object

// This interface defines how Retrofit talks to the web server using HTTP requests
interface MarsApiService {
    // This function gets the response string from the web service
    // @GET annotation tells Retrofit that this is a GET request
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

// initialize the Retrofit service
object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}