package com.example.android.androidbeer.models

import com.example.android.androidbeer.database.DatabasePubModel
import com.google.gson.annotations.SerializedName

data class PubHolder(
    @SerializedName("documents")
    val pubs : ArrayList<PubModel>
){
    fun removePub(position : Int){
        pubs.removeAt(position)
    }
}

data class PubModel(
    @SerializedName("lat")
    val latitude : String,
    @SerializedName("lon")
    val longitude : String,
    @SerializedName("tags")
    val pubInfo: PubTags
)

data class PubTags(
    val amenity : String,
    val name : String,
    val operator : String,
    val website : String,
    @SerializedName("opening_hours", alternate = ["opening_hours:covid19"])
    val openingHours : String
)

fun PubHolder.asDatabaseModel(): List<DatabasePubModel> {
    return pubs.map {
        DatabasePubModel(
            name = it.pubInfo.name,
            latitude = it.latitude,
            longitude = it.longitude,
            amenity = it.pubInfo.amenity,
            operator = it.pubInfo.operator,
            website = it.pubInfo.website,
            openingHours = it.pubInfo.openingHours
        )
    }
}
