package com.shoppingmallexam.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.shoppingmallexam.api.ShoppingApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShoppingRepository @Inject constructor(private val shoppingApi: ShoppingApi) {

    fun getResult(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { ShoppingPagingSource(shoppingApi, query) }
        ).liveData

}