package com.example.android.androidbeer.models

import com.squareup.moshi.Json

data class PubHolder(
    @Json(name = "documents")
    val pubs : ArrayList<PubModel>
){
    fun removePub(position : Int){
        pubs.removeAt(position)
    }
}

data class PubModel(
    @Json(name = "lat")
    val latitude : String,
    @Json(name = "lon")
    val longitude : String,
    @Json(name = "tags")
    val pubInfo: PubTags
)

data class PubTags(
    val amenity : String,
    val name : String,
    val operator : String,
    val website : String,
    @Json(name = "opening_hours")
    val openingHours : String
)