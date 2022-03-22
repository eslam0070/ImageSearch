package com.eso.imagesearch.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.eso.imagesearch.R
import com.eso.imagesearch.data.UnsplashPhoto
import com.eso.imagesearch.databinding.ItemPhotoBinding

class UnsplashPhotoAdapter:
    PagingDataAdapter<UnsplashPhoto,UnsplashPhotoAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    companion object{
        private val PHOTO_COMPARATOR = object :DiffUtil.ItemCallback<UnsplashPhoto>(){
            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =oldItem.id == newItem.id


            override fun areContentsTheSame(
                oldItem: UnsplashPhoto,
                newItem: UnsplashPhoto) = oldItem == newItem

        }
    }


    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null)
            holder.bind(currentItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhotoViewHolder(binding)
    }

    class PhotoViewHolder(private val binding:ItemPhotoBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(photo: UnsplashPhoto){
            binding.apply {
                Glide.with(itemView).load(photo.urls.regular).centerCrop().transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error).into(imageView)
                textViewUserName.text = photo.user.username
            }
        }
    }
}