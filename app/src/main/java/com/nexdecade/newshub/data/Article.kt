package com.nexdecade.newshub.data



import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Keep
@Entity(
tableName="articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
):Serializable