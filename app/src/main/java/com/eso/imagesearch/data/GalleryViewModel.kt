package com.eso.imagesearch.data

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn

class GalleryViewModel @ViewModelInject constructor(private val unsplashRepository: UnsplashRepository):ViewModel() {

    companion object{
        private const val DEFAULT_QUERY = "cats"
    }
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos  = currentQuery.switchMap {
        queryString->unsplashRepository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhoto(query:String){
        currentQuery.value = query
    }
}