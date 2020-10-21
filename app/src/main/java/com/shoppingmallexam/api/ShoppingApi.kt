package com.shoppingmallexam.api

import com.shoppingmallexam.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ShoppingApi {

    companion object {                           
        const val BASE_URL = "https://openapi.naver.com/"
        const val CLIENT_ID = "2ce3y4edDmaa_GFRf8cN"
        const val CLIENT_Secret = "4AwVW6xyzi"
    }

    @Headers(
        "X-Naver-Client-Id : $CLIENT_ID",
        "X-Naver-Client-Secret : $CLIENT_Secret"
    )
    @GET("v1/search/blog.json")
    suspend fun searchData(
        @Query("query") query : String,
        @Query("display") display : Int,
        @Query("start") start : Int,
        @Query("sort") sort : String

    ) : ShoppingResponse
}