package com.shoppingmallexam.data

import androidx.paging.PagingSource
import com.shoppingmallexam.api.ShoppingApi
import retrofit2.HttpException
import java.io.IOException


private const val SHOPPING_STARTING_PAGE_INDEX = 1
private const val SHOPPING_PAGING_SIZE = 20
private const val SHOPPING_PAGING_SORT_SIM = "sim"
private const val SHOPPING_PAGING_SORT_DATE = "date"


class ShoppingPagingSource(
    private val shoppingApi: ShoppingApi,
    private val query: String
) : PagingSource<Int, ShoppingData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShoppingData> {
        val position = params.key ?: SHOPPING_STARTING_PAGE_INDEX

        return try {
            val response = shoppingApi.searchData(query, SHOPPING_PAGING_SIZE, position, SHOPPING_PAGING_SORT_SIM)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == SHOPPING_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
        
    }
}