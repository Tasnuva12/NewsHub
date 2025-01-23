package com.nexdecade.newshub.data



import androidx.annotation.Keep

@Keep
data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)