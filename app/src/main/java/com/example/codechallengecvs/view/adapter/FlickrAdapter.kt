package com.example.codechallengecvs.view.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallengecvs.R
import com.example.codechallengecvs.databinding.FlickrItemBinding
import com.example.codechallengecvs.model.data.Item


class FlickrAdapter(private val onClick: OnItemClick):RecyclerView.Adapter<FlickrViewHolder>() {

    interface OnItemClick{
        fun openDetails(dataPosition: Int)
    }

    var displayList: List<Item> = listOf()

    var data: List<Item> = listOf()
    set(value) {
        field = value
        displayList = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlickrViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.flickr_item,parent,false)
        val view = FlickrItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return FlickrViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: FlickrViewHolder, position: Int) {
        val currentItem = displayList[position]
        holder.bindData(holder.itemView.context,
                        currentItem.media,
                        currentItem.title)

        holder.itemView.setOnClickListener{
            onClick.openDetails(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return displayList.size
    }
}