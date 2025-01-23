package com.nexdecade.newshub.repository

import com.nexdecade.newshub.util.Constants.Companion.API_KEY
import com.nexdecade.newshub.api.NewsApi
import com.nexdecade.newshub.data.NewsData
import javax.inject.Inject

class NewsDataRepository @Inject constructor(private val newsApi: NewsApi){
    suspend fun getNewsData(): NewsData {
        return newsApi.getNews(apiKey = API_KEY,q="bitcoin")

    }
}