package com.nexdecade.newshub.data

import javax.inject.Inject

class PostRepository @Inject constructor(
    private val newsApi: NewsApi
){
//    suspend fun getPosts(): List<Post>{
//        return newsApi.postApi()
//    }
}