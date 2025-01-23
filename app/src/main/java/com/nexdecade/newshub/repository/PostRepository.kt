package com.nexdecade.newshub.repository

import com.nexdecade.newshub.api.NewsApi
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val newsApi: NewsApi
){
//    suspend fun getPosts(): List<Post>{
//        return newsApi.postApi()
//    }
}