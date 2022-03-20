package com.eso.imagesearch.api

import com.eso.imagesearch.data.UnsplashPhoto

data class UnsplashResponse(
    val result: List<UnsplashPhoto>
)
