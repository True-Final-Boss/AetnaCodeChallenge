package com.example.codechallengecvs.model

import android.util.Log
import com.example.codechallengecvs.model.data.CacheItem
import com.example.codechallengecvs.model.data.FlickrResponse
import com.example.codechallengecvs.model.network.FlickrService
import com.example.codechallengecvs.util.ApplicationSingleton
import com.google.gson.Gson

class FlickrRepository {

    companion object {
        private lateinit var flickrService: FlickrService

        fun init(flickrService: FlickrService) {
            this.flickrService = flickrService
        }

        suspend fun checkCache(tag: String): FlickrResponse {
            ApplicationSingleton.cache.checkCache(tag).let {
                Log.d("TAG_X", "....$it.")
                val gson = Gson()
                it?.firstOrNull()?.let { item ->
                    return gson.fromJson(it.first().responseValue, FlickrResponse::class.java)
                } ?: return readFromServer(tag)
            }
        }

        private suspend fun readFromServer(tag: String): FlickrResponse {
            val response = flickrService.getResponseAsync(tag)
            cacheTag(tag, response)
            return response
        }

        suspend fun cacheTag(tag: String, response: FlickrResponse) {
            val value = Gson().toJson(response)
            val cacheItem = CacheItem(tag, value)
            ApplicationSingleton.cache.cacheResponse(cacheItem)
        }
    }
}