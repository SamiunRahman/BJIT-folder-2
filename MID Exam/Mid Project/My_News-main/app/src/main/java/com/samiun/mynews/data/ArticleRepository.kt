package com.samiun.mynews.data

import androidx.lifecycle.LiveData
import com.samiun.mynews.model.Article

class ArticleRepository(private val articleDao: ArticleDao) {
    val readAllArticle: LiveData<List<ArticleEntity>> = articleDao.readAllArticle()
    val readAllBookmark: LiveData<List<ArticleBookmark>> = articleDao.readAllBookmarked()

    suspend fun addArticle(articleEntityList: List<ArticleEntity>){
        articleDao.addAllArticle(articleEntityList)
    }

    suspend fun deleteAllArticle(){
        articleDao.deleteAll()
    }

    suspend fun addArticleBookmark(articleBookmark: ArticleBookmark){
        articleDao.addBookmark(articleBookmark)
    }

    suspend fun updateArticleEntity(articleEntity: ArticleEntity){
        articleDao.updateArticle(articleEntity)
    }

    suspend fun delete(articleBookmark: ArticleBookmark) {
        articleDao.deleteBookmark(articleBookmark)
    }


}