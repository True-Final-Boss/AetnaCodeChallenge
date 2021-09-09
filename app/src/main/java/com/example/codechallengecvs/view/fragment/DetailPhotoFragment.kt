package com.example.codechallengecvs.view.fragment

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.codechallengecvs.R
import com.example.codechallengecvs.databinding.DetailPhotoFragmentBinding
import com.example.codechallengecvs.model.data.DataResponse
import com.example.codechallengecvs.model.data.Item
import com.example.codechallengecvs.viewmodel.FlickrViewModel

class DetailPhotoFragment : Fragment() {

    companion object {
        private const val EXTRA_POSITION = "EXTRA_POSITION"
        fun newInstance(position: Int) =
            DetailPhotoFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_POSITION, position)
                }
            }
    }

    private lateinit var binding: DetailPhotoFragmentBinding
    private var mPosition = 0
    private val viewModel: FlickrViewModel by activityViewModels()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_POSITION, mPosition)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DetailPhotoFragmentBinding.inflate(inflater, container, false)
        mPosition =
            savedInstanceState?.getInt(EXTRA_POSITION) ?: arguments?.getInt(EXTRA_POSITION) ?: 0
        viewModel.flickrData.observe(viewLifecycleOwner) {
            processDataResponse(it)
        }
        return binding.root
    }

    private fun processDataResponse(dataResponse: DataResponse) {
        Log.d("TAG_X", "processDataResponse: ")
        when (dataResponse) {
            is DataResponse.Success -> displayDataSuccess(dataResponse.data[mPosition])
            is DataResponse.Error -> displayDataError(dataResponse.message)
            is DataResponse.Loading -> isLoading(true)
        }
    }

    private fun isLoading(isLoading: Boolean) {

    }

    private fun displayDataError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    private fun displayDataSuccess(item: Item) {
        Log.d("TAG_X", "displayDataSuccess: ")
        Glide.with(binding.root.context).load(item.media.m).into(binding.flickrImageDetail)
        binding.flickrAuthorDetail.text = context?.getString(R.string.author, item.author)
        binding.flickrDescDetail.text = Html.fromHtml(context?.getString(R.string.detail,
        item.description))
        binding.flickrHeightDetail.text = context?.getString(R.string.height, binding.flickrImageDetail.height.toString())
        binding.flickrWidthDetail.text = context?.getString(R.string.height, binding.flickrImageDetail.width.toString())
        binding.flickrTitleDetail.text = context?.getString(R.string.title, item.title)
    }

}