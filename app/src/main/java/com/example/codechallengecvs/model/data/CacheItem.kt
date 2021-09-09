package com.example.codechallengecvs.model.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "flicker_cache")
data class CacheItem(
    @PrimaryKey
    var tag: String,
    var responseValue: String
)