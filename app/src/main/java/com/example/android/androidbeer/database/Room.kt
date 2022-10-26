package com.example.android.androidbeer.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.androidbeer.models.PubModel


@Dao
interface PubDao{

    @Query("SELECT * FROM pubs")
    suspend fun getAll() : LiveData<List<PubModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pubs : List<PubModel>)

}


abstract class PubDatabase: RoomDatabase() {
    abstract val pubDao: PubDao

    companion object {
        private lateinit var INSTANCE : PubDatabase

        fun getDatabase(context: Context): PubDatabase {
            synchronized(this){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, PubDatabase::class.java, "pubs").build()
                }
                return INSTANCE
            }

        }
    }
}