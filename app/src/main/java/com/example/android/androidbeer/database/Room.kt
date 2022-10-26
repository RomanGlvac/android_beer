package com.example.android.androidbeer.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.androidbeer.models.PubModel


@Dao
interface PubDao{

    @Query("SELECT * FROM pubs")
    fun getAll() : LiveData<List<DatabasePubModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pubs : List<DatabasePubModel>)

}

@Database(entities = [DatabasePubModel::class], version = 2)
abstract class PubDatabase: RoomDatabase() {
    abstract val pubDao: PubDao

    companion object {
        @Volatile
        var INSTANCE : PubDatabase? = null

        fun getDatabase(context: Context): PubDatabase {
            return INSTANCE ?: synchronized(this){
                val temp = Room
                    .databaseBuilder(context, PubDatabase::class.java, "pubs")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = temp
                return temp
            }
        }
    }
}