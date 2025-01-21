package com.nexdecade.newshub.models



import androidx.annotation.Keep

@Keep
data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)