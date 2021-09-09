package com.example.codechallengecvs

import android.app.Application
import com.example.codechallengecvs.model.db.CacheDB
import com.example.codechallengecvs.util.ApplicationSingleton

class FlickrApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        CacheDB.instantiate(this)
        ApplicationSingleton.cache = CacheDB.getDAO()
    }

}