package com.nexdecade.newshub.data

import retrofit2.http.GET

interface NewsApi {
    @GET("posts")
    suspend fun postApi(): List<Post>

    @GET("/v2/top-headlines/sources")
    suspend fun getSources():List<SourceData>

}