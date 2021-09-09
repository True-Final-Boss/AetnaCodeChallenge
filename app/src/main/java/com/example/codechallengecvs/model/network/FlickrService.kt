package com.example.codechallengecvs.model.network

import com.example.codechallengecvs.model.data.FlickrResponse
import com.example.codechallengecvs.util.Constants.Companion.BASEURL
import com.example.codechallengecvs.util.Constants.Companion.ENDPOINT
import com.example.codechallengecvs.util.Constants.Companion.TAG_QUERY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrService {

    @GET(ENDPOINT)
    suspend fun getResponseAsync(@Query(TAG_QUERY) tag: String): FlickrResponse

    companion object {
        private fun buildRetrofit(): Retrofit = Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: FlickrService = buildRetrofit().create(FlickrService::class.java)
    }
}