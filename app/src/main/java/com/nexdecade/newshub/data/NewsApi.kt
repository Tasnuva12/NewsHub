package com.nexdecade.newshub.data

import retrofit2.http.GET

interface NewsApi {
    @GET("posts")
    suspend fun postApi(): List<Post>
    
}