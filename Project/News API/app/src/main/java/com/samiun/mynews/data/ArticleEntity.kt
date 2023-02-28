package com.samiun.mynews.data
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.samiun.mynews.model.Source
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "article_table")
class ArticleEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val bookmark: Boolean,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?): Parcelable {
}