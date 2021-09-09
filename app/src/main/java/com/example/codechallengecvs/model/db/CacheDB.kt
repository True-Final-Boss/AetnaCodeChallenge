package com.example.codechallengecvs.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.codechallengecvs.model.data.CacheItem


@Database(entities = [CacheItem::class], version = 1)
abstract class CacheDB: RoomDatabase() {

    abstract fun getDAO(): CacheDao
    companion object{
        private lateinit var cacheInstance: CacheDB
        fun instantiate(context: Context){
            cacheInstance = Room.databaseBuilder(
                context,
                CacheDB::class.java,
                "cache.db"
            ).build()
        }
        fun getDAO(): CacheDao = cacheInstance.getDAO()
    }
}