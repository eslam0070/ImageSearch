package com.eso.imagesearch.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.eso.imagesearch.api.UnsplashApi
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.max

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {

    fun getSearchResults(query: String) = Pager(
        config = PagingConfig(
            pageSize = 20, maxSize = 100, enablePlaceholders = false
        ),
        pagingSourceFactory = {UnsplashPagingSource(unsplashApi,query)}
    ).liveData

}