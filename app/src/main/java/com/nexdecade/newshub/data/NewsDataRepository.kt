package com.nexdecade.newshub.data

import com.nexdecade.newshub.Constants.Companion.API_KEY
import com.nexdecade.newshub.models.NewsData
import javax.inject.Inject

class NewsDataRepository @Inject constructor(private val newsApi:NewsApi){
    suspend fun getNewsData(): NewsData {
        return newsApi.getNews(apiKey = API_KEY,q="bitcoin")

    }
}