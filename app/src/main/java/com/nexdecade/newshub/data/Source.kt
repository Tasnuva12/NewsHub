package com.nexdecade.newshub.data


import androidx.annotation.Keep
import androidx.room.ColumnInfo

@Keep
data class Source(
    @ColumnInfo(name = "source_id")
    val id: String,
    val name: String
)