package com.samiun.mynews.data
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.samiun.mynews.model.Source
import com.samiun.mynews.typecoverter.SourceConverter
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "article_table")
class ArticleEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val type: String,
    var bookmark: Boolean,
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