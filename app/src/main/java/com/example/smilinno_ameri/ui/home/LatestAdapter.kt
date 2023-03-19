package com.example.smilinno_ameri.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.smilinno_ameri.databinding.ImageSliderItemBinding
import com.example.smilinno_ameri.databinding.ItemLatestBlogBinding
import com.example.smilinno_ameri.model.ResponseLatest
import com.example.smilinno_ameri.model.ResponseLatest.ResponseLatestItem
import com.example.smilinno_ameri.model.ResponseSliders
import com.example.smilinno_ameri.model.ResponseSliders.ResponseSlidersItem
import javax.inject.Inject

class LatestAdapter @Inject constructor() : RecyclerView.Adapter<LatestAdapter.ViewHolder>() {
    private lateinit var binding : ItemLatestBlogBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemLatestBlogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: ResponseLatestItem) {
            binding.imgLatestBlog.load(item.path){
                crossfade(true)
                crossfade(500)
            }
            binding.titleLatestBlog.text = item.title
            binding.dateLatestBlog.text = item.date
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<ResponseLatestItem>() {
        override fun areItemsTheSame(oldItem: ResponseLatestItem, newItem: ResponseLatestItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResponseLatestItem, newItem: ResponseLatestItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)




}