package com.example.codechallengecvs.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.codechallengecvs.model.data.DataResponse
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FlickrViewModelTest{

    private lateinit var subjectUnderTest: FlickrViewModel
    @get:Rule
    var instantExecutorRule= InstantTaskExecutorRule()

    @Before
    fun setup(){
        subjectUnderTest = FlickrViewModel()
    }

    @Test
    fun `test happy path`(){
        assertNotNull(subjectUnderTest)
        val observer = Observer<DataResponse>{}

        try{
            // observe forever
            subjectUnderTest.flickrData.observeForever(observer)
            // when searching tag
            subjectUnderTest.searchTag("house")
            // then new DataResponse
            val response = subjectUnderTest.flickrData.value
            assertNotNull(response)
        }finally {
            subjectUnderTest.flickrData.removeObserver(observer)
        }
    }
}