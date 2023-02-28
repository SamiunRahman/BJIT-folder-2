package com.samiun.mynews.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.samiun.mynews.model.Source
import com.samiun.mynews.typecoverter.SourceConverter
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "bookmark_table")
class ArticleBookmark (
    @PrimaryKey
    val id: Int,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    @TypeConverters(SourceConverter::class)
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?) {
}