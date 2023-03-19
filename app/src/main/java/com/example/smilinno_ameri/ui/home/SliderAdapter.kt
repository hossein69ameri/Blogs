package com.example.smilinno_ameri.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.smilinno_ameri.databinding.ImageSliderItemBinding
import com.example.smilinno_ameri.model.ResponseSliders
import com.example.smilinno_ameri.model.ResponseSliders.ResponseSlidersItem
import javax.inject.Inject

class SliderAdapter @Inject constructor() : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {
    private lateinit var binding : ImageSliderItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ImageSliderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        fun setData(item: ResponseSlidersItem) {
            binding.imageview.load(item.path)
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<ResponseSlidersItem>() {
        override fun areItemsTheSame(oldItem: ResponseSlidersItem, newItem: ResponseSlidersItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResponseSlidersItem, newItem: ResponseSlidersItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)




}