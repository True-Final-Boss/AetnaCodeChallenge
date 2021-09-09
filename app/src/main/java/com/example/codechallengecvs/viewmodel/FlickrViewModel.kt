package com.example.codechallengecvs.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallengecvs.model.FlickrRepository
import com.example.codechallengecvs.model.data.DataResponse
import com.example.codechallengecvs.model.network.FlickrService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FlickrViewModel : ViewModel() {

    private val _flickrData = MutableLiveData<DataResponse>()

    val flickrData: LiveData<DataResponse>
        get() = _flickrData

    fun init(service: FlickrService) {
        FlickrRepository.init(service)
    }

    fun searchTag(tag: String) {
        _flickrData.value = DataResponse.Loading

        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            try {
                val response = FlickrRepository.checkCache(tag)
                Log.d("TAG_X", "Attempting")
                _flickrData.postValue(DataResponse.Success(response.items))
            } catch (e: Exception) {
                Log.d("ERROR", e.toString())
                _flickrData.postValue(DataResponse.Error(e.message ?: e.localizedMessage))
            }
        }
    }
}