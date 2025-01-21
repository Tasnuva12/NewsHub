package com.nexdecade.newshub.data

import com.nexdecade.newshub.models.NewsData
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
//    @GET("posts")
//    suspend fun postApi(): List<Post>

    @GET("/v2/top-headlines/sources")
    suspend fun getSources(@Query("apiKey") apiKey:String):SourceData

    @GET("/v2/everything")
    suspend fun getNews(
        @Query("q")q: String,
        @Query("apiKey")apiKey: String
    ): NewsData


}