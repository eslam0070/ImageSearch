package com.eso.imagesearch.data

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class GalleryViewModel @ViewModelInject constructor(private val unsplashRepository: UnsplashRepository):ViewModel() {
}