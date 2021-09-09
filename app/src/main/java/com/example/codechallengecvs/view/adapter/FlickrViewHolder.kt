package com.example.codechallengecvs.view.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codechallengecvs.R
import com.example.codechallengecvs.databinding.FlickrItemBinding
import com.example.codechallengecvs.model.data.Media

class FlickrViewHolder(private val binding: FlickrItemBinding):RecyclerView.ViewHolder(binding.root)  {
   //ask about this private lateinit var binding: ActivityMainBinding

//    val itemImage: ImageView = view.findViewById(R.id.flickr_image)
//    val iTitle: TextView = view.findViewById(R.id.image_title)

    fun bindData(context: Context, media: Media, title: String){
        media?.let{
            Glide.with(context)
                 .load(media.m)
                 .into(binding.flickrImage)
        }

        binding.imageTitle.text = context.getString(R.string.title,title)
    }

}