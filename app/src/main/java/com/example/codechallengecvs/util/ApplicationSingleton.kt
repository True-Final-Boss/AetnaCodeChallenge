package com.example.codechallengecvs.util

import com.example.codechallengecvs.model.db.CacheDao

class ApplicationSingleton {
    companion object{
        lateinit var cache: CacheDao
    }
}