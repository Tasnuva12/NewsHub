package com.nexdecade.newshub.models



import androidx.annotation.Keep
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Keep
@Entity(
tableName="articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)

    var id:Int=0,

    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    @Embedded(prefix = "source_")
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
):Serializable