package com.example.android.androidbeer.models

data class PubHolder(
    val elements : ArrayList<PubModel>
){
    fun removePub(position : Int){
        elements.removeAt(position)
    }
}

data class PubModel(
    val lat : String,
    val lon : String,
    val tags: PubTags
)

data class PubTags(
    val amenity : String,
    val name : String,
    val operator : String,
    val website : String,
    val opening_hours : String
)