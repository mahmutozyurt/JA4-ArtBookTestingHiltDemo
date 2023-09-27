package com.mtoz147.artbooktestinghilt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.mtoz147.artbooktestinghilt.databinding.ArtRowBinding
import com.mtoz147.artbooktestinghilt.databinding.ImageRowBinding
import com.mtoz147.artbooktestinghilt.model.Art
import javax.inject.Inject

class ImageRecyclerAdapter @Inject constructor(
    val glide:RequestManager
):RecyclerView.Adapter<ImageRecyclerAdapter.ImageViewHolder>(){

    private var onItemClickListener:((String)->Unit)?=null
    inner class ImageViewHolder(private val binding:ImageRowBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(url: String) {
            binding.apply {
                glide.load(url).into(singleArtImageView)
                root.setOnClickListener {
                    onItemClickListener?.invoke(url)
                }



            }
        }

    }

    fun setOnItemClickListener(listener:(String)->Unit){
        onItemClickListener=listener
    }


    //It calculates the difference between two lists and updates the ones that are different.
    private val diffUtil=object : DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }
    }

    private val recyclerListDiffer= AsyncListDiffer(this,diffUtil)

    var images:List<String>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding= ImageRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val url=images[position]
        holder.bind(url)
    }

}