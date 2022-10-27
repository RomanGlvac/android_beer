package com.example.android.androidbeer.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.androidbeer.database.PubDatabase
import com.example.android.androidbeer.database.asDomainModel
import com.example.android.androidbeer.models.PubHolder
import com.example.android.androidbeer.models.asDatabaseModel
import com.example.android.androidbeer.network.Api
import com.example.android.androidbeer.network.Request
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PubRepository(private val database: PubDatabase) {

    private val TAG = "PUB_REPOSITORY"

    val pubs: LiveData<PubHolder> = Transformations.map(database.pubDao.getAll()) {
        it.asDomainModel()
    }

    suspend fun refreshPubs() {
        try{
            withContext(Dispatchers.IO) {
                val data = Api.retrofitService.getPubs(
                    Request(
                        collection = "bars",
                        database = "mobvapp",
                        dataSource = "Cluster0"
                    )
                )
                database.pubDao.insert(data.asDatabaseModel())
            }
        } catch (exception: Exception){
            Log.e(TAG, "${exception.javaClass.canonicalName} - ${exception.message.toString()}")
        }

    }

    fun deletePub(position: Int) {
        pubs.value?.removePub(position)
    }
}