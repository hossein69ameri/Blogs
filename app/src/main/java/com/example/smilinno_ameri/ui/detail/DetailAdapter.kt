package com.example.smilinno_ameri.ui.detail


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.smilinno_ameri.databinding.ImageSliderItemBinding
import com.example.smilinno_ameri.databinding.ItemCommentDetailBinding
import com.example.smilinno_ameri.databinding.ItemLatestBlogBinding
import com.example.smilinno_ameri.databinding.ItemPopularBlogBinding
import com.example.smilinno_ameri.model.ResponseDetail
import com.example.smilinno_ameri.model.ResponseDetail.Comment
import com.example.smilinno_ameri.model.ResponseLatest
import com.example.smilinno_ameri.model.ResponseLatest.ResponseLatestItem
import com.example.smilinno_ameri.model.ResponsePopular
import com.example.smilinno_ameri.model.ResponsePopular.ResponsePopularItem
import com.example.smilinno_ameri.model.ResponseSliders
import com.example.smilinno_ameri.model.ResponseSliders.ResponseSlidersItem
import javax.inject.Inject

class DetailAdapter @Inject constructor() : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    private lateinit var binding : ItemCommentDetailBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemCommentDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        fun setData(item: Comment) {
            binding.apply {
                avatarCommentDetail.load(item.avatar)
                usernameCommentDetail.text = item.username
                bodyCommentDetail.text = item.body
            }

        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)




}