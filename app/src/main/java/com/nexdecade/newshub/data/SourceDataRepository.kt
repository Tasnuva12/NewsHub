package com.nexdecade.newshub.data

import com.nexdecade.newshub.Constants.Companion.API_KEY
import javax.inject.Inject

class SourceDataRepository @Inject constructor(private val newsApi:NewsApi) {

    suspend fun getSourceData(): SourceData{
        return newsApi.getSources(API_KEY)
    }
}