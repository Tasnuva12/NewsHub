package com.nexdecade.newshub.repository

import com.nexdecade.newshub.util.Constants.Companion.API_KEY
import com.nexdecade.newshub.api.NewsApi
import com.nexdecade.newshub.data.SourceData
import javax.inject.Inject

class SourceDataRepository @Inject constructor(private val newsApi: NewsApi) {

    suspend fun getSourceData(): SourceData {
        return newsApi.getSources(API_KEY)
    }
}