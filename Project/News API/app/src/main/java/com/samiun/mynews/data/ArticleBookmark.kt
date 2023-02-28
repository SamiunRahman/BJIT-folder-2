package com.samiun.mynews.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.samiun.mynews.model.Source
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "bookmark_table")
class ArticleBookmark (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?): Parcelable {
}