package com.example.android.androidbeer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.androidbeer.models.PubHolder
import com.example.android.androidbeer.models.PubModel
import com.example.android.androidbeer.models.PubTags

@Entity(tableName = "pubs")
data class DatabasePubModel(
    @PrimaryKey
    val id: String,
    val name: String?,
    val latitude: String,
    val longitude: String,
    val amenity: String?,
    val operator: String?,
    val website: String?,
    val openingHours: String?
)

fun List<DatabasePubModel>.asDomainModel(): PubHolder{
    val pubList = map {
        PubModel(
            id = it.id,
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
    return PubHolder(pubList as ArrayList<PubModel>)
}