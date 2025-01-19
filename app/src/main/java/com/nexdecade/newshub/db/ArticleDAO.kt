package com.nexdecade.newshub.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nexdecade.newshub.data.Article


@Dao
interface ArticleDAO {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
}