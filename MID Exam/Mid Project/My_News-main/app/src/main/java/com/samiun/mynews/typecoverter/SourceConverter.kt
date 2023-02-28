package com.samiun.mynews.typecoverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.samiun.mynews.data.ArticleEntity
import com.samiun.mynews.model.Article
import com.samiun.mynews.model.Source

class SourceConverter {
    @TypeConverter
    fun longToSource(source: Source?):String?{
        if(source!=null){
            return "${source.id}:${source.name}"
        }
        return null
    }
    @TypeConverter
    fun fromString(value: String?): Source? {
        if (value == null) {
            return null
        }
        val parts = value.split(":")
        return Source(parts[0], parts[1])
    }



}