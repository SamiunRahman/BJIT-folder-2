package com.samiun.mynews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.samiun.mynews.data.ArticleBookmark
import com.samiun.mynews.data.ArticleDatabase
import com.samiun.mynews.data.ArticleEntity
import com.samiun.mynews.data.ArticleRepository

class ArticleViewModel(application: Application): AndroidViewModel(application) {
    val readAllArticle: LiveData<List<ArticleEntity>>
    val readAllBookmark: LiveData<List<ArticleBookmark>>

    private val repository : ArticleRepository

    init {
        val articleDao = ArticleDatabase.getDatabase(application).articleDao()
        repository = ArticleRepository(articleDao)
        readAllArticle = repository.readAllArticle
        readAllBookmark = repository.readAllBookmark

    }

    fun addArticleList(articleEntity: List<ArticleEntity>){
        viewModelScope.launch (Dispatchers.IO){
            repository.addArticle(articleEntity)

        }
    }

    fun addBookmark(articleBookmark: ArticleBookmark){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addArticleBookmark(articleBookmark)
        }
    }
}