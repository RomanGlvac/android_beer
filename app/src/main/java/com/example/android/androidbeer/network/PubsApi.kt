package com.example.android.androidbeer.network

import com.example.android.androidbeer.models.PubHolder
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


private const val URL = "https://data.mongodb-api.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(URL)
    .build()

interface ApiServices {

    @Headers("api-key: KHUu1Fo8042UwzczKz9nNeuVOsg2T4ClIfhndD2Su0G0LHHCBf0LnUF05L231J0M",
        "Access-Control-Request-Headers: *",
        "Content-Type: application/json")
    @POST("app/data-fswjp/endpoint/data/v1/action/find")
    suspend fun getPubs(@Body request: Request): PubHolder
}

object Api {
    val retrofitService: ApiServices by lazy { retrofit.create(ApiServices::class.java) }
}