package com.example.android.androidbeer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.androidbeer.models.PubModel
import com.example.android.androidbeer.models.PubTags

@Entity(tableName = "pubs")
data class DatabasePubModel(
    @PrimaryKey
    val name: String,
    val latitude: String,
    val longitude: String,
    val amenity: String,
    val operator: String,
    val website: String,
    val openingHours: String
)

fun List<DatabasePubModel>.asDomainModel(): List<PubModel>{
    return map {
        PubModel(
            latitude = it.latitude,
            longitude = it.longitude,
            pubInfo = PubTags(
                it.amenity,
                it.name,
                it.operator,
                it.website,
                it.openingHours
            )
        )
    }
}