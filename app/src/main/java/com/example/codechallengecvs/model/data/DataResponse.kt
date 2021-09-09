package com.example.codechallengecvs.model.data

sealed class DataResponse{

    data class Success(val data: List<Item>): DataResponse()
    data class Error(val message: String): DataResponse()
    object Loading: DataResponse()

}