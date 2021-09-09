package com.example.codechallengecvs.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallengecvs.R
import com.example.codechallengecvs.databinding.ActivityMainBinding
import com.example.codechallengecvs.model.data.DataResponse
import com.example.codechallengecvs.model.data.Item
import com.example.codechallengecvs.model.network.FlickrService
import com.example.codechallengecvs.view.adapter.FlickrAdapter
import com.example.codechallengecvs.view.fragment.DetailPhotoFragment
import com.example.codechallengecvs.viewmodel.FlickrViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), FlickrAdapter.OnItemClick {
    private lateinit var binding: ActivityMainBinding

    private lateinit var flickrRv: RecyclerView

    private val viewModel: FlickrViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.init(FlickrService.service)
        viewModel.flickrData.observe(this, {


            when(it){
                is DataResponse.Success -> {
                    //hide progress Dialog
                    Log.d("TAG_X", it.data.toString())
                    updateData(it.data)
                }
                is DataResponse.Loading -> {
                    //Show progress Dialog
                    Log.d("TAG_X", "Loading")
                    updateLoading(true)
                }

                is DataResponse.Error -> {
                    //hideProgressDialog
                    Log.d("TAG_X", "Error ${it.message}")
                    Snackbar.make(binding.root, it.message, Snackbar.LENGTH_LONG).show()
                }


            }


        })

        binding.flickrSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        viewModel.searchTag(query)
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            }
        )

        viewModel.searchTag("house")
    }

    private fun updateLoading(isLoading: Boolean) {
        Log.d("TAG_X", "updateLoading: $isLoading")
        if (isLoading)
            binding.progressBar.visibility = View.VISIBLE
        else
            binding.progressBar.visibility = View.GONE
    }

    override fun openDetails(dataPosition: Int) {
        Log.d("TAG_X", "openDetails: $dataPosition")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_details, DetailPhotoFragment.newInstance(dataPosition))
            .addToBackStack(null)
            .commit()
    }

    private fun updateData(data: List<Item>){
        updateLoading(false)
        binding.flickrRv.layoutManager = GridLayoutManager(this, 2)
        val adapter = FlickrAdapter(this)
        binding.flickrRv.adapter = adapter
        adapter.data = data
    }
}