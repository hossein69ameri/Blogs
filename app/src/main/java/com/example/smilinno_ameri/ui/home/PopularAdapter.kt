package com.example.smilinno_ameri.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.smilinno_ameri.databinding.ImageSliderItemBinding
import com.example.smilinno_ameri.databinding.ItemLatestBlogBinding
import com.example.smilinno_ameri.databinding.ItemPopularBlogBinding
import com.example.smilinno_ameri.model.ResponseLatest
import com.example.smilinno_ameri.model.ResponseLatest.ResponseLatestItem
import com.example.smilinno_ameri.model.ResponsePopular
import com.example.smilinno_ameri.model.ResponsePopular.ResponsePopularItem
import com.example.smilinno_ameri.model.ResponseSliders
import com.example.smilinno_ameri.model.ResponseSliders.ResponseSlidersItem
import javax.inject.Inject

class PopularAdapter @Inject constructor() : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    private lateinit var binding : ItemPopularBlogBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemPopularBlogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        fun setData(item: ResponsePopularItem) {
            binding.imgPopularBlog.load(item.path){
                crossfade(true)
                crossfade(500)
            }
            binding.titlePopularBlog.text = item.title
            binding.datePopularBlog.text = item.date
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<ResponsePopularItem>() {
        override fun areItemsTheSame(oldItem: ResponsePopularItem, newItem: ResponsePopularItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResponsePopularItem, newItem: ResponsePopularItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)




}