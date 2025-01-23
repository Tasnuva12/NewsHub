package com.nexdecade.newshub.db

import androidx.room.TypeConverter
import com.nexdecade.newshub.data.Source



class Converters {
    @TypeConverter
    fun fromSource(source:Source):String{
        return source.name
    }
    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name, name)
    }
}