package com.samiun.mynews.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAllArticle(articleEntity: List<ArticleEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBookmark(articleBookmark: ArticleBookmark)

    @Query("DELETE FROM article_table")
    suspend fun deleteAll()

    @Query("select * from article_table order by id desc")
     fun readAllArticle(): LiveData<List<ArticleEntity>>

    @Query("select * from bookmark_table order by id")
     fun readAllBookmarked(): LiveData<List<ArticleBookmark>>

    @Update
    suspend fun updateArticle(articleEntity: ArticleEntity)

    @Delete
    suspend fun deleteBookmark(articleBookmark: ArticleBookmark)

}
