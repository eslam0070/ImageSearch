package com.eso.imagesearch.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.eso.imagesearch.R
import com.eso.imagesearch.data.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment :Fragment(R.layout.fragment_gallery){

    private val viewModels by viewModels<GalleryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModels.photos.observe(viewLifecycleOwner){

        }
    }
}