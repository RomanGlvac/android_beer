package com.example.android.androidbeer.models

data class Pubs(
    val elements : ArrayList<PubModel>
)

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