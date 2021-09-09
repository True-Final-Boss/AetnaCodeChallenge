package com.example.codechallengecvs.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.codechallengecvs.model.data.CacheItem

@Dao
interface CacheDao {

    @Query("SELECT * FROM flicker_cache WHERE tag = :tag")
    suspend fun checkCache(tag: String): List<CacheItem>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun cacheResponse(cacheItem: CacheItem)
}